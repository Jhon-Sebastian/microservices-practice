package com.century.usermicroservice.feignclients;

import com.century.usermicroservice.models.Byke;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "byke-microservice")
@RequestMapping("/byke")
public interface BykeFeignClient {

    //Guarda una Moto
    //Llama al metodo que se encuentra en el byke-microservice para hacer el save
    @PostMapping()
    Byke saveByke(Byke user);

    @GetMapping("/byuser/{userId}")
    List<Byke> getAllBykesByUserId(@PathVariable Integer userId);

}
