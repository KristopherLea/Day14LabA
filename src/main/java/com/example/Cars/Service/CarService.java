package com.example.Cars.Service;

import com.example.Cars.Model.Car;

import java.util.Optional;

public interface CarService {


    Optional<Car> getCarById(Long id);
    Car getCarByMake(String make);
    Iterable<Car> getAllCars();
    void saveCar(Car car);
    Optional<Car> updateCar(Car newCar, Long id);
    void removeCar(Long id);
}
