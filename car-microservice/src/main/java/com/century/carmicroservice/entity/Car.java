package com.century.carmicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity()
@Data // Trae Getter, Setter, Equals, HasCode, ToString, RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //Marca
    @Column(name = "name_user")
    private String brand;

    //Modelo
    private String model;

    private Integer userId;

}
