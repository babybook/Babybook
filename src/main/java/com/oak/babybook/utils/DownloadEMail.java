package com.oak.babybook.utils;

/**
 */

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMessage;

import org.apache.commons.net.ftp.FTPClient;

/**
 * This will connect to our incoming e-mail server and download any e-mails that
 * are found on the server. The e-mails will be stored for further processing in
 * our internal database. Attachments will be written out to separate files and
 * then referred to by the database entries. This is intended to be run by the
 * scheduler every minute or so.
 */
public class DownloadEMail {

	private static final CharSequence HOST_DOMAIN = "oakitfinancial.co.uk";
	protected String receiving_host;
	protected String receiving_user;
	protected String receiving_pass;
	protected String receiving_protocol;
	protected boolean receiving_secure;
	protected boolean ftpFile;
	protected String receiving_attachments;
	protected String ftpHost;
	protected String ftpUsername;
	protected String ftpPassword;

	public DownloadEMail() {

		// pick up our configuration from the server:
		receiving_host = System.getProperty("server.email.receiving.host");
		receiving_user = System.getProperty("server.email.receiving.username");
		receiving_pass = System.getProperty("server.email.receiving.password");
		receiving_protocol = System.getProperty("server.email.receiving.protocol");
		receiving_attachments = System.getProperty("server.email.receiving.attachments");
		ftpFile = new Boolean(System.getProperty("ftp.image")).booleanValue();
		ftpHost = System.getProperty("ftp.host");
		ftpUsername = System.getProperty("ftp.username");
		ftpPassword = System.getProperty("ftp.password");
	}

	/** This will run our logic */
	public void run() throws Exception {

		// Create empty properties
		Properties props = new Properties();
		// Get the session
		Session session = Session.getInstance(props, null);

		// Get the store
		Store store = session.getStore(receiving_protocol);
		try{
			store.connect(receiving_host, receiving_user, receiving_pass);
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("Will try again later.");
			return;
		}

		// Get folder
		Folder folder = store.getFolder("INBOX");
		folder.open(Folder.READ_WRITE);

		try {

			// Get directory listing
			Message messages[] = folder.getMessages();

			for (int i = 0; i < messages.length; i++) {

				MimeMessage message = (MimeMessage) messages[i];

				if (message.getFlags().contains(Flags.Flag.SEEN)){
					continue;
				}

				Address[] toAddresses = message.getRecipients(Message.RecipientType.TO);
				Address[] fromAddresses = message.getFrom();

				System.out.println("Found mail from : " + fromAddresses.toString());
				System.out.println("Subject : " + message.getSubject());
				System.out.println("Sent : " + message.getSentDate());

				for (int j = 0; j < toAddresses.length; j++) {

					// Get the first part of the email address that its been
					// sent to
					Address address = toAddresses[j];

					if (address.toString().contains(HOST_DOMAIN)) {

						String emailAddress = address.toString();
						int start = emailAddress.indexOf("<") + 1;

						if (start < 0){
							start = 0;
						}

						String userName = emailAddress.substring(start, emailAddress.lastIndexOf("@"));

						System.out.println("User name found : " + userName);

						if (this.getAttachment(message, userName)) {
							// Finally delete the message from the server.
							messages[i].setFlag(Flags.Flag.SEEN, true);
						}
					}
				}
			}

			// Close connection
			folder.close(true); // true tells the mail server to expunge deleted
			// messages.
			store.close();
		} catch (Exception e) {
			folder.close(true); // true tells the mail server to expunge deleted
			// messages.
			store.close();
			throw e;
		}

	}

	protected boolean getAttachment(Message message, String userName) throws Exception {

		Object object = message.getContent();

		if (object instanceof Multipart) {

			Multipart multipart = (Multipart) object;

			for (int i = 0, n = multipart.getCount(); i < n; i++) {
				Part part = multipart.getBodyPart(i);

				String disposition = part.getDisposition();

				File savedFile = new File(userName + "-" + part.getFileName());
				String subject = message.getSubject();

				//@TODO - May need to put this images into a db.

				if ((disposition != null)
						&& ((disposition.equals(Part.ATTACHMENT) || (disposition.equals(Part.INLINE))))) {
					saveFile(savedFile, part);

					if (ftpFile) {

						try {
							FTPClient client = new FTPClient();
							FileInputStream fis = null;

							client.connect(ftpHost);
							client.login(ftpUsername, ftpPassword);

							String fileName = message.getSentDate().getTime() + "-" + savedFile.getName().toLowerCase();

							fis = new FileInputStream(savedFile.getAbsoluteFile());
							client.changeWorkingDirectory("public_html");
							client.changeWorkingDirectory("images");
							if (client.changeWorkingDirectory(userName)){
								client.makeDirectory(userName);
							}
							client.setFileType(FTPClient.BINARY_FILE_TYPE);
							client.storeFile(fileName, fis);
							client.logout();
							fis.close();

							System.out.println(fileName + " uploaded.");

						} catch (UnknownHostException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

				}
			}
		}

		return true;
	}

	protected int saveFile(File saveFile, Part part) throws Exception {

		System.out.println("Saving file : " + saveFile.getAbsolutePath());

		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(saveFile));

		byte[] buff = new byte[2048];
		InputStream is = part.getInputStream();
		int ret = 0, count = 0;
		while ((ret = is.read(buff)) > 0) {
			bos.write(buff, 0, ret);
			count += ret;
		}
		bos.close();
		is.close();
		return count;
	}

	protected String decodeName(String name) throws Exception {
		if (name == null || name.length() == 0) {
			return "unknown";
		}
		String ret = java.net.URLDecoder.decode(name, "UTF-8");

		// also check for a few other things in the string:
		ret = ret.replaceAll("=\\?utf-8\\?q\\?", "");
		ret = ret.replaceAll("\\?=", "");
		ret = ret.replaceAll("=20", " ");

		return ret;
	}

	public static void main(String args[]) {
		DownloadEMail downloadEMail = new DownloadEMail();
		try {
			downloadEMail.run();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
