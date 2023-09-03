package com.gendra.pruebatecnicagilapi.model.exception;

/**
 * Exception thrown when a city requested by the client is not found in the
 * system. This could happen if the city does not exist or if there is no match
 * based on the given search criteria.
 *
 * @author Gilberto García
 * @version 1.0
 * @since 2023-09-03
 */
public class CityNotFoundException extends RuntimeException {

    public CityNotFoundException(String message) {
        super(message);
    }
}
