package com.rent.serviceapi;

import com.rent.model.dto.RentDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface RentService {
    List<RentDto> getAllRentDto();
    RentDto addRent(@RequestBody RentDto rentDto);
    RentDto findRent(@PathVariable Long id);
    RentDto editRent(@RequestBody RentDto rentDto, @PathVariable Long id);
    void deleteRent(@PathVariable Long id) throws RuntimeException;


}
