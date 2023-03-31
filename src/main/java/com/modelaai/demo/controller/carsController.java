package com.modelaai.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modelaai.demo.dto.CarsDTO;

@RestController
@RequestMapping("/cars")
public class carsController {

  @PostMapping
  public void createCar(@RequestBody CarsDTO req) {
    System.out.println(req);
  }
}
