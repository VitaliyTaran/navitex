package com.taran.navitex.logic;

import com.taran.navitex.entity.Sensor;
import org.junit.Assert;
import org.junit.Test;

public class CoordinateCalculatorTest {
    private static final double MINSK_DIAMETER = 31144.092591772922;

    @Test
    public void calculateDistance() {
        Sensor first = new Sensor("Западная точка на мкаде Минска", 53.910498, 27.408334);
        Sensor second = new Sensor("Восточная точка на мкаде Минска", 53.906579, 27.688398);
        Assert.assertEquals(MINSK_DIAMETER, CoordinateCalculator.distance(first, second), 0.0);
    }
}