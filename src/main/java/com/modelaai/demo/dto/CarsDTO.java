package com.modelaai.demo.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record CarsDTO(  
  
@NotBlank
@NotNull
String model,

@NotBlank
@NotNull
String manufacturer,

@NotNull
@Past
Date fabricationDate,

@NotNull
int price,

@NotNull
int modelYear) {
}
