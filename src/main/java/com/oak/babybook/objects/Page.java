package com.oak.babybook.objects;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Page extends GeneratedId {

	private static long serialVersionUID = 6681584416819752944L;

	private String name;
	private String description;
	private Date validFrom;
	private Date validTo;
	private Date expiryDate;
	private Set<Event> events;

	public Page() {
	}

	public Page(Long id, String name, String description, Date validFrom, Date validTo, Date expiryDate) {
		super(id);
		this.name = name;
		this.description = description;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.expiryDate = expiryDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	public void addEvent(Event event) {
		if (events == null) {
			events = new HashSet<Event>();
		}
		events.add(event);
	}

}
