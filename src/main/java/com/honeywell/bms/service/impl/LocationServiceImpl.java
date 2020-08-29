package com.honeywell.bms.service.impl;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeywell.bms.cache.LocationCache;
import com.honeywell.bms.dao.LocationDao;
import com.honeywell.bms.exception.BMSException;
import com.honeywell.bms.model.BusLocation;
import com.honeywell.bms.model.Location;
import com.honeywell.bms.service.LocationService;
import com.honeywell.bms.util.DistanceCalculator;
import com.honeywell.bms.util.Status;

@Service
public class LocationServiceImpl implements LocationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LocationServiceImpl.class);

	@Autowired
	private LocationDao locationDao;

	@Autowired
	private LocationCache locCache;

	@Override
	public Status saveLocation(String busId, Location location) {
		// Validation of the location
		if (location.getLattitude() == null || location.getLongitude() == null) {
			throw new BMSException("Invalid location");
		}

		locCache.saveCurrentLocation(busId, location);
		locationDao.saveCurrentLocation(busId, location);

		return Status.SUCCESS;
	}

	@Override
	public Collection<BusLocation> getAllBusCurrentLocations(Location location, double radious) {
		Map<String, Location> map = locCache.getAllBusCurrentLocations(location, radious);
		return map.entrySet().stream()
				.filter(en -> location.getLattitude() == null || location.getLongitude() == null
						|| DistanceCalculator.distance(en.getValue(), location) <= radious)
				.map(en -> new BusLocation(en.getKey(), en.getValue())).collect(Collectors.toList());
	}
}