package com.oak.babybook.objects;

import java.io.Serializable;

public class GeneratedId implements Serializable{

	private Long id;

	public GeneratedId(){}

	public GeneratedId(Long id){
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "GeneratedId [id=" + id + "]";
	}

	public String toXML(){
		StringBuffer buffer = new StringBuffer();

		buffer.append("<id>" + this.id + "</id>");
		return buffer.toString();
	}
}
