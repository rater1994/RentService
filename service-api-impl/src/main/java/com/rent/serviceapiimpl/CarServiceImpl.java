package com.rent.serviceapiimpl;

import com.rent.model.dto.CarDto;
import com.rent.model.entity.Car;
import com.rent.model.repository.CarRepository;
import com.rent.serviceapi.CarService;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {

        private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public CarDto findById(Long id) {
        Car car = carRepository.findById(id).get();
        return car.toCarDto();
    }


    @Override
    public List<CarDto> getAllCarsDTO() {
        List<CarDto> list = new ArrayList<>();
        carRepository.findAll().forEach(car -> {
            list.add(car.toCarDto());
        });
        return list;
    }


}
