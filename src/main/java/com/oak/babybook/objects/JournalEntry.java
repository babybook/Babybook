package com.oak.babybook.objects;

import java.util.Date;

public class JournalEntry extends Taggable {

	private String subject;
	private String text;
	private Media media;
	private Date entryDate;


	public JournalEntry(){

	}

	public JournalEntry(Long id, String tags, String subject, String text, Date entryDate) {
		super(id,tags);
		this.subject = subject;
		this.text = text;
		this.entryDate = entryDate;
	}

	public JournalEntry(Long id, String tags, String subject, String text, Media media, Date entryDate) {
		super(id, tags);
		this.subject = subject;
		this.text = text;
		this.media = media;
		this.entryDate = entryDate;
	}


}
