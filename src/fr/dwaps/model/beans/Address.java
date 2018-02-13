package fr.dwaps.model.beans;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	@Column(length=90)
	private String street;
	@Column(length=5)
	private String zip;
	@Column(length=90)
	private String city;
	
	public Address() {}
	public Address(String street, String zip, String city) {
		this.street = street;
		this.zip = zip;
		this.city = city;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
