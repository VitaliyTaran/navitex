package com.taran.navitex.entity;

import lombok.*;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Sensor {
    private int id;
    private String name;
    private BigDecimal longitude;
    private BigDecimal latitude;

    public Sensor(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
