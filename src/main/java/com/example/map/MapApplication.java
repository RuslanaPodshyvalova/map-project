package com.example.map;

import com.example.map.model.City;
import com.example.map.model.Location;
import com.example.map.repository.CityRepository;
import com.example.map.repository.LocationRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MapApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(MapApplication.class, args);

        CityRepository cityRepository = configurableApplicationContext.getBean(CityRepository.class);
        LocationRepository locationRepository = configurableApplicationContext.getBean(LocationRepository.class);

        City city = new City("Kyiv");
        Location location_1 = new Location("30.5624", "50.4356", "Lavrska St, 15, Kyiv, 01015", "Ornate religious buildings line this iconic monastic complex, known for its network of catacombs.", city);
        Location location_2 = new Location("30.5378", "50.4276", "Zapecherna St, Kyiv, 02000", "Huge statue atop of the National Museum of the History of the Great Patriotic War of 1941-1945.", city);
        List<Location> records = Arrays.asList(location_1, location_2);
        city.setLocations(records);
        cityRepository.save(city);

        city = new City("Cherkasy");
        location_1 = new Location("32.0224", "49.4198", "Smilyanska St, 132, Cherkasy", "City zoo", city);
        records = Arrays.asList(location_1);
        city.setLocations(records);
        cityRepository.save(city);
    }
}