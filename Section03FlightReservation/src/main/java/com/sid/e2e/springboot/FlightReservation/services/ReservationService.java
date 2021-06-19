/**
 * 
 */
package com.sid.e2e.springboot.FlightReservation.services;

import com.sid.e2e.springboot.FlightReservation.entities.Reservation;
import com.sid.e2e.springboot.FlightReservation.entities.dto.ReservationRequest;

/**
 * @author Lenovo
 *
 */
public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);
}
