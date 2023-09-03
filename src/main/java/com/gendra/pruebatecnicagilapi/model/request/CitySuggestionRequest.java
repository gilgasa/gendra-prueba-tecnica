package com.gendra.pruebatecnicagilapi.model.request;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for receiving city suggestion criteria from client
 * requests. Contains parameters like query string, latitude, and longitude to
 * aid in providing city suggestions.
 *
 * @author Gilberto García
 * @version 1.0
 * @since 2023-09-03
 */
@Getter
@Setter
@NoArgsConstructor
public class CitySuggestionRequest {

    /**
     * The query string representing a partial or complete city name.
     */
    @NotNull(message = "Query is required.")
    @ApiModelProperty(value = "Query string representing a partial or complete city name.", example = "Londo")
    private String q;

    /**
     * The latitude value to aid in proximity-based city suggestions. Optional
     * but can be used to enhance the relevancy of suggestions.
     */
    @ApiModelProperty(value = "Latitude value for proximity-based city suggestions. Helps enhance suggestion relevancy.", example = "43.70011")
    private Double latitude;

    /**
     * The longitude value to aid in proximity-based city suggestions. Optional
     * but can be used to enhance the relevancy of suggestions.
     */
    @ApiModelProperty(value = "Longitude value for proximity-based city suggestions. Helps enhance suggestion relevancy.", example = "-79.4163")
    private Double longitude;
}
