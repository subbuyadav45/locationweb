package com.subbu.location.controllers;

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

import com.subbu.location.entities.Location;
import com.subbu.location.repos.LocationRepository;

@RestController
@RequestMapping("/locations")
public class LocationRestController {
	@Autowired
	LocationRepository locationrepository;
	
	
	@GetMapping
	public List<Location> getLocations(){
		return locationrepository.findAll();
		
	}

	@PostMapping
	public Location createLocation(@RequestBody Location location) {
		return locationrepository.save(location);
	}
	
	
	@PutMapping
	public Location updateLocation(@RequestBody Location location) {
		return locationrepository.save(location);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable("id") int id) {
		
		locationrepository.deleteById(id);
		
	}
	@GetMapping("/{id}")
	public Location getLocation(@PathVariable("id") int id) {
		
		return locationrepository.findById(id).get();
		
	}
	
	
	
	
}
