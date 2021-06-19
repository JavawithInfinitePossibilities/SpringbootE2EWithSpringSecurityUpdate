/**
 * 
 */
package com.sid.e2e.springboot.FlightReservation.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sid.e2e.springboot.FlightReservation.entities.Role;
import com.sid.e2e.springboot.FlightReservation.entities.User;
import com.sid.e2e.springboot.FlightReservation.repositories.RoleRepository;
import com.sid.e2e.springboot.FlightReservation.repositories.UserReporsitory;
import com.sid.e2e.springboot.FlightReservation.services.SecurityServices;

/**
 * @author Lenovo
 *
 */
@Controller
public class UsersController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);

	@Autowired
	private UserReporsitory userRepository;

	@Autowired
	private BCryptPasswordEncoder bCrypPwdEnc;

	@Autowired
	private SecurityServices securityServices;

	@Autowired
	private RoleRepository roleRepository;

	@RequestMapping(value = "/showReg")
	public String showRegistrationPage() {
		LOGGER.info("Inside showRegistrationPage :");
		return "login/registerUser";
	}

	@RequestMapping(value = "/showLogin")
	public String showLoginPage() {
		LOGGER.info("Inside showLoginPage :");
		return "login/login";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String userRegistration(@ModelAttribute("user") User user) {
		LOGGER.info("Inside userRegistration : {} ", user);
		user.setPassword(bCrypPwdEnc.encode(user.getPassword()));
		userRepository.save(user);
		return "login/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String userLogin(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap) {
		LOGGER.info("Inside userLogin : {},{} ", email, password);

		boolean loginResponse = securityServices.login(email, password);
		String loginSuccess = "";
		// User user = userRepository.findByEmail(email);
		// if (user.getPassword().equals(password)) {
		if (loginResponse) {
			loginSuccess = "findFlights";
		} else {
			modelMap.addAttribute("msg", "User name and password is matching. Please try again.");
			loginSuccess = "login/login";
		}
		return loginSuccess;
	}
}
