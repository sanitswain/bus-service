package com.honeywell.bms.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.honeywell.bms.model.Location;

@Component
public class LocationCache {

	private Map<String, Location> locations = new ConcurrentHashMap<>();

	public void saveCurrentLocation(String busId, Location location) {
		locations.put(busId, location);
	}

	public Map<String, Location> getAllBusCurrentLocations(Location location, double radious) {
		return locations;
	}
}