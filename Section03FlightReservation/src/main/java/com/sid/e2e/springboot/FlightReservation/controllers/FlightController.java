/**
 * 
 */
package com.sid.e2e.springboot.FlightReservation.controllers;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sid.e2e.springboot.FlightReservation.entities.Flight;
import com.sid.e2e.springboot.FlightReservation.repositories.FlightRepository;

/**
 * @author Lenovo
 *
 */
@Controller
public class FlightController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

	@Autowired
	private FlightRepository flightRepository;

	@RequestMapping(value = "findflights", method = RequestMethod.POST)
	public String findFlights(@RequestParam(value = "from") String from, @RequestParam(value = "to") String to,
			@RequestParam(value = "departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate,
			ModelMap modelMap) {
		LOGGER.info("Inside findFlights : From  {} to {} departureDate {} ", from, to, departureDate);
		List<Flight> flights = flightRepository.findFlights(from, to, departureDate);
		modelMap.addAttribute("flights", flights);
		return "display/flights";
	}

	@RequestMapping(value = "/admin/showAddFlight")
	public String showAddFlight() {
		return "addFlight";
	}
	
	@RequestMapping(value = "/admin/superShowAddFlight")
	public String showSuperAddFlight() {
		return "superAddFlight";
	}
}
