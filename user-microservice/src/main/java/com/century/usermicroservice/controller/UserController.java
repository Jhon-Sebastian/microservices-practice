package com.century.usermicroservice.controller;

import com.century.usermicroservice.entity.User;
import com.century.usermicroservice.models.Byke;
import com.century.usermicroservice.models.Car;
import com.century.usermicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //Lista de usuarios
    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAll();
        if(users.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(users);
    }


    //Obtener un Usuario
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id){
        User user = userService.getUserById(id);
        if(user == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(user);
    }


    //Crear un Usuario
    @PostMapping()
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User saveUser = userService.save(user);
        return ResponseEntity.ok(saveUser);
    }


    //TODO ------------------MICROSERVICES-------------------------


    //Obtiene los carros del id del usuario indicado
    @GetMapping("/cars/{userId}")
    public ResponseEntity<List<Car>> getAllCarsOfUserId(@PathVariable Integer userId){
        List<Car> cars = userService.getCarsOfUserid(userId);
        if(cars.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }

    //Obtiene los motos del id del usuario indicado
    @GetMapping("/bykes/{userId}")
    public ResponseEntity<List<Byke>> getAllBykesOfUserId(@PathVariable Integer userId){
        List<Byke> bykes = userService.getBykesOfUserId(userId);
        if(bykes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bykes);
    }



    //TODO ------------------OpenFeign-------------------------
    //Crea un carro a partir de un Usuario
    @PostMapping("/savecar/{userId}")
    public ResponseEntity<Car> saveCar(@PathVariable Integer userId, @RequestBody Car car){
        if(userService.getUserById(userId) == null){
            return ResponseEntity.notFound().build();
        }
        Car carNew = userService.saveCar(userId, car);
        return ResponseEntity.ok(car);
    }

    //Crea una moto a partir de un Usuario
    @PostMapping("/savebyke/{userId}")
    public ResponseEntity<Byke> saveByke(@PathVariable Integer userId, @RequestBody Byke byke){
        if(userService.getUserById(userId) == null){
            return ResponseEntity.notFound().build();
        }
        Byke bykeNew = userService.saveByke(userId, byke);
        return ResponseEntity.ok(byke);
    }

    //Obtiene el usuario,ademas carross y motos del usuario
    @GetMapping("/getAll/{userId}")
    public ResponseEntity<Map<String,Object>> getAllVehicles(@PathVariable Integer userId){
        Map<String, Object> response = userService.getUserAndVehicles(userId);
        return ResponseEntity.ok(response);
    }


}
