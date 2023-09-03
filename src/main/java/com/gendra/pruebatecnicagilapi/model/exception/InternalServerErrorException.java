package com.gendra.pruebatecnicagilapi.model.exception;

/**
 * Exception thrown when an unexpected internal error occurs. Typically, this
 * represents errors that should not occur under normal operation.
 *
 * @author Gilberto García
 * @version 1.0
 * @since 2023-09-03
 */
public class InternalServerErrorException extends RuntimeException {

    public InternalServerErrorException(String message) {
        super(message);
    }
}
