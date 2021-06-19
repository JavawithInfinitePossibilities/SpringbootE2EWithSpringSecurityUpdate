/**
 * 
 */
package com.sid.spring.boot.flight.checkin.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sid.spring.boot.flight.checkin.entities.Reservation;
import com.sid.spring.boot.flight.checkin.entities.ReservationUpdateRequest;

/**
 * @author Lenovo
 *
 */
@Component
public class ReservationRestClientImpl implements ReservationRestClient {

	private static final String RESERVATION_URL = "http://localhost:8080/flightreservation/reservations/";

	@Override
	public Reservation findReservation(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.getForObject(RESERVATION_URL + id, Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest updateRequest) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.postForObject(RESERVATION_URL, updateRequest, Reservation.class);
		return reservation;
	}

}
