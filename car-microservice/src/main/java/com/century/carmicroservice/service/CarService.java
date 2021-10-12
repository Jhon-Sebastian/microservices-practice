package com.century.carmicroservice.service;

import com.century.carmicroservice.entity.Car;
import com.century.carmicroservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Transactional(readOnly = true)
    public List<Car> getAll(){
        return carRepository.findAll();
    }

    @Transactional
    public Car getCarById(Integer id){
        return carRepository.findById(id).orElse(null);
    }

    @Transactional
    public Car save(Car user){
        return carRepository.save(user);
    }

    /*
        Obtener el usuario del carro
        La logica es que le pasamos el id_buscar, entonces lo que le
        decimos en Jpa con JPQL es que nos trae el Objeto Car
        el cual tenga un userId = 'id_buscar'.

        Y si tiene varios carros con un mismo userId
        se sabe que es un usuario que tiene varios carros
     */
    public List<Car> allCarsbyUserId(Integer userId){
        return carRepository.findByUserId(userId);
    }

}
