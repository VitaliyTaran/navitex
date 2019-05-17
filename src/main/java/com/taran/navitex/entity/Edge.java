package com.taran.navitex.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class Edge {
    private final Sensor first;
    private final Sensor second;
    private final int cost;
}
