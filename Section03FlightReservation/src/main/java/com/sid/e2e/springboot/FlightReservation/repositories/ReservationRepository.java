/**
 * 
 */
package com.sid.e2e.springboot.FlightReservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.e2e.springboot.FlightReservation.entities.Reservation;

/**
 * @author Lenovo
 *
 */
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
