package com.carshop.controllers;

import com.carshop.entities.Car;
import com.carshop.models.CarSearchRequest;
import com.carshop.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class intercepts all the request sent to localhost:8080/cars
 */
@RestController
@RequestMapping("cars")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CarController {

    private final CarService carService;

    /**
     * Returns all the car objects stored in the database
     * @return List<Car>
     */
    @GetMapping
    public List<Car> getCars() {
        return carService.getAll();
    }

    /**
     * Receives a {@link CarSearchRequest} object that holds the values filled by the user via the UI, and forwards it to the service layer
     * in order to perform the search query, then it returns the result to the UI as {@link List<Car>}
     *
     * @param request
     * @return List<Car>
     */
    @PostMapping(value = "search")
    public List<Car> searchCars(@RequestBody CarSearchRequest request) {
        return carService.searchCars(request);
    }
}
