package com.rent.serviceapiimpl;

import com.rent.model.dto.CarDto;
import com.rent.model.entity.Car;
import com.rent.model.repository.CarRepository;
import com.rent.serviceapi.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public CarDto findById(Long id) {
        if (carRepository.findById(id).isPresent()) {
            return carRepository.findById(id).get().toCarDto();
        }
       return  null;
    }

    @Override
    public CarDto addCarDTO(CarDto carDto) {
        Car car = new Car();
        car.update(carDto);
        return  carRepository.save(car).toCarDto();
    }

    @Override
    public CarDto editCarDTO(CarDto carDto, Long id) {
        final Optional<Car> dbCar = carRepository.findById(id);

        if (dbCar.isPresent()) {
            Car car = dbCar.get();
            car.setCarPrice(carDto.getCarPrice());
            car.setCombustibleCar(carDto.getCombustibleCar());
            car.setMarkCar(carDto.getMarkCar());
            car.setRegistrationNumber(carDto.getRegistrationNumber());
            car.setUsed(carDto.getUsed());
            car.setTransmissionCar(carDto.getTransmissionCar());
            return carRepository.save(car).toCarDto();
        }

        return null;
    }

    @Override
    public void deleteCarDTO(Long id) throws RuntimeException{
        try {
            carRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Cannot delete car with ID: " + id);
        }
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
