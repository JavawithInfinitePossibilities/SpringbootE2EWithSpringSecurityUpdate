/**
 * 
 */
package com.sid.spring.boot.flight.checkin.entities;

/**
 * @author Lenovo
 *
 */
public class Reservation extends AbstractEntity {

	private Boolean checkedIn;
	private int numberOfBags;
	private Passenger passenger;
	private Flight flight;

	/**
	 * 
	 */
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param checkedIn
	 * @param passenger
	 * @param flight
	 */
	public Reservation(Boolean checkedIn, Passenger passenger, Flight flight) {
		super();
		this.checkedIn = checkedIn;
		this.passenger = passenger;
		this.flight = flight;
	}

	public Boolean getCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public int getNumberOfBags() {
		return numberOfBags;
	}

	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Reservation [checkedIn=" + checkedIn + ", numberOfBags=" + numberOfBags + ", passenger=" + passenger
				+ ", flight=" + flight + ", getId()=" + getId() + "]";
	}

}
