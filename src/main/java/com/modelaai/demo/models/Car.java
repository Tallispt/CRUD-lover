package com.modelaai.demo.models;

import java.util.Date;

import com.modelaai.demo.dto.CarsDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Car {

  public Car(CarsDTO req) {
    this.model = req.model();
    this.manufacturer = req.manufacturer();
    this.fabricationDate = req.fabricationDate();
    this.price = req.price();
    this.modelYear = req.modelYear();
  }
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 50, nullable = false)
  private String model;

  @Column(nullable = false)
  private String manufacturer;

  @Column(nullable = false)
  private Date fabricationDate;

  @Column(nullable = false)
  private int price;

  @Column(nullable = false)
  private int modelYear;

}
