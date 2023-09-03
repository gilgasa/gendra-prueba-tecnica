package com.gendra.pruebatecnicagilapi.model.dto;

import com.gendra.pruebatecnicagilapi.model.entity.City;
import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Data Transfer Object (DTO) representing a City's information structure. This
 * class is used to transport city details in a specific format without directly
 * exposing the entity.
 *
 * @author Gilberto García
 * @version 1.0
 * @since 2023-09-03
 */
@Data
@AllArgsConstructor
public class CityDTO {

    /**
     * Name of the city.
     */
    private String name;

    /**
     * Latitude coordinate of the city, formatted as a String.
     */
    private String latitude;

    /**
     * Longitude coordinate of the city, formatted as a String.
     */
    private String longitude;

    /**
     * Score or relevance value of the city, rounded to one decimal place.
     */
    private Double score;

    /**
     * Transforms a City entity into a CityDTO object. This method is primarily
     * used to prepare city data for client response.
     *
     * @param city The City entity that needs to be transformed.
     * @return A new CityDTO object containing the formatted data from the City
     * entity.
     */
    public static CityDTO fromEntity(City city) {
        return new CityDTO(
                city.getName(),
                String.valueOf(city.getLatitude()),
                String.valueOf(city.getLongitude()),
                BigDecimal.valueOf(city.getScore()).setScale(1, RoundingMode.HALF_UP).doubleValue()
        );
    }
}
