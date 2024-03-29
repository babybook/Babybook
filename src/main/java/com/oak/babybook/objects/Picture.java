package com.oak.babybook.objects;

import java.io.Serializable;

public class Picture extends Media implements Serializable{

	public Picture(){
		super();
	}

	public Picture(Long id, String tags, String name, String location, String caption) {
		super(id, tags, MediaType.PHOTO, name, location, caption);

	}

	@Override
	public String toXML() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<picture>");
		buffer.append(super.toXML());
		buffer.append("<picture>");

		return buffer.toString();
	}

}
