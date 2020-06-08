package com.subbu.location.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.subbu.location.entities.Location;
import com.subbu.location.repos.LocationRepository;
import com.subbu.location.service.LocationService;
import com.subbu.location.util.EmailUtil;
import com.subbu.location.util.ReportUtil;

@Controller
public class LocationController {

	@Autowired
	LocationService service;

	@Autowired
	EmailUtil emailutil;
	@Autowired
	LocationRepository repository;
	@Autowired
	ReportUtil reportutil;
	@Autowired
	ServletContext sc;

	@RequestMapping("/showcreate")
	public String showCreate() {
		return "createLocation";
	}

	@RequestMapping("/savelocation")
	public String saveLoaction(@ModelAttribute("location") Location location, ModelMap modelmap) {
		Location locationSaved = service.saveLocation(location);
		String msg = "Location saved with ID:" + locationSaved.getId();
		modelmap.addAttribute("msg", msg);
		emailutil.sendEmail("endtoendspringbootproject@gmail.com", "Location saved",
				"Location saved successfully and about to return a response");
		return "createLocation";
	}

	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelmap) {
		List<Location> locations = service.getAllLocations();
		modelmap.addAttribute("locations", locations);
		return "displayLocations";
	}

	@RequestMapping("/deletelocation")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelmap) {
		// Location location = service.getLocationById(id);      It retrieves data from db.Instead of it we are creating an object 
		Location location = new Location();
		location.setId(id);
		service.deleteLocation(location);
		             /* We retrieving the remaining locations back*/
		List<Location> locations = service.getAllLocations();
		modelmap.addAttribute("locations", locations);
		return "displayLocations";
	}

	@RequestMapping("/showupdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelmap) {
		Location location = service.getLocationById(id);
		modelmap.addAttribute("location", location);
		return "updateLocation";

	}

	@RequestMapping("/updateloc")
	public String updateLoaction(@ModelAttribute("location") Location location, ModelMap modelmap) {
		service.updateLocation(location);
		
		List<Location> locations = service.getAllLocations();
		modelmap.addAttribute("locations", locations);
		return "displayLocations";
	}

	@RequestMapping("/generateReport")
	public String generateReport() {

		String path = sc.getRealPath("/");   
		/*i)I want to save that image relative to my web application,So that my jsp can use it*/
		/*ii)getRealPath("/")  It will return us the web applications root.when this app is deployed on tomcat that method will return us that path,we are going to use that path to store the generated image i.e,JPEG File.
		 *                                     So that the jsp can point to it and read it from there and send it back to the user*/
		List<Object[]> data = repository.findTypeAndCount();
		reportutil.generatePieChart(path, data);
		return "report";
	}
}
