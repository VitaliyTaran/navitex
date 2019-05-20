package com.taran.navitex.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class Graph {
    private final List<Sensor> sensors;
    private final List<Edge> edges;
}


