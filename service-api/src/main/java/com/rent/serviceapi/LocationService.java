package com.rent.serviceapi;

import com.rent.model.dto.LocationDto;
import com.rent.model.entity.Location;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface LocationService {
    List<LocationDto> getAllLocation();
    LocationDto addLocation(@RequestBody LocationDto locationDto);
    LocationDto editLocation(@RequestBody LocationDto locationDto, @PathVariable Long id);
    LocationDto getLocation(@PathVariable Long id);
    void deleteLocationDto(@PathVariable Long id) throws RuntimeException;
}
