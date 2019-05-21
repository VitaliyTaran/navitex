package com.taran.navitex.logic;

import com.taran.navitex.entity.MaximumPermissibleConcentration;
import com.taran.navitex.entity.Sensor;
import com.taran.navitex.entity.SensorDescription;

public class SensorDataAnalyzer {
    public static int generateMark(Sensor sensor) {
        SensorDescription description = sensor.getDescription();
        double result = 1;
        if (description.getCh4() >= MaximumPermissibleConcentration.CH4.getValue() ||
                description.getCo() >= MaximumPermissibleConcentration.CO.getValue() ||
                description.getCo2() >= MaximumPermissibleConcentration.CO2.getValue() ||
                description.getLpg() >= MaximumPermissibleConcentration.LPG.getValue()) {
            result = 10;
        } else {
            double ch4Mark = 10 * description.getCh4() / MaximumPermissibleConcentration.CH4.getValue();
            double coMark = 10 * description.getCo() / MaximumPermissibleConcentration.CO.getValue();
            double co2Mark = 10 * description.getCo2() / MaximumPermissibleConcentration.CO2.getValue();
            double lpgMark = 10 * description.getLpg() / MaximumPermissibleConcentration.LPG.getValue();
            if (ch4Mark > result) {
                result = ch4Mark;
            }
            if (coMark > result) {
                result = coMark;
            }
            if (co2Mark > result) {
                result = co2Mark;
            }
            if (lpgMark > result) {
                result = lpgMark;
            }
        }
        return (int) Math.floor(result);
    }
}
