/**
 * 
 */
package com.sid.e2e.springboot.FlightReservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.e2e.springboot.FlightReservation.entities.User;

/**
 * @author Lenovo
 *
 */
public interface UserReporsitory extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
