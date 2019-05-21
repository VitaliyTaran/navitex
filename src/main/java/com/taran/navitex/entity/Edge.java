package com.taran.navitex.entity;

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

    public Edge(Sensor first, Sensor second) {
        this.first = first;
        this.second = second;
    }
}
