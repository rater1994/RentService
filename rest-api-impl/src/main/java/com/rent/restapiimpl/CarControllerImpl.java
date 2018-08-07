package com.rent.restapiimpl;


import com.rent.model.dto.CarDto;
import com.rent.restapi.Car.CarController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarControllerImpl implements CarController {
   /* @Override
    public ResponseEntity addCar(CarDto car) {
        return null;
    }*/

    @Override
    public List<CarDto> getAllCars() {
        return null;
    }
}
