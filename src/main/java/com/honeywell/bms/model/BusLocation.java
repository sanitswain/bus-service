package com.honeywell.bms.model;

public class BusLocation {

	private String busId;
	private Location location;

	public BusLocation(String busId, Location location) {
		super();
		this.busId = busId;
		this.location = location;
	}

	public String getBusId() {
		return busId;
	}

	public void setBusId(String busId) {
		this.busId = busId;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "BusLocation [busId=" + busId + ", location=" + location + "]";
	}

}
