package com.oak.babybook.objects;

import java.io.Serializable;

public class Audio extends Media implements Serializable{

	public Audio(){
		super();
	}

	public Audio(Long id, String tags, String name, String location, String caption) {
		super(id, tags, MediaType.AUDIO, name, location, caption);

	}

	@Override
	public String toXML() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<audio>");
		buffer.append(super.toXML());
		buffer.append("<audio>");

		return buffer.toString();
	}

}
