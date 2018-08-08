package com.rent.restapi.Location;

import com.rent.model.dto.LocationDto;
import com.rent.model.entity.Location;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public interface LocationController {

    @GetMapping("/list")
    List<LocationDto> getAllLocation();

    @PostMapping("/add")
    ResponseEntity addLocation(@RequestBody LocationDto locationDto);

    @GetMapping("/find/{id}")
    LocationDto getLocation(@PathVariable Long id);

    @PutMapping("/edit/{id}")
    ResponseEntity updateLocation(@RequestBody LocationDto locationDto, @PathVariable Long id);

    @DeleteMapping("/delete/{id}")
    ResponseEntity deleteLocation(@PathVariable Long id);
}
