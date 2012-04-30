package com.oak.babybook.objects;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User extends Person implements Serializable{

	private String username;
	private String password;

	private Set<Event> events;
	private Set<Person> children;
	private Set<Picture> pictures;
	private Set<Page> pages;

	public User(){}

	public User(Long id, String first, String middle, String last, Date dob,
			String email, Gender gender, String username, String password) {
		super(id, first, middle, last, dob, email, gender);
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Event> getEvents() {
		return events;
	}
	public void setEvents(Set<Event> events) {
		this.events = events;
	}
	public void addEvent(Event event) {
		if (events == null){
			events = new HashSet<Event>();
		}
		events.add(event);
	}

	public Set<Person> getChildren() {
		return children;
	}

	public void setChildren(Set<Person> children) {
		this.children = children;
	}
	public void addChild(Person child) {
		if (children == null){
			children = new HashSet<Person>();
		}
		children.add(child);
	}
	@Override
	public Set<Picture> getPictures() {
		return pictures;
	}

	@Override
	public void setPictures(Set<Picture> pictures) {
		this.pictures = pictures;
	}
	@Override
	public void addPicture(Picture picture) {
		if (pictures == null){
			pictures = new HashSet<Picture>();
		}
		pictures.add(picture);
	}

	public Set<Page> getPages() {
		return pages;
	}

	public void setPages(Set<Page> pages) {
		this.pages = pages;
	}

	public void addPage(Page page) {
		if (pages == null){
			pages = new HashSet<Page>();
		}
		pages.add(page);
	}

	@Override
	public String toString() {
		return "User [children=" + children + ", events=" + events + ", password=" + password + ", pictures="
		+ pictures + ", username=" + username + "]";
	}

	@Override
	public String toXML(){
		StringBuffer buffer = new StringBuffer();

		buffer.append("<user>");
		buffer.append("<username>" + username + "</username>");
		buffer.append("<password>" + password + "</password>");
		buffer.append(super.toXML());
		buffer.append("<children>");
		for(Person child: children){
			buffer.append(child.toXML("child"));
		}
		buffer.append("</children>");
		buffer.append("<pictures>");
		for(Picture picture : pictures){
			buffer.append(picture.toXML());
		}
		buffer.append("</pictures>");
		buffer.append("<events>");
		for(Event event : events){
			buffer.append(event.toXML());
		}
		buffer.append("</events>");
		buffer.append("</user>");

		return buffer.toString();
	}

	public Picture getPicture(Long pictID) {
		for(Picture picture : pictures){
			if (picture.getId().equals(pictID)){
				return picture;
			}
		}
		return null;
	}

	public Event getEvent(Long eventID) {
		for(Event event : events){
			if (event.getId().equals(eventID)){
				return event;
			}
		}
		return null;
	}

	public Person getChild(Long childID) {
		for(Person child : children){
			if (child.getId().equals(childID)){
				return child;
			}
		}
		return null;
	}
}
