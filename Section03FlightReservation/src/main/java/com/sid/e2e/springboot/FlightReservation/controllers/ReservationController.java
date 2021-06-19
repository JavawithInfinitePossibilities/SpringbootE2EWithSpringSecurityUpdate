/**
 * 
 */
package com.sid.e2e.springboot.FlightReservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sid.e2e.springboot.FlightReservation.entities.Flight;
import com.sid.e2e.springboot.FlightReservation.entities.Reservation;
import com.sid.e2e.springboot.FlightReservation.entities.dto.ReservationRequest;
import com.sid.e2e.springboot.FlightReservation.repositories.FlightRepository;
import com.sid.e2e.springboot.FlightReservation.services.ReservationService;

/**
 * @author Lenovo
 *
 */
@Controller
public class ReservationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private ReservationService reservationService;

	@RequestMapping(value = "/showCompleteReservation", method = RequestMethod.GET)
	public String showCompleteReservation(@RequestParam(value = "flightId") Long flightId, ModelMap modelMap) {
		LOGGER.info("Inside showCompleteReservation : {} ", flightId);
		Flight flight = flightRepository.findById(flightId).get();
		modelMap.addAttribute("flight", flight);
		return "completeReservation";
	}

	@RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		LOGGER.info("Inside completeReservation : {} ", request);

		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation created successfully and the id is " + reservation.getId());
		return "reservationConfirmation";
	}
}
