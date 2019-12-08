package com.moo.bean;

/**
 * Bean to store contact details and to used for response Json representation 
 * 
 * 
 * @author Ajay
 *
 */
public class ContactBean {

	/**
	 * Unique identifier for a contact in address book
	 */
	private Long contactId;

	/**
	 * First name of the contact
	 */
	private String firstName;

	/**
	 * Surname or last name of the contact
	 */
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
