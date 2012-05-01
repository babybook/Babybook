package com.oak.babybook.objects;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.oak.babybook.utils.Utilities;

public class Event extends Taggable implements Serializable{

	private String name;
	private String location;
	private String description;
	private Date dateTime;
	private EventType type;
	private String other;
	private Set<Picture> pictures;
	private Set<Person> children;
	private String tags;

	public Event(){}

	public Event(Long id, String tags, String name, String location, String description,
			Date dateTime, EventType type, String other) {
		super(id, tags);
		this.name = name;
		this.location = location;
		this.description = description;
		this.dateTime = dateTime;
		this.type = type;
		this.other = other;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public EventType getType() {
		return type;
	}
	public void setType(EventType type) {
		this.type = type;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public Set<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(Set<Picture> pictures) {
		this.pictures = pictures;
	}
	public void addPicture(Picture picture) {
		if (pictures == null){
			pictures = new HashSet<Picture>();
		}
		pictures.add(picture);
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
	public String toString() {

		return super.toString() + " Event [dateTime=" + dateTime + ", description=" + description
		+ ", location=" + location + ", name=" + name + ", other="
		+ other + ", type=" + type + ", pictures=" + pictures + "]";
	}

	@Override
	public String toXML(){
		StringBuffer buffer = new StringBuffer();

		buffer.append("<event>");
		buffer.append(super.toXML());
		buffer.append("<name>" + name + "</name>");
		buffer.append("<location>" + location +"</location>");
		buffer.append("<type>" + type +"</type>");
		buffer.append("<other>" + other +"</other>");
		buffer.append("<description>" + description +"</description>");
		buffer.append("<dateTime>" + Utilities.getISODate(this.dateTime) + "</dateTime>");
		buffer.append("<pictures>");
		for(Picture picture : pictures){
			buffer.append(picture.toXML());
		}
		buffer.append("</pictures>");
		buffer.append("<children>");
		for(Person child: children){
			buffer.append(child.toXML("child"));
		}
		buffer.append("</children>");
		buffer.append("</event>");

		return buffer.toString();
	}
}