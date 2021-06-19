/**
 * 
 */
package com.sid.e2e.springboot.locationdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sid.e2e.springboot.locationdetails.entities.Location;
import com.sid.e2e.springboot.locationdetails.repo.LocationRepo;

/**
 * @author Lenovo
 * localhost:8080/locationweb/reactjs
 * localhost:8080/locationweb/reactjs/saveLoc
 * {
    "id": 94,
    "code": "Ban",
    "name": "Bangalore",
    "type": "RURAL"
	}
 */
@RestController
@RequestMapping("/reactjs")
public class LocationRESTController {

	@Autowired
	LocationRepo locationRepo;

	@GetMapping(value = "/getAll", produces = "application/json")
	public List<Location> getAllLocation() {
		return locationRepo.findAll();
	}

	@PostMapping(value = "/saveLoc", produces = "application/json")
	public Location createLocation(@RequestBody Location location) {
		return locationRepo.save(location);
	}

	@PutMapping
	public Location updateLocation(@RequestBody Location location) {
		return locationRepo.save(location);
	}

	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable("id") int id) {
		locationRepo.deleteById((long) id);
	}

	@GetMapping("/{id}")
	public Location getLocation(@PathVariable("id") int id) {
		return locationRepo.findById((long) id).get();
	}
}
