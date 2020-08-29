package com.honeywell.bms.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.honeywell.bms.model.BusLocation;
import com.honeywell.bms.model.Location;
import com.honeywell.bms.service.LocationService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/location", produces = { MediaType.APPLICATION_JSON_VALUE })
public class LocationRestController {

	@Autowired
	private LocationService locationService;

	/**
	 * To store bus current location
	 * 
	 * @param busId    unique identifier of the bus
	 * @param location holds Latitude and Longitude of the bus
	 * @return
	 */
	@PostMapping(path = "/{busId}", consumes = "application/json")
	@ApiOperation(value = "Save current location of the bus", response = String.class)
	public ResponseEntity<String> saveCurrentLocation(@PathVariable String busId, Location location) {
		// validate the busId with the current context
		locationService.saveLocation(busId, location);
		return ResponseEntity.accepted().body("location saved");
	}

	@GetMapping(path = "/all")
	public Collection<BusLocation> getBusLocations(@RequestParam(value = "latitude", required = false) Double latitude,
			@RequestParam(value = "longitude", required = false) Double longitude,
			@RequestParam(value = "radious", required = false) Double radious) {
		return locationService.getAllBusCurrentLocations(new Location(latitude, longitude), radious);
	}
}