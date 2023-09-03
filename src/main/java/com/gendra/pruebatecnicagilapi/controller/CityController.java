package com.gendra.pruebatecnicagilapi.controller;

import com.gendra.pruebatecnicagilapi.model.dto.CityDTO;
import com.gendra.pruebatecnicagilapi.model.dto.CitySuggestionsResponse;
import com.gendra.pruebatecnicagilapi.model.request.CitySuggestionRequest;
import com.gendra.pruebatecnicagilapi.service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * CityController is responsible for handling HTTP requests related to cities.
 * It manages the endpoints that provide information and suggestions about
 * cities.
 *
 * @author Gilberto García
 * @version 1.0
 * @since 2023-09-03
 */
@RestController
@Validated
@Api(value = "City Management", description = "Endpoints for managing cities")
public class CityController {

    private static final Logger logger = LoggerFactory.getLogger(CityController.class);

    /**
     * Service to manage city-related operations.
     */
    @Autowired
    private CityService cityService;

    /**
     * Provides city suggestions based on the given criteria. Returns a list of
     * cities based on a search term and optionally latitude and longitude.
     *
     * @param request The request containing the search criteria (search term,
     * latitude, and longitude).
     * @return A CitySuggestionsResponse containing a list of suggested cities.
     */
    @GetMapping("/suggestions")
    @ApiOperation(value = "Get city suggestions based on criteria", response = CitySuggestionsResponse.class)
    public CitySuggestionsResponse getSuggestions(@Valid @ModelAttribute CitySuggestionRequest request) {

        logger.info("Received city suggestion request with term '{}', latitude: {}, longitude: {}",
                request.getQ(), request.getLatitude(), request.getLongitude());

        List<CityDTO> cities = cityService.findCities(
                request.getQ(),
                Optional.ofNullable(request.getLatitude()),
                Optional.ofNullable(request.getLongitude())
        );

        logger.info("Returning {} city suggestions for term '{}'.", cities.size(), request.getQ());

        return new CitySuggestionsResponse(cities);
    }
}
