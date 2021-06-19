/**
 * 
 */
package com.sid.e2e.springboot.FlightReservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sid.e2e.springboot.FlightReservation.entities.Reservation;
import com.sid.e2e.springboot.FlightReservation.entities.dto.ReservationUpdateRequest;
import com.sid.e2e.springboot.FlightReservation.repositories.ReservationRepository;

/**
 * @author Lenovo
 *
 */
@RestController
public class ReservationRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);

	@Autowired
	private ReservationRepository reservationRepository;

	@RequestMapping(value = "/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		LOGGER.info("Inside findReservation : {}", id);
		return reservationRepository.findById(id).get();
	}

	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest updateRequest) {
		LOGGER.info("Inside updateReservation : {}", updateRequest);
		Reservation reservation = reservationRepository.findById(updateRequest.getId()).get();
		reservation.setNumberOfBags(updateRequest.getNumberOfBags());
		reservation.setCheckedIn(updateRequest.getCheckedIn());
		Reservation updateReservation = reservationRepository.save(reservation);
		return updateReservation;
	}
}
