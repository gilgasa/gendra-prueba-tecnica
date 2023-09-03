package com.gendra.pruebatecnicagilapi.repository;

import com.gendra.pruebatecnicagilapi.model.entity.City;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for performing CRUD operations on City entities. Extends
 * JpaRepository to leverage Spring Data JPA's built-in methods for database
 * interactions.
 *
 * @author Gilberto García
 * @version 1.0
 * @since 2023-09-03
 */
public interface CityRepository extends JpaRepository<City, Long> {

    /**
     * Retrieves a list of cities that match a given search term. The search is
     * case insensitive and checks if the city name contains the provided term.
     *
     * @param term The search term for city names.
     * @return List of City objects that match the search criteria.
     */
    List<City> findByNameContainingIgnoreCase(String term);
}
