package com.oak.babybook.objects;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.oak.babybook.utils.Utilities;

public class Person extends GeneratedId implements Serializable {

	private String first;
	private String middle;
	private String last;
	private Date dob;
	private String email;
	private Gender gender;
	protected Set<Picture> pictures;

	public Person() {
	}

	public Person(Long id, String first, String middle, String last, Date dob, String email, Gender gender) {
		super(id);
		this.first = first;
		this.middle = middle;
		this.last = last;
		this.dob = dob;
		this.email = email;
		this.gender = gender;
	}

	public String getFirst() {
		return first;
	}

	public String getMiddle() {
		return middle;
	}

	public String getLast() {
		return last;
	}

	public Date getDob() {
		return dob;
	}

	public String getEmail() {
		return email;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Set<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(Set<Picture> pictures) {
		this.pictures = pictures;
	}

	public void addPicture(Picture picture) {
		if (pictures == null) {
			pictures = new HashSet<Picture>();
		}
		pictures.add(picture);
	}

	@Override
	public String toString() {
		return super.toString() + " Person [dob=" + dob + ", email=" + email + ", first=" + first + ", gender="
		+ gender + ", last=" + last + ", middle=" + middle + "]";
	}

	public String toXMLPerson() {
		return this.toXML("person");
	}

	public String toXMLChild() {
		return this.toXML("child");
	}

	@Override
	public String toXML() {
		return this.toXML(null);
	}

	public String toXML(String type) {
		StringBuffer buffer = new StringBuffer();

		if (type!=null){
			buffer.append("<" + type + ">");
		}
		buffer.append(super.toXML());
		buffer.append("<first>" + first + "</first>");
		buffer.append("<middle>" + middle + "</middle>");
		buffer.append("<last>" + last + "</last>");
		buffer.append("<email>" + email + "</email>");
		buffer.append("<gender>" + gender + "</gender>");
		buffer.append("<dob>" + Utilities.getISODate(dob) + "</dob>");
		if (type!=null){
			buffer.append("</" + type + ">");
		}
		return buffer.toString();
	}
}
