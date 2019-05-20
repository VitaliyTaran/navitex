package com.taran.navitex.entity;

import com.taran.navitex.logic.CoordinateCalculator;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "edge")
public class Edge {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "first_sensor_id")
    private Sensor first;

    @OneToOne
    @JoinColumn(name = "second_sensor_id")
    private Sensor second;

    @Column(name = "cost")
    private int cost;
    @Column(name = "distance")
    private double distance;
    @Column(name = "average_mark")
    private float averageMark;

    public Edge(Sensor first, Sensor second) {
        this.first = first;
        this.second = second;
        this.distance = CoordinateCalculator.distance(first, second);
        this.averageMark = (first.getMark() + second.getMark()) / 2;
        this.cost = (int) (distance * averageMark);
    }

    public Edge(int id, Sensor first, Sensor second) {
        this.id = id;
        this.first = first;
        this.second = second;
        this.distance = CoordinateCalculator.distance(first, second);
        this.averageMark = (first.getMark() + second.getMark()) / 2;
        this.cost = (int) (distance * averageMark);
    }
}
