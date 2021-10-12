package com.century.usermicroservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    //Marca
    @Column(name = "name_user")
    private String brand;

    //Modelo
    private String model;

    private Integer userId;

}
