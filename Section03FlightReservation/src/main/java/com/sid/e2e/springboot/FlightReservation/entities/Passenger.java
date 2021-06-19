package com.sid.e2e.springboot.FlightReservation.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Lenovo
 *
 */
@Entity
public class Passenger extends AbstractEntity {

	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastname;
	@Column(name = "MIDDLE_NAME")
	private String middleName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PHONE")
	private String phone;

	/**
	 * 
	 */
	public Passenger() {
		super();
	}

	/**
	 * @param firstName
	 * @param lastname
	 * @param middleName
	 * @param email
	 * @param phone
	 */
	public Passenger(String firstName, String lastname, String middleName, String email, String phone) {
		super();
		this.firstName = firstName;
		this.lastname = lastname;
		this.middleName = middleName;
		this.email = email;
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Passenger [firstName=" + firstName + ", lastname=" + lastname + ", middleName=" + middleName
				+ ", email=" + email + ", phone=" + phone + ", getId()=" + getId() + "]";
	}

}
