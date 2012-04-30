package com.oak.babybook.services;

import com.oak.babybook.utils.DownloadEMail;

public class EmailAttachmentChecker implements Runnable {

	public EmailAttachmentChecker(){

	}

	@Override
	public void run() {
		System.out.println("Starting EmailAttachmentChecker......");
		DownloadEMail downloadEmail = new DownloadEMail();

		try{
			while(true){
				downloadEmail.run();

				Thread.sleep(10000);
			}
		}catch (Exception e){
			e.printStackTrace();
		}

		System.out.println("Stopping EmailAttachmentChecker......");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable checker = new EmailAttachmentChecker();
		Thread t = new Thread(checker);
		t.start();
	}

}
