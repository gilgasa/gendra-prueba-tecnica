package com.gendra.pruebatecnicagilapi.service;

import com.gendra.pruebatecnicagilapi.model.dto.CityDTO;
import java.util.List;
import java.util.Optional;

/**
 * Service interface for city-related operations. Provides methods to retrieve
 * and rank cities based on given criteria.
 *
 * @author Gilberto García
 * @version 1.0
 * @since 2023-09-03
 */
public interface CityService {

    /**
     * Retrieves a list of cities matching the provided search term and
     * optionally ranks them based on proximity to a given latitude and
     * longitude.
     *
     * @param searchTerm The search term for city names.
     * @param latitude Optional latitude to rank cities based on proximity.
     * @param longitude Optional longitude to rank cities based on proximity.
     * @return List of CityDTO objects ranked based on relevance and optionally
     * proximity.
     */
    List<CityDTO> findCities(String searchTerm, Optional<Double> latitude, Optional<Double> longitude);
}
