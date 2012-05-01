package com.oak.babybook.objects;

import java.util.Date;
import java.util.List;

public class Journal extends Taggable {

	private String name;
	private Date dateCreated;
	private List<JournalEntry> journalEntries;

	public Journal() {
	}

	public Journal(Long id, String tags, String name, Date dateCreated, List<JournalEntry> journalEntries) {
		super(id, tags);
		this.name = name;
		this.dateCreated = dateCreated;
		this.journalEntries = journalEntries;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final Date getDateCreated() {
		return dateCreated;
	}

	public final void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public final List<JournalEntry> getJournalEntries() {
		return journalEntries;
	}

	public final void setJournalEntries(List<JournalEntry> journalEntries) {
		this.journalEntries = journalEntries;
	}


}
