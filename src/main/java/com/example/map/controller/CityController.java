package com.example.map.controller;

import com.example.map.model.City;
import com.example.map.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    CityRepository cityRepository;

    @GetMapping
    List<City> getCities() {
        return cityRepository.findAll();
    }

    @PostMapping
    City createTeacher(@RequestBody City teacher) {
        return cityRepository.save(teacher);
    }
}