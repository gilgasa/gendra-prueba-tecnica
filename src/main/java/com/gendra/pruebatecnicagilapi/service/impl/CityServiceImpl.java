package com.gendra.pruebatecnicagilapi.service.impl;

import com.gendra.pruebatecnicagilapi.model.dto.CityDTO;
import com.gendra.pruebatecnicagilapi.model.entity.City;
import com.gendra.pruebatecnicagilapi.repository.CityRepository;
import com.gendra.pruebatecnicagilapi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of the CityService interface. Provides methods to search and
 * rank cities based on the given criteria.
 *
 * @author Gilberto García
 * @version 1.0
 * @since 2023-09-03
 */
@Service
public class CityServiceImpl implements CityService {

    private static final Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);

    @Autowired
    private CityRepository cityRepository;

    /**
     * Retrieves a list of cities matching the provided search term, and
     * optionally ranked based on proximity to a given latitude and longitude.
     *
     * @param searchTerm The search term for city names.
     * @param latitude Optional latitude to rank cities based on proximity.
     * @param longitude Optional longitude to rank cities based on proximity.
     * @return List of CityDTO objects ranked based on relevance and optionally
     * proximity.
     */
    @Override
    public List<CityDTO> findCities(String searchTerm, Optional<Double> latitude, Optional<Double> longitude) {
        List<City> cities = cityRepository.findByNameContainingIgnoreCase(searchTerm);

        // Logging the search term and the number of cities found.
        logger.info("Searching for cities with term '{}', found {} results.", searchTerm, cities.size());

        for (City city : cities) {
            double score = calculateRelevanceScore(city, searchTerm);
            if (latitude.isPresent() && longitude.isPresent()) {
                score *= calculateProximityScore(city, latitude.get(), longitude.get());
            }
            city.setScore(score);
        }

        cities.sort((c1, c2) -> Double.compare(c2.getScore(), c1.getScore())); // sorting in descending order

        return cities.stream()
                .map(CityDTO::fromEntity)
                .collect(Collectors.toList());
    }

    /**
     * Calculates a relevance score for a city based on its name's similarity to
     * the provided search term.
     *
     * @param city The city entity.
     * @param searchTerm The search term for comparison.
     * @return Relevance score as a double.
     */
    private double calculateRelevanceScore(City city, String searchTerm) {
        return (double) searchTerm.length() / city.getName().length();
    }

    /**
     * Calculates a proximity score for a city based on its distance from a
     * given latitude and longitude.
     *
     * @param city The city entity.
     * @param lat Latitude for comparison.
     * @param lon Longitude for comparison.
     * @return Proximity score as a double.
     */
    private double calculateProximityScore(City city, double lat, double lon) {
        double distance = distance(city.getLatitude(), city.getLongitude(), lat, lon);
        return 1 / (1 + distance);
    }

    /**
     * Calculates the distance between two geographical points based on their
     * latitude and longitude using the Haversine formula.
     *
     * @param lat1 Latitude of the first point.
     * @param lon1 Longitude of the first point.
     * @param lat2 Latitude of the second point.
     * @param lon2 Longitude of the second point.
     * @return Distance between the two points in kilometers.
     */
    private double distance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radius of the Earth in km
        double deltaLat = Math.toRadians(lat2 - lat1);
        double deltaLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}
