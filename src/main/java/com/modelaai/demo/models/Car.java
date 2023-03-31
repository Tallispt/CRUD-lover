package com.modelaai.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Car {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 50, nullable = false)
  private String model;

  @Column(length = 50, nullable = false)
  private String manufacturer;

  @Column(nullable = false)
  private String fabricationDate;

  @Column(nullable = false)
  private int price;

  @Column(nullable = false)
  private int modelYear;


}
