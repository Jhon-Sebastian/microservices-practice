package com.century.carmicroservice.repository;

import com.century.carmicroservice.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    //Obtener el usuario del Carro
    List<Car> findByUserId(Integer userId);

}
