/**
 * 
 */
package com.sid.e2e.springboot.FlightReservation.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sid.e2e.springboot.FlightReservation.entities.Flight;

/**
 * @author Lenovo
 *
 */
public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
	List<Flight> findFlights(@Param(value = "departureCity") String from, @Param(value = "arrivalCity") String to,
			@Param(value = "dateOfDeparture") Date departureDate);

}
