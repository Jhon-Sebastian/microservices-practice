package com.century.usermicroservice.feignclients;

import com.century.usermicroservice.models.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
/*
    Como ya esta registrado en eureka no hace falta colocarlo
    @FeignClient(name = "car-microservice", url = "http://localhost:8002")
 */
@FeignClient(name = "car-microservice")
@RequestMapping("/car")
public interface CarFeignClient {

    //Crear un coche y se le pasa el usuario, se esta llamado al metodo del car-microservice
    @PostMapping()
    Car saveCar(Car user);

    @GetMapping("/byuser/{userId}")
    List<Car> getAllCarsByUserId(@PathVariable Integer userId);


}