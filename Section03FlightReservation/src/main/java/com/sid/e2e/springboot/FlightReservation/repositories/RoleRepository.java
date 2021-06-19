/**
 * 
 */
package com.sid.e2e.springboot.FlightReservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.e2e.springboot.FlightReservation.entities.Role;

/**
 * @author Lenovo
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

}
