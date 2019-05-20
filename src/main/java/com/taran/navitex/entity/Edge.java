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

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "first_sensor_id")
    private Sensor first;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "second_sensor_id")
    private Sensor second;

    @Column(name = "cost")
    private int cost;

    public Edge(Sensor first, Sensor second, int cost) {
        this.first = first;
        this.second = second;
        this.cost = cost;
    }
}
