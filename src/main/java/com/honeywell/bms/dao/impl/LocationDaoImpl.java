package com.honeywell.bms.dao.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.honeywell.bms.dao.LocationDao;
import com.honeywell.bms.exception.BMSException;
import com.honeywell.bms.model.Location;

@Component
public class LocationDaoImpl implements LocationDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${query.location.save}")
	private String locSaveQuery;

	public void saveCurrentLocation(String busId, Location location) {
		try {
			java.util.Date date = new Date();
			Object timestamp = new java.sql.Timestamp(date.getTime());
			jdbcTemplate.update(locSaveQuery, busId, location.getLattitude(), location.getLongitude(), timestamp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BMSException("Error in saving the location");
		}
	}

}