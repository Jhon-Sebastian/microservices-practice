package com.century.bykemicroservice.service;

import com.century.bykemicroservice.entity.Byke;
import com.century.bykemicroservice.repository.BykeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BykeService {

    @Autowired
    private BykeRepository bykeRepository;

    @Transactional(readOnly = true)
    public List<Byke> getAll(){
        return bykeRepository.findAll();
    }

    @Transactional
    public Byke getBykeById(Integer id){
        return bykeRepository.findById(id).orElse(null);
    }

    @Transactional
    public Byke save(Byke user){
        return bykeRepository.save(user);
    }

    //Obtiene el listado de bykes asociado a este usuario
    public List<Byke> allBykesOfuserId(Integer userId){
        return bykeRepository.findByUserId(userId);
    }

}
