package com.century.bykemicroservice.repository;

import com.century.bykemicroservice.entity.Byke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BykeRepository extends JpaRepository<Byke, Integer> {

    //Obtiene el listado de bykes asociado a este usuario
    List<Byke> findByUserId(Integer userId);

}
