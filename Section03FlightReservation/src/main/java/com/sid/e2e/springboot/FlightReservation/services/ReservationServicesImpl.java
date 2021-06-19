/**
 * 
 */
package com.sid.e2e.springboot.FlightReservation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sid.e2e.springboot.FlightReservation.entities.Flight;
import com.sid.e2e.springboot.FlightReservation.entities.Passenger;
import com.sid.e2e.springboot.FlightReservation.entities.Reservation;
import com.sid.e2e.springboot.FlightReservation.entities.dto.ReservationRequest;
import com.sid.e2e.springboot.FlightReservation.repositories.FlightRepository;
import com.sid.e2e.springboot.FlightReservation.repositories.PassengerRepository;
import com.sid.e2e.springboot.FlightReservation.repositories.ReservationRepository;
import com.sid.e2e.springboot.FlightReservation.util.EmailUtil;
import com.sid.e2e.springboot.FlightReservation.util.PDFGeneratorUtil;

/**
 * @author Lenovo
 *
 */
@Service
public class ReservationServicesImpl implements ReservationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServicesImpl.class);

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private PDFGeneratorUtil pdfGenerator;

	@Autowired
	private EmailUtil emailUtil;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		// Make payment
		LOGGER.info("Inside bookFlight : {}", request);
		// Make the flight book
		Long flightId = request.getFlightId();
		Flight flight = flightRepository.findById(flightId).get();

		Passenger passenger = new Passenger(request.getPassengerName(), request.getPassengerLastName(), "",
				request.getPassengerEmail(), request.getPassengerPhone());
		passengerRepository.save(passenger);

		Reservation reservation = new Reservation(false, passenger, flight);
		Reservation saveReservation = reservationRepository.save(reservation);
		LOGGER.info("saveReservation : {}", saveReservation);
		String filePath = "./../flightDocument/ticket/flightTicket-" + saveReservation.getId() + ".pdf";

		pdfGenerator.generateItinary(saveReservation, filePath);
		LOGGER.info("generateItinary : {} , {}", saveReservation, filePath);
		emailUtil.sendItinerary(saveReservation.getPassenger().getEmail(), filePath);
		LOGGER.info("sendItinerary : {} , {}", saveReservation.getPassenger().getEmail(), filePath);
		return saveReservation;
	}

}
