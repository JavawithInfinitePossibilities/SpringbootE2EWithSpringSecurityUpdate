/**
 * 
 */
package com.sid.spring.boot.flight.checkin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sid.spring.boot.flight.checkin.entities.Reservation;
import com.sid.spring.boot.flight.checkin.entities.ReservationUpdateRequest;
import com.sid.spring.boot.flight.checkin.integration.ReservationRestClient;

/**
 * @author Lenovo
 *
 */
@Controller
public class CheckinController {

	@Autowired
	private ReservationRestClient reservationRestClient;

	@RequestMapping(value = "/showStartCheckin")
	public String showStartCheckin() {
		return "startCheckin";
	}

	@RequestMapping(value = "/startCheckin")
	public String startCheckin(@RequestParam(value = "reservationId") Long reservationId, ModelMap modelMap) {
		Reservation reservation = reservationRestClient.findReservation(reservationId);
		modelMap.addAttribute("reservation", reservation);
		return "displayReservationDetails";
	}

	@RequestMapping(value = "/completeCheckin")
	public String completeCheckin(@RequestParam(value = "reservationId") Long reservationId,
			@RequestParam(value = "numberOfBags") int numberOfBags) {
		reservationRestClient.updateReservation(new ReservationUpdateRequest(reservationId, true, numberOfBags));
		return "checkinConfirmation";

	}
}
