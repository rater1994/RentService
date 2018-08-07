package com.rent.restapi.Location;

import com.rent.model.dto.LocationDto;
import com.rent.model.entity.Location;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/location")
public interface LocationController {

    @GetMapping("/list")
    List<LocationDto> getAllLocation();

}
