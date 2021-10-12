package com.century.bykemicroservice.controller;

import com.century.bykemicroservice.entity.Byke;
import com.century.bykemicroservice.service.BykeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/byke")
public class BykeController {

    @Autowired
    private BykeService bykeService;


    @GetMapping()
    public ResponseEntity<List<Byke>> getAllBykes(){
        List<Byke> bykes = bykeService.getAll();
        if(bykes.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bykes);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Byke> getBykeById(@PathVariable Integer id){
        Byke byke = bykeService.getBykeById(id);
        if(byke == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(byke);
    }


    @PostMapping()
    public ResponseEntity<Byke> saveByke(@RequestBody Byke user){
        Byke saveByke = bykeService.save(user);
        return ResponseEntity.ok(saveByke);
    }

    //Obtener las motos que tenga el usuario
    @GetMapping("/byuser/{userId}")
    public ResponseEntity<List<Byke>> getAllBykesByUserId(@PathVariable Integer userId){
        List<Byke> bykes = bykeService.allBykesOfuserId(userId);
        return ResponseEntity.ok(bykes);
    }

}
