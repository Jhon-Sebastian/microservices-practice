package com.century.usermicroservice.service;

import com.century.usermicroservice.entity.User;
import com.century.usermicroservice.feignclients.BykeFeignClient;
import com.century.usermicroservice.feignclients.CarFeignClient;
import com.century.usermicroservice.models.Byke;
import com.century.usermicroservice.models.Car;
import com.century.usermicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    //Repository
    @Autowired
    private UserRepository userRepository;

    //Microservicios con API Rest -> RestTemplate
    @Autowired
    private RestTemplate restTemplate;

    //Microservicios con Spring-Cloud Feign
    @Autowired
    private CarFeignClient carFeignClient;

    @Autowired
    private BykeFeignClient bykeFeignClient;


    @Transactional(readOnly = true)
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Transactional
    public User getUserById(Integer id){
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public User save(User user){
        return userRepository.save(user);
    }


    //TODO ------------------MICROSERVICES-------------------------

    //Obtener los carros asociados al userId de la entity Car en car-microservice
    public List<Car> getCarsOfUserid(Integer userId){
        return restTemplate.getForObject("http://localhost:8002/car/byuser/" + userId, List.class);
    }

    //Obtener los carros asociados al userId de la entity Car en car-microservice
    public List<Byke> getBykesOfUserId(Integer userId){
        return restTemplate.getForObject("http://localhost:8003/byke/byuser/" + userId, List.class);
    }


    //TODO ------------------OpenFeign-------------------------
    public Car saveCar(Integer userId, Car car){
        car.setUserId(userId);
        return carFeignClient.saveCar(car);
    }

    public Byke saveByke(Integer userId, Byke byke){
        byke.setUserId(userId);
        return bykeFeignClient.saveByke(byke);
    }

    public Map<String, Object> getUserAndVehicles(Integer userId){
        Map<String, Object> response = new HashMap<>();
        User user = userRepository.findById(userId).orElse(null);
        if(user == null){
            response.put("Mensaje","No existe el usuario");
            return  response;
        }
        response.put("User", user);
        List<Car> cars = carFeignClient.getAllCarsByUserId(userId);
        if(cars.isEmpty()){
            response.put("Cars"," ese user no tiene coches");
        }else{
            response.put("Cars", cars);
        }
        List<Byke> bykes = bykeFeignClient.getAllBykesByUserId(userId);
        if(bykes.isEmpty()){
            response.put("Bykes"," ese user no tiene motos");
        }else{
            response.put("Bykes", bykes);
        }
        return  response;
    }

}
