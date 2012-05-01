package com.oak.babybook.objects;

public class Taggable extends GeneratedId {

	public String tags;

	public Taggable(){}

	public Taggable(Long id, String tags){
		super(id);
		this.tags = tags;
	}

	public final String getTags() {
		return tags;
	}

	public final void setTags(String tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return super.toString() + "Taggable [tags=" + tags + "]";
	}

	@Override
	public String toXML() {
		return super.toXML() + "<tags>" + tags + "</tags>";
	}
}
