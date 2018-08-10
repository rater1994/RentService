package com.rent.restapi.Car;


import com.rent.model.dto.CarDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/car")
public interface CarController {

    //All method: add, edit, list, delete

    @GetMapping("/list")
    List<CarDto> getAllCars();

    @PostMapping("/add")
    ResponseEntity addCar(@RequestBody CarDto carDto);

    @PutMapping("/edit/{id}")
    ResponseEntity editCar(@RequestBody CarDto carDto, @PathVariable Long id);

    @DeleteMapping("/delete/{id}")
    ResponseEntity deleteCar(@PathVariable Long id);

    @GetMapping("/find/{id}")
    CarDto findCar(@PathVariable Long id);

    @GetMapping("/list/available/{used}")
    CarDto getAllAvailableCar(@PathVariable String used);

}
