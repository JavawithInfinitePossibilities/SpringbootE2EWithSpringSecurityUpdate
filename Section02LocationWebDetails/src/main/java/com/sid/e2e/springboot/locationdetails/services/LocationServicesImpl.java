/**
 * 
 */
package com.sid.e2e.springboot.locationdetails.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sid.e2e.springboot.locationdetails.entities.Location;
import com.sid.e2e.springboot.locationdetails.repo.LocationRepo;

/**
 * @author Lenovo
 *
 */
@Service
public class LocationServicesImpl implements LocationService {

	@Autowired
	private LocationRepo locationRepo;

	@Override
	public Location saveLocation(Location location) {
		return locationRepo.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return locationRepo.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		locationRepo.delete(location);
	}

	@Override
	public Location getLocation(int id) {
		return locationRepo.findById((long)id).get();
	}

	@Override
	public List<Location> getAllLocation() {
		return locationRepo.findAll();
	}

}
