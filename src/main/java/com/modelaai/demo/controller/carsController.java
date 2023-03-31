package com.modelaai.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modelaai.demo.dto.CarsDTO;
import com.modelaai.demo.models.Car;
import com.modelaai.demo.repository.CarRepository;

@RestController
@RequestMapping("/api/cars")
public class carsController {

  @Autowired
  private CarRepository repository;

  @GetMapping
  public List<Car> getAll() {
    return repository.findAll();
  }

  @PostMapping
  public void createCar(@RequestBody CarsDTO req) {
    repository.save(new Car(req));
  }
}
