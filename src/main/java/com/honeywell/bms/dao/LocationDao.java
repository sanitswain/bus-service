package com.honeywell.bms.dao;

import com.honeywell.bms.model.Location;

public interface LocationDao {

	public void saveCurrentLocation(String busId, Location location);

}
