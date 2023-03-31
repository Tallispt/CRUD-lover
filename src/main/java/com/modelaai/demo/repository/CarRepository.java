package com.modelaai.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modelaai.demo.models.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
  
}
