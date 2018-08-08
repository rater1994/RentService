package com.rent.restapiimpl;

import com.rent.model.dto.LocationDto;
import com.rent.model.entity.Location;
import com.rent.model.repository.LocationRepository;
import com.rent.restapi.Location.LocationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LocationControllerImpl implements LocationController {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public List<LocationDto> getAllLocation() {
        List <LocationDto> list = new ArrayList<>();

        locationRepository.findAll().forEach(location -> {
            list.add(location.toLocationDto());
        });
        return list;
    }


    @Override
    public ResponseEntity addLocation(@RequestBody LocationDto locationDto) {
        Location location = new Location();
        if (locationDto != null) {
            location.update(locationDto);
            locationRepository.save(location);
            return new ResponseEntity<String>("New location added succesfull", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Invald data input", HttpStatus.BAD_REQUEST);
    }

    @Override
    public LocationDto getLocation(@PathVariable Long id) {
        Location location = locationRepository.findById(id).get();
        return location.toLocationDto();
    }

    @Override
    public ResponseEntity updateLocation(@RequestBody LocationDto locationDto,@PathVariable Long id) {
        Location location = locationRepository.findById(id).get();
        location.setCity(locationDto.getCity());
        location.setCountry(locationDto.getCountry());
        location.setStreetName(locationDto.getStreetName());
        location.setNumber(locationDto.getNumber());
        locationRepository.save(location);
        return new ResponseEntity("The location was edit! ", HttpStatus.OK);
    }

    @Override
    public ResponseEntity  deleteLocation(@PathVariable Long id) {
        Location location = locationRepository.findById(id).get();
        locationRepository.delete(location);

        return new ResponseEntity<String>("The location with id:{id}  was deleted!", HttpStatus.OK);


    }
}
