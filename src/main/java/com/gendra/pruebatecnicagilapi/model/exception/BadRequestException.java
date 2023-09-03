package com.gendra.pruebatecnicagilapi.model.exception;

/**
 * Exception thrown when the request made by the client is malformed or invalid.
 * This can be due to invalid parameters, missing required data, or other forms
 * of bad client requests.
 *
 * @author Gilberto García
 * @version 1.0
 * @since 2023-09-03
 */
public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}
