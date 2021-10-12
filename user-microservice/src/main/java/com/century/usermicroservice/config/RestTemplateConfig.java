package com.century.usermicroservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    //Unica instancia
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
