package com.gendra.pruebatecnicagilapi.controller;

import static org.mockito.Mockito.*;

import com.gendra.pruebatecnicagilapi.model.dto.CityDTO;
import com.gendra.pruebatecnicagilapi.service.CityService;
import java.util.Collections;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Unit test class for the CityController. This class tests the behavior of the
 * CityController endpoints using mocked service layer. MockMvc is used to
 * simulate HTTP requests and assert responses.
 *
 * @author Gilberto García
 * @version 1.0
 * @since 2023-09-03
 */
@SpringBootTest
@AutoConfigureMockMvc
public class CityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CityService cityService;

    /**
     * Tests the getSuggestions endpoint of the CityController. This test
     * ensures that when a request is made to fetch city suggestions, the
     * endpoint returns expected results based on the provided query parameters
     * and the mock service's response.
     *
     * @throws Exception if any unexpected error occurs during the request
     * handling.
     */
    @Test
    public void testGetSuggestions() throws Exception {
        CityDTO mockCity = new CityDTO("Test City", "12.34", "56.78", 0.9);
        when(cityService.findCities(anyString(), any(), any()))
                .thenReturn(Collections.singletonList(mockCity));

        mockMvc.perform(MockMvcRequestBuilders.get("/suggestions?q=Test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.suggestions[0].name", is("Test City")));
    }
}
