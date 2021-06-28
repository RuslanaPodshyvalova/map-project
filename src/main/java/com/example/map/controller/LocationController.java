package com.example.map.controller;

import com.example.map.model.Location;
import com.example.map.repository.CityRepository;
import com.example.map.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private CityRepository cityRepository;

    @GetMapping
    List<Location> getLocations() {
        return locationRepository.findAll();
    }

    @PostMapping
    Location createLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }
}
