package com.moo.bean;

/**
 * 
 * Bean to store address details and to used for response Json representation 
 * 
 * @author Ajay
 *
 */
public class AddressBean {

	/**
	 * Unique identifier for a a address in address book
	 */
	private Long addressId;

	/**
	 * Post code of the address
	 */
	private String postcode;

	/**
	 * To identify if this the primary address Multiple address can be present for a
	 * contact
	 */
	private boolean isPrimaryContact;

	/**
	 * Street name of the address
	 */
	private String steetName;

	/**
	 * Unique id of the contact
	 */
	private Long contactId;

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public boolean isPrimaryContact() {
		return isPrimaryContact;
	}

	public void setPrimaryContact(boolean isPrimaryContact) {
		this.isPrimaryContact = isPrimaryContact;
	}

	public String getSteetName() {
		return steetName;
	}

	public void setSteetName(String steetName) {
		this.steetName = steetName;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	@Override
	public String toString() {
		return "AddressBean [addressId=" + addressId + ", postcode=" + postcode + ", isPrimaryContact="
				+ isPrimaryContact + ", steetName=" + steetName + ", contactId=" + contactId + "]";
	}
}
