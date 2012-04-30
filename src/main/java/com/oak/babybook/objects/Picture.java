package com.oak.babybook.objects;

import java.io.Serializable;

public class Picture extends GeneratedId implements Serializable{

	private String name;
	private String location;
	private String caption;

	public Picture(){}

	public Picture(Long id, String name, String location, String caption) {
		super(id);
		this.name = name;
		this.location = location;
		this.caption = caption;
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
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	@Override
	public String toString() {
		return super.toString() + " Picture [caption=" + caption + ", location=" + location
		+ ", name=" + name + "]";
	}

	@Override
	public String toXML() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(super.toXML());
		buffer.append("<picture>");
		buffer.append("<name>" + name + "</name>");
		buffer.append("<location>" + location + "</location>");
		buffer.append("<caption>" + caption + "</caption>");
		buffer.append("</picture>");

		return buffer.toString();
	}
}
