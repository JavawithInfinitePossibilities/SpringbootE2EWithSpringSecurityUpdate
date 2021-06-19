/**
 * 
 */
package com.sid.e2e.springboot.FlightReservation.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sid.e2e.springboot.FlightReservation.entities.Role;
import com.sid.e2e.springboot.FlightReservation.entities.User;
import com.sid.e2e.springboot.FlightReservation.repositories.UserReporsitory;

/**
 * @author Lenovo
 *
 */
@Service
public class UserDetailsServicesImpl implements UserDetailsService {

	@Autowired
	private UserReporsitory userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found for the Email " + username);
		}
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (Role role : user.getRole()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				grantedAuthorities);
	}

}
