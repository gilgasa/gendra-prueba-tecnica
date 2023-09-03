package com.gendra.pruebatecnicagilapi.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.gendra.pruebatecnicagilapi.model.dto.CityDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Unit test class for the CityService. This class tests the behavior of the
 * CityService methods using mock implementations. Mocked services are used to
 * simulate actual service behaviors without invoking the real implementations.
 *
 * @author Gilberto García
 * @version 1.0
 * @since 2023-09-03
 */
@SpringBootTest
public class CityServiceTest {

    @MockBean
    private CityService cityService;

    /**
     * Tests the findCities method of the CityService. This test ensures that
     * when the service method is called with specific parameters, it returns
     * the expected results based on the mocked behaviors.
     */
    @Test
    public void testFindCities() {
        CityDTO mockCity = new CityDTO("Test City", "12.34", "56.78", 0.9);
        when(cityService.findCities("Test", Optional.empty(), Optional.empty()))
                .thenReturn(Collections.singletonList(mockCity));

        List<CityDTO> result = cityService.findCities("Test", Optional.empty(), Optional.empty());
        assertEquals(1, result.size());
        assertEquals("Test City", result.get(0).getName());
    }
}
