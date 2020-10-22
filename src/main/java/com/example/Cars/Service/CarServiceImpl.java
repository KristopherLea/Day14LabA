package com.example.Cars.Service;

import com.example.Cars.Model.Car;
import com.example.Cars.Repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepo carRepo;

    @Override
    public Optional<Car> getCarById(Long id) {
        return carRepo.findById(id);
    }

    @Override
    public Car getCarByMake(String make) {
        return null;
    }

    @Override
    public Iterable<Car> getAllCars() {
        return carRepo.findAll();
    }

    @Override
    public void saveCar(Car car) {
        carRepo.save(car);
    }

    @Override
    public Optional<Car> updateCar(Car newCar, Long id) {
        carRepo.findById(id)
            .map(car -> {
                car.setYear(newCar.getYear());
                car.setMake(newCar.getMake());
                car.setModel(newCar.getModel());
                return carRepo.save(car);
            });
        return carRepo.findById(id);
    }

    @Override
    public void removeCar(Long id) {
        carRepo.deleteById(id);
    }
}
