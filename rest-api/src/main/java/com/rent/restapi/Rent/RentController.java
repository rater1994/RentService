package com.rent.restapi.Rent;

import com.rent.model.dto.RentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rent")
public interface RentController {

    @GetMapping("/list")
    List<RentDto> getAllRents();
}
