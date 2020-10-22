package com.example.Cars.Controller;


import com.example.Cars.Model.Car;
import com.example.Cars.Service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
    @RequestMapping("/api")
    public class CarController {

        @Autowired
        CarServiceImpl carServiceImpl;


        @GetMapping("/get/car/{id}")
        public Optional<Car> getCarById(@PathVariable Long id){
            return carServiceImpl.getCarById(id);
        }

        //save method
        @PostMapping("/post/car")
        public String saveCar(@RequestBody Car car){
            carServiceImpl.saveCar(car);
            return "car saved";
        }

        // update method
        @PutMapping("/put/car/{id}")
        public Optional<Car> updateCar(@RequestBody Car newCar, @PathVariable Long id){
            return carServiceImpl.updateCar(newCar, id);
        }


        // delete method

        @DeleteMapping("/delete/car/{id}")
        public String deleteCar(@PathVariable Long id){
            carServiceImpl.removeCar(id);
            return "car deleted";
        }

    }

