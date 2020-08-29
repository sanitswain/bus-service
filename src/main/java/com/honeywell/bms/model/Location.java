package com.honeywell.bms.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Location {

	private Double Lattitude;
	private Double Longitude;

	@JsonCreator
	public Location(Double lattitude, Double longitude) {
		Lattitude = lattitude;
		Longitude = longitude;
	}

	public Double getLattitude() {
		return Lattitude;
	}

	public void setLattitude(Double lattitude) {
		Lattitude = lattitude;
	}

	public Double getLongitude() {
		return Longitude;
	}

	public void setLongitude(Double longitude) {
		Longitude = longitude;
	}

}