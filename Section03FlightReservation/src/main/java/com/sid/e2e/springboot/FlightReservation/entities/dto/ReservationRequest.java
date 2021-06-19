/**
 * 
 */
package com.sid.e2e.springboot.FlightReservation.entities.dto;

/**
 * @author Lenovo
 *
 */
public class ReservationRequest {

	private Long flightId;
	private String passengerName;
	private String passengerLastName;
	private String passengerEmail;
	private String passengerPhone;
	private String nameOnTheCard;
	private String theCardNumber;
	private String theCardExpiryDate;
	private String theCardCVVNumber;

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerLastName() {
		return passengerLastName;
	}

	public void setPassengerLastName(String passengerLastName) {
		this.passengerLastName = passengerLastName;
	}

	public String getPassengerEmail() {
		return passengerEmail;
	}

	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}

	public String getPassengerPhone() {
		return passengerPhone;
	}

	public void setPassengerPhone(String passengerPhone) {
		this.passengerPhone = passengerPhone;
	}

	public String getNameOnTheCard() {
		return nameOnTheCard;
	}

	public void setNameOnTheCard(String nameOnTheCard) {
		this.nameOnTheCard = nameOnTheCard;
	}

	public String getTheCardNumber() {
		return theCardNumber;
	}

	public void setTheCardNumber(String theCardNumber) {
		this.theCardNumber = theCardNumber;
	}

	public String getTheCardExpiryDate() {
		return theCardExpiryDate;
	}

	public void setTheCardExpiryDate(String theCardExpiryDate) {
		this.theCardExpiryDate = theCardExpiryDate;
	}

	public String getTheCardCVVNumber() {
		return theCardCVVNumber;
	}

	public void setTheCardCVVNumber(String theCardCVVNumber) {
		this.theCardCVVNumber = theCardCVVNumber;
	}

	@Override
	public String toString() {
		return "ReservationRequest [flightId=" + flightId + ", passengerName=" + passengerName + ", passengerLastName="
				+ passengerLastName + ", passengerEmail=" + passengerEmail + ", passengerPhone=" + passengerPhone
				+ ", nameOnTheCard=" + nameOnTheCard + ", theCardNumber=" + theCardNumber + ", theCardExpiryDate="
				+ theCardExpiryDate + ", theCardCVVNumber=" + theCardCVVNumber + "]";
	}

}
