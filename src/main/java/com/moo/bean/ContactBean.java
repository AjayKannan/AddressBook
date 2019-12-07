package com.moo.bean;

public class ContactBean {

	private Long contactId;

	private String firstName;

	private String surname;

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "ContactBean [contactId=" + contactId + ", firstName=" + firstName + ", surname=" + surname + "]";
	}

}
