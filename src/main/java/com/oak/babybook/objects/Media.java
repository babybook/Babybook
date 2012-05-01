package com.oak.babybook.objects;

import java.io.Serializable;

public class Media  extends Taggable implements Serializable{

	private MediaType mediaType;
	private String name;
	private String location;
	private String caption;

	public Media(){}

	public Media(Long id, String tags, MediaType mediaType, String name, String location, String caption) {
		super(id, tags);
		this.mediaType = mediaType;
		this.name = name;
		this.location = location;
		this.caption = caption;
	}


	public final void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final void setLocation(String location) {
		this.location = location;
	}

	public final void setCaption(String caption) {
		this.caption = caption;
	}

	public final MediaType getMediaType() {
		return mediaType;
	}

	public final String getName() {
		return name;
	}

	public final String getLocation() {
		return location;
	}

	public final String getCaption() {
		return caption;
	}

	@Override
	public String toXML() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(super.toXML());
		buffer.append("<mediatype>" + mediaType.name() + "</mediatype>");
		buffer.append("<name>" + name + "</name>");
		buffer.append("<location>" + location + "</location>");
		buffer.append("<caption>" + caption + "</caption>");

		return buffer.toString();
	}


	@Override
	public String toString() {
		return super.toString() + "Media [mediaType=" + mediaType + ", name=" + name + ", location=" + location + ", caption=" + caption
		+ "]";
	}
}
