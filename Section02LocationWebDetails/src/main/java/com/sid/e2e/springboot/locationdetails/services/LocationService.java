/**
 * 
 */
package com.sid.e2e.springboot.locationdetails.services;

import java.util.List;

import com.sid.e2e.springboot.locationdetails.entities.Location;

/**
 * @author Lenovo
 *
 */
public interface LocationService {

	Location saveLocation(Location location);

	Location updateLocation(Location location);

	void deleteLocation(Location location);

	Location getLocation(int id);

	List<Location> getAllLocation();
}
