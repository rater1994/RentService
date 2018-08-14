package com.rent.restapiimpl;

import com.rent.model.dto.LocationDto;
import com.rent.model.entity.Location;
import com.rent.model.repository.LocationRepository;
import com.rent.restapi.Location.LocationController;
import com.rent.serviceapi.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LocationControllerImpl implements LocationController {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    LocationService locationService;

    @Override
    public List<LocationDto> getAllLocation() {
       return locationService.getAllLocation();
    }


    @Override
    public ResponseEntity addLocation(@RequestBody LocationDto locationDto) {
        final LocationDto addedLocation = locationService.addLocation(locationDto);
        return ResponseEntity.created(URI.create("/location/find/" +  addedLocation.getCity())).body(addedLocation);
    }

    @Override
    public LocationDto getLocation(@PathVariable Long id) {
        return locationService.getLocation(id);
    }

    @Override
    public ResponseEntity updateLocation(@RequestBody LocationDto locationDto,@PathVariable Long id) {
       try {
           locationService.editLocation(locationDto,id);
       }catch (RuntimeException e){
           return ResponseEntity.notFound().build();
       }
        return ResponseEntity.ok().build();
        }



    @Override
    public ResponseEntity  deleteLocation(@PathVariable Long id) {
       try {
           locationService.deleteLocationDto(id);
       }catch (RuntimeException e){
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    return ResponseEntity.ok().build();
    }
}
