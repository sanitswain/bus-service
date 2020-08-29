package com.honeywell.bms.service;

import java.util.Collection;

import com.honeywell.bms.model.BusLocation;
import com.honeywell.bms.model.Location;
import com.honeywell.bms.util.Status;

public interface LocationService {

	/**
	 * @param busId
	 * @param location
	 * @return
	 */
	public Status saveLocation(String busId, Location location);

	/**
	 * @param city
	 * @param location optional param
	 * @param radious  optional param
	 * @return
	 */
	public Collection<BusLocation> getAllBusCurrentLocations(Location location, double radious);
}
