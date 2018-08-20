package com.rent.serviceapiimpl;

import com.rent.model.dto.LocationDto;
import com.rent.model.entity.Location;
import com.rent.model.repository.LocationRepository;
import com.rent.serviceapi.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<LocationDto> getAllLocation() {
        List <LocationDto> list = new ArrayList<>();
        locationRepository.findAll().forEach(location -> {
            list.add(location.toLocationDto());
        });
        return list;

    }

    @Override
    public LocationDto addLocation(LocationDto locationDto) {
        Location location = new Location();
        if (locationDto != null) {
            location.update(locationDto);
            return locationRepository.save(location).toLocationDto();
        }
        return null;

    }

    @Override
    public LocationDto editLocation(LocationDto locationDto, Long id) {
        final Optional<Location> dbLocation = locationRepository.findById(id);
        try {
            if(dbLocation.isPresent()) {
                Location location = dbLocation.get();
                location.setCountry(locationDto.getCountry());
                location.setCity(locationDto.getCity());
                location.setStreetName(locationDto.getStreetName());
                location.setNumber(locationDto.getNumber());
                return locationRepository.save(location).toLocationDto();
            }
        }catch (Exception e){
            throw new RuntimeException("Cannot edit location!" + id);
        }
        return null;
    }
    @Override
    public LocationDto getLocation(Long id) {
        if(locationRepository.findById(id).isPresent()){
            return locationRepository.findById(id).get().toLocationDto();
        }
        return null;
    }

    @Override
    public void deleteLocationDto(Long id) throws RuntimeException {
        try{
            locationRepository.deleteById(id);
        }catch (Exception e){
            throw  new RuntimeException("Cannot delete" + id);
        }
    }
}
