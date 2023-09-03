package com.gendra.pruebatecnicagilapi.util;

import com.gendra.pruebatecnicagilapi.model.entity.City;
import com.gendra.pruebatecnicagilapi.repository.CityRepository;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

/**
 * DataLoader utility for initializing the database with cities' data. This
 * component runs on startup and populates the database with city data from a
 * file.
 *
 * @author Gilberto García
 * @version 1.0
 * @since 2023-09-03
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final CityRepository cityRepository;

    /**
     * Constructor for DataLoader.
     *
     * @param cityRepository Repository for performing CRUD operations on city
     * entities.
     */
    @Autowired
    public DataLoader(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    /**
     * Loads cities data into the database on application startup.
     *
     * @param args Command line arguments (unused in this context).
     * @throws Exception If there's an error reading from the file or saving to
     * the database.
     */
    @Override
    public void run(String... args) throws Exception {
        loadCitiesFromFile();
    }

    /**
     * Loads cities from a file (cities_canada-usa.tsv) located in the resources
     * directory. Assumes that the first line of the file contains headers and
     * skips it. Parses the subsequent lines to extract city names, latitudes,
     * and longitudes, and saves them to the database.
     *
     * @throws Exception If there's an error reading from the file or saving to
     * the database.
     */
    private void loadCitiesFromFile() throws Exception {
        ClassPathResource resource = new ClassPathResource("cities_canada-usa.tsv");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            // Skip the header line
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] fields = line.split("\t");
                String name = fields[1];
                Double latitude = Double.valueOf(fields[4]);
                Double longitude = Double.valueOf(fields[5]);
                cityRepository.save(new City(name, latitude, longitude));
            }
        }
    }
}
