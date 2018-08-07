package com.rent.restapiimpl;

import com.rent.model.dto.LocationDto;
import com.rent.restapi.Location.LocationController;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationControllerImpl implements LocationController {
    @Override
    public List<LocationDto> getAllLocation() {
        return null;
    }
}
