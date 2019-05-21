package com.taran.navitex.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "sensor_description")
public class SensorDescription {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_id")
    private int id;

    @Column(name = "co2")
    private double co2;

    @Column(name = "lpg")
    private double lpg;

    @Column(name = "co")
    private double co;

    @Column(name = "ch4")
    private double ch4;

    @Column(name = "dust")
    private double dust;

    @Column(name = "temp")
    private double temp;

    @Column(name = "hum")
    private double hum;

    @Column(name = "pressure")
    private double pressure;

    @Column(name = "created")
    private LocalDate created;


}
