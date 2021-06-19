/**
 * 
 */
package com.sid.e2e.springboot.FlightReservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.e2e.springboot.FlightReservation.entities.Passenger;

/**
 * @author Lenovo
 *
 */
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
