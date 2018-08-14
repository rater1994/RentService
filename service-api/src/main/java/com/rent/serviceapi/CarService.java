package com.rent.serviceapi;
import com.rent.model.dto.CarDto;
import com.rent.model.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface CarService {

    List<CarDto> getAllCarsDTO();

    CarDto findById(@PathVariable Long id);

    CarDto addCarDTO(@RequestBody CarDto carDto);

    CarDto editCarDTO(@RequestBody CarDto carDto, @PathVariable Long id);

    void deleteCarDTO(@PathVariable Long id) throws RuntimeException;
}
