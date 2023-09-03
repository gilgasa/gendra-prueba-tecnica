package com.gendra.pruebatecnicagilapi.config;

import static org.junit.jupiter.api.Assertions.*;

import com.gendra.pruebatecnicagilapi.model.exception.CityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

/**
 * Unit test class for the GlobalExceptionHandler. This class tests the behavior
 * of the exception handling methods provided by the GlobalExceptionHandler.
 *
 * @author Gilberto García
 * @version 1.0
 * @since 2023-09-03
 */
@SpringBootTest
public class GlobalExceptionHandlerTest {

    @Autowired
    private GlobalExceptionHandler exceptionHandler;

    /**
     * Tests the handleCityNotFoundException method of the
     * GlobalExceptionHandler. Ensures that when a CityNotFoundException is
     * encountered, the appropriate HTTP status code is returned.
     */
    @Test
    public void testHandleCityNotFoundException() {
        ResponseEntity<String> response = exceptionHandler.handleCityNotFoundException(new CityNotFoundException("Not found"));
        assertEquals(404, response.getStatusCodeValue());
    }
}
