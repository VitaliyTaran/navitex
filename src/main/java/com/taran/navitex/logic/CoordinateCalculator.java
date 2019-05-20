package com.taran.navitex.logic;

import com.taran.navitex.entity.Sensor;

public class CoordinateCalculator {
    private static final int AVERAGE_EARTH_RADIUS = 6371000;

    public static double distIntoMeters(Sensor first, Sensor second) {
        double dLat = Math.toRadians(second.getLatitude() - first.getLatitude());
        double dLng = Math.toRadians(second.getLongitude() - first.getLongitude());
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(first.getLatitude())) * Math.cos(Math.toRadians(second.getLatitude())) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return AVERAGE_EARTH_RADIUS * c;
    }
}
