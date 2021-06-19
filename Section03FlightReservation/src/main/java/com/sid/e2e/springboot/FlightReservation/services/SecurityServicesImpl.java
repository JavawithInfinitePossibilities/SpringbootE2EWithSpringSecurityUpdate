/**
 * 
 */
package com.sid.e2e.springboot.FlightReservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @author Lenovo
 *
 */
@Service
public class SecurityServicesImpl implements SecurityServices {

	@Autowired
	@Qualifier(value = "userDetailsServicesImpl")
	private UserDetailsService userDetailsServices;

	@Autowired
	private AuthenticationManager autheticationManager;

	@Override
	public boolean login(String username, String password) {
		UserDetails userDetails = userDetailsServices.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password,
				userDetails.getAuthorities());
		autheticationManager.authenticate(token);
		boolean result = token.isAuthenticated();
		if (result) {
			SecurityContextHolder.getContext().setAuthentication(token);
		}
		return result;
	}

}
