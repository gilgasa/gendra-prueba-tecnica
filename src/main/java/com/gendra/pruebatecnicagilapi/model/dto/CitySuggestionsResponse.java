package com.gendra.pruebatecnicagilapi.model.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Data Transfer Object (DTO) for encapsulating city suggestions in a response
 * format. This class is used to send a list of city suggestions as a response
 * to the client.
 *
 * @author Gilberto García
 * @version 1.0
 * @since 2023-09-03
 */
@Data
@AllArgsConstructor
public class CitySuggestionsResponse {

    /**
     * A list of city suggestions represented as CityDTO objects.
     */
    private List<CityDTO> suggestions;
}
