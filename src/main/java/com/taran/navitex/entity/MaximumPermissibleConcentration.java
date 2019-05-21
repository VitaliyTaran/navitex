package com.taran.navitex.entity;

public enum MaximumPermissibleConcentration {
    CO2(10), LPG(3000), CO(5000), CH4(3000);
    private int value;

    MaximumPermissibleConcentration(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
