package com.rent.restapi.Car;


import com.rent.model.dto.CarDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public interface CarController {

  /*  @PostMapping("/add")
    ResponseEntity addCar(@RequestBody CarDto car);
*/
    @GetMapping("/list")
    List<CarDto> getAllCars();


}
