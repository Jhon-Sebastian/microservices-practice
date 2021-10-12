package com.century.carmicroservice.controller;

import com.century.carmicroservice.entity.Car;
import com.century.carmicroservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;


    @GetMapping()
    public ResponseEntity<List<Car>> getAllCars(){
        List<Car> cars = carService.getAll();
        if(cars.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cars);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Integer id){
        Car car = carService.getCarById(id);
        if(car == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(car);
    }


    @PostMapping()
    public ResponseEntity<Car> saveCar(@RequestBody Car user){
        Car saveCar = carService.save(user);
        return ResponseEntity.ok(saveCar);
    }

    //Obtener los carros que tega el id del usuario
    @GetMapping("/byuser/{userId}")
    public ResponseEntity<List<Car>> getAllCarsByUserId(@PathVariable Integer userId){
        List<Car> cars = carService.allCarsbyUserId(userId);
        return ResponseEntity.ok(cars);
    }

}
