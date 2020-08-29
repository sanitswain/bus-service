package com.honeywell.bms.util;

import com.honeywell.bms.model.Location;

public class DistanceCalculator {

	public static double distance(Location loc1, Location loc2) {
		double lat1 = loc1.getLattitude(), lon1 = loc1.getLongitude();
		double lat2 = loc2.getLattitude(), lon2 = loc2.getLongitude();

		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		} else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2))
					+ Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;

			dist = dist * 1.609344; // KM
			return dist;
		}
	}
}