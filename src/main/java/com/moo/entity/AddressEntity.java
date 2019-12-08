package com.moo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACT_ADDRESS")
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "postcode")
	private String postcode;

	@Column(name = "primary_address")
	private boolean primaryAddress;

	@Column(name = "contact_id_fk")
	private Long contactIdFk;

	@Column(name = "street_name")
	private String streetName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public boolean isPrimaryAddress() {
		return primaryAddress;
	}

	public void setPrimaryAddress(boolean primaryAddress) {
		this.primaryAddress = primaryAddress;
	}

	public Long getContactIdFk() {
		return contactIdFk;
	}

	public void setContactIdFk(Long contactIdFk) {
		this.contactIdFk = contactIdFk;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	@Override
	public String toString() {
		return "AddressEntity [id=" + id + ", postcode=" + postcode + ", primaryAddress=" + primaryAddress
				+ ", contactIdFk=" + contactIdFk + ", streetName=" + streetName + "]";
	}

}
