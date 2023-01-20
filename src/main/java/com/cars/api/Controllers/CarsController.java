package com.cars.api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cars.api.Model.Car;
import com.cars.api.dto.CarDTO;
import com.cars.api.repository.CarRepository;

@RestController
@RequestMapping("/car")
public class CarsController {

  @Autowired
  private CarRepository carRepository;
  
  @PostMapping
  public void create(@RequestBody CarDTO req){
    carRepository.save(new Car(req));
  }

  @GetMapping
  public List<Car> listAll(){
    return carRepository.findAll();
  }
}
