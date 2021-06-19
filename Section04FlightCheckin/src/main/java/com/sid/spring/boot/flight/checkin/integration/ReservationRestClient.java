/**
 * 
 */
package com.sid.spring.boot.flight.checkin.integration;

import com.sid.spring.boot.flight.checkin.entities.Reservation;
import com.sid.spring.boot.flight.checkin.entities.ReservationUpdateRequest;

/**
 * @author Lenovo
 *
 */
public interface ReservationRestClient {

	public Reservation findReservation(Long id);

	public Reservation updateReservation(ReservationUpdateRequest updateRequest);
}
