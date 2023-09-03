package com.gendra.pruebatecnicagilapi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Entity class representing a City in the system. Contains fields and methods
 * that map to the database schema for a city. Additionally, this entity has
 * utility fields and methods generated by Lombok annotations.
 *
 * @author Gilberto García
 * @version 1.0
 * @since 2023-09-03
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class City {

    /**
     * Unique identifier for the city. This ID is generated automatically when a
     * new city entity is persisted to the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    /**
     * Name of the city.
     */
    private String name;

    /**
     * Latitude coordinate of the city's location.
     */
    private Double latitude;

    /**
     * Longitude coordinate of the city's location.
     */
    private Double longitude;

    /**
     * A transient field representing the score or relevance of the city in
     * certain contexts. This field is not persisted to the database and is
     * typically used temporarily in application logic.
     */
    @Transient
    private Double score;

    /**
     * Constructor used to initialize a city with its name, latitude, and
     * longitude.
     *
     * @param name Name of the city.
     * @param latitude Latitude coordinate of the city's location.
     * @param longitude Longitude coordinate of the city's location.
     */
    public City(String name, Double latitude, Double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}