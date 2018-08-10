package com.rent.serviceapi;
import com.rent.model.dto.CarDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    List<CarDto> getAllCarsDTO();

    CarDto findById(Long id);


}
