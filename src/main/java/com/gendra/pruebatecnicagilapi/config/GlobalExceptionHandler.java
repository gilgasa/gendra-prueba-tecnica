package com.gendra.pruebatecnicagilapi.config;

import com.gendra.pruebatecnicagilapi.model.exception.BadRequestException;
import com.gendra.pruebatecnicagilapi.model.exception.CityNotFoundException;
import com.gendra.pruebatecnicagilapi.model.exception.InternalServerErrorException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * A centralized handler for exceptions thrown across the application. This
 * handler provides specific responses for various exception types.
 *
 * @author Gilberto García
 * @version 1.0
 * @since 2023-09-03
 */
@ControllerAdvice
@ComponentScan
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handles exceptions of type CityNotFoundException. Returns a notFound
     * (404) response.
     *
     * @param ex The exception to handle.
     * @return A response entity with the appropriate status and body.
     */
    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<String> handleCityNotFoundException(CityNotFoundException ex) {
        logger.error("City not found exception encountered", ex);
        return ResponseEntity.notFound().build();
    }

    /**
     * Handles exceptions of type BadRequestException. Returns a badRequest
     * (400) response with the exception's message.
     *
     * @param ex The exception to handle.
     * @return A response entity with the appropriate status and body.
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBadRequestException(BadRequestException ex) {
        logger.error("Bad request exception encountered", ex);
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    /**
     * Handles exceptions of type InternalServerErrorException. Returns an
     * internalServerError (500) response with the exception's message.
     *
     * @param ex The exception to handle.
     * @return A response entity with the appropriate status and body.
     */
    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<String> handleInternalServerErrorException(InternalServerErrorException ex) {
        logger.error("Internal server error exception encountered", ex);
        return ResponseEntity.internalServerError().body(ex.getMessage());
    }

    /**
     * Handles exceptions of type MethodArgumentNotValidException, which are
     * thrown when method arguments are not valid. Returns a badRequest (400)
     * response with the validation errors.
     *
     * @param ex The exception to handle.
     * @return A response entity with the appropriate status and body containing
     * the validation errors.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        logger.error("Validation errors encountered: {}", errors);
        return ResponseEntity.badRequest().body(errors);
    }
}
