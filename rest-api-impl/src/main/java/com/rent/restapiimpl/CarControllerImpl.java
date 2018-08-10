package com.rent.restapiimpl;


import com.rent.model.dto.CarDto;
import com.rent.model.entity.Car;
import com.rent.model.repository.CarRepository;
import com.rent.restapi.Car.CarController;
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

    private final CarRepository carRepository;

    public CarControllerImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
        public List<CarDto> getAllCars() {
            List<CarDto> list = new ArrayList<>();
            carRepository.findAll().forEach(car -> {
                list.add(car.toCarDto());
            });
            return list;
        }


    @Override
    public ResponseEntity addCar(@RequestBody CarDto carDto) {
        Car car = new Car();
        //carDto.setUsed(true);
        car.update(carDto);
        carRepository.save(car);
        return new ResponseEntity("The car was added", HttpStatus.OK);
    }


    @Override
    public ResponseEntity editCar(@RequestBody CarDto carDto, @PathVariable Long id) {
        Car car = carRepository.findById(id).get();
        car.setCarPrice(carDto.getCarPrice());
        car.setCombustibleCar(carDto.getCombustibleCar());
        car.setMarkCar(carDto.getMarkCar());
        car.setRegistrationNumber(carDto.getRegistrationNumber());
        car.setUsed(carDto.getUsed());
        carRepository.save(car);
        return new ResponseEntity("The car was edit succesfull", HttpStatus.OK);
    }



    @Override
    public ResponseEntity deleteCar(@PathVariable Long id) {
        Car car = carRepository.findById(id).get();
        carRepository.delete(car);
        return new ResponseEntity("Car was deleted!", HttpStatus.OK);
    }

    @Override
    public CarDto findCar(@PathVariable Long id) {
        Car car = carRepository.findById(id).get();
        return car.toCarDto();
    }

    @Override
    public CarDto getAllAvailableCar(@PathVariable String used) {
        Car car = new Car();
        car = carRepository.findByUsed(used);
        List myLyst = new ArrayList();
        myLyst.add(car.toCarDto());
        return car.toCarDto();
    }


}



