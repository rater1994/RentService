package com.rent.restapiimpl;


import com.rent.model.dto.CarDto;
import com.rent.model.entity.Car;
import com.rent.model.repository.CarRepository;
import com.rent.restapi.Car.CarController;
import com.rent.serviceapi.CarService;
import com.rent.serviceapiimpl.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class CarControllerImpl implements CarController {

/*    @Autowired
    CarRepository carRepository;*/


    @Autowired
    private CarService carService;

    @Autowired
    private CarRepository carRepository;


    public CarControllerImpl(CarRepository carRepository,CarService carService) {
        this.carRepository = carRepository;
        this.carService = carService;
    }

    @Override
        public List<CarDto> getAllCars() {
        return carService.getAllCarsDTO();
    }

    @Override
    public ResponseEntity addCar(@RequestBody CarDto carDto) {
        carService.addCarDTO(carDto);
        //return new ResponseEntity("The car was added", HttpStatus.OK);
        return ResponseEntity.ok(carDto);
    }

    @Override
    public ResponseEntity editCar(@RequestBody CarDto carDto, @PathVariable Long id) {
        final CarDto returnCarDto = carService.editCarDTO(carDto, id);
        if (returnCarDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(returnCarDto);
        //return new ResponseEntity("The car was edit succesfull", HttpStatus.OK);
    }
    @Override
    public ResponseEntity deleteCar(@PathVariable Long id) {
        try {
            carService.deleteCarDTO(id);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok().build();
    }
    @Override
    public CarDto findCar(@PathVariable Long id) {
         return carService.findById(id);
    }
}



