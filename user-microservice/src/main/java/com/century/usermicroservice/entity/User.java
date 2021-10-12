package com.century.usermicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "users")
@Data // Trae Getter, Setter, Equals, HasCode, ToString, RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_user")
    private String name;

    private String email;

}
