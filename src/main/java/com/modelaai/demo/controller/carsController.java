package com.modelaai.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.modelaai.demo.dto.CarsDTO;
import com.modelaai.demo.models.Car;
import com.modelaai.demo.repository.CarRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/cars")
public class carsController {

  @Autowired
  private CarRepository repository;

  @GetMapping
  public ResponseEntity<List<Car>> getAll() {
    var carList = repository.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(carList);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Car>> getById(@PathVariable Long id) {
    var car = repository.findById(id);
    if(car.isPresent()) {
      return ResponseEntity.status(HttpStatus.OK).body(car);
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
  }

  @PostMapping
  public ResponseEntity<Car> create(@RequestBody @Valid CarsDTO req) {
    Car car = repository.save(new Car(req));
    return ResponseEntity.status(HttpStatus.CREATED).body(car);
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<Optional<Car>> update(@PathVariable Long id, @RequestBody @Valid CarsDTO req) {
    var updatedCar = repository.findById(id)
    .map(car -> {
      car.setModel(req.model());
      car.setManufacturer(req.manufacturer());
      car.setFabricationDate(req.fabricationDate());
      car.setPrice(req.price());
      car.setModelYear(req.modelYear());
      return repository.save(car);
    });
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedCar);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    repository.deleteById(id);
  }

}
