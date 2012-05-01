package com.oak.babybook.objects;

import java.io.Serializable;

public class Video extends Media implements Serializable{

	public Video(){
		super();
	}

	public Video(Long id, String tags, String name, String location, String caption) {
		super(id, tags, MediaType.PHOTO, name, location, caption);

	}

	@Override
	public String toXML() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<video>");
		buffer.append(super.toXML());
		buffer.append("<video>");

		return buffer.toString();
	}

}
