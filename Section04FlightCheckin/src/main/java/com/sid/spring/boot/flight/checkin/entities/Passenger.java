package com.sid.spring.boot.flight.checkin.entities;

/**
 * @author Lenovo
 *
 */
public class Passenger extends AbstractEntity {

	private String firstName;
	private String lastname;
	private String middleName;
	private String email;
	private String phone;

	/**
	 * 
	 */
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
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
