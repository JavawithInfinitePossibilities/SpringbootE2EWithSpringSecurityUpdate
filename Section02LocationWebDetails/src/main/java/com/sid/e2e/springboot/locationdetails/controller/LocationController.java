/**
 * 
 */
package com.sid.e2e.springboot.locationdetails.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sid.e2e.springboot.locationdetails.entities.Location;
import com.sid.e2e.springboot.locationdetails.repo.LocationRepo;
import com.sid.e2e.springboot.locationdetails.services.LocationService;
import com.sid.e2e.springboot.locationdetails.util.EmailUtil;
import com.sid.e2e.springboot.locationdetails.util.ReportUtil;

/**
 * @author Lenovo
 * localhost:8080/locationweb/locations/showCreate
 *
 */
@Controller
@RequestMapping("/locations")
public class LocationController {

	@Autowired
	LocationService service;

	@Autowired
	EmailUtil emailUtilImpl;

	@Autowired
	LocationRepo locationRepo;

	@Autowired
	ReportUtil reportUtil;

	@Autowired
	ServletContext servletContext;

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "CreateLocation";
	}

	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		Location saveLocation = service.saveLocation(location);
		String msg = "Location saved with id : " + saveLocation.getId();
		modelMap.addAttribute("msg", msg);
		emailUtilImpl.sendEmail("springbootsidtest@gmail.com", "Save location",
				"Location saved successfully and about to return a response");
		return "CreateLocation";
	}

	@RequestMapping("/displayLocation")
	public String displayLocation(ModelMap modelMap) {
		List<Location> locations = service.getAllLocation();
		modelMap.addAttribute("locations", locations);
		return "displayLocation";
	}

	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
		Location location = service.getLocation(id);
		service.deleteLocation(location);
		List<Location> locations = service.getAllLocation();
		modelMap.addAttribute("locations", locations);
		return "displayLocation";
	}

	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
		Location location = service.getLocation(id);
		service.updateLocation(location);
		modelMap.addAttribute("loclocation", location);
		return "updateLocation";
	}

	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		service.updateLocation(location);
		List<Location> locations = service.getAllLocation();
		modelMap.addAttribute("locations", locations);
		return "displayLocation";
	}

	@RequestMapping("/generateReport")
	public String generateReport() {
		List<Object[]> findTypeAndTypeCount = locationRepo.findTypeAndTypeCount();
		String realPath = servletContext.getRealPath("/");
		reportUtil.generatePieChart(realPath, findTypeAndTypeCount);
		return "report";
	}
}
