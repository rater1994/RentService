package com.rent.restapiimpl;

import com.rent.model.dto.RentDto;
import com.rent.model.entity.Rent;
import com.rent.model.repository.RentRepository;
import com.rent.restapi.Rent.RentController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RentControllerImpl implements RentController {

    @Autowired
    RentRepository rentRepository;

    @Override
    public List<RentDto> getAllRents() {

        List<RentDto> list = new ArrayList<>();
        rentRepository.findAll().forEach(rent -> {
            list.add(rent.toRentDto());
        });
        return list;
    }

    @Override
    public ResponseEntity addRent(@RequestBody RentDto rentDto) {
        Rent rent = new Rent();
        rent.update(rentDto);
        rentRepository.save(rent);
        return new ResponseEntity("Rent added", HttpStatus.OK);
    }

    @Override
    public RentDto findRent(@PathVariable Long id) {
        Rent rent = rentRepository.findById(id).get();
        return rent.toRentDto();
    }

    @Override
    public ResponseEntity editRent(@RequestBody RentDto rentDto,@PathVariable Long id) {
        Rent rent = rentRepository.findById(id).get();
        rent.setCarId(rentDto.getCarId());
        rent.setUserId(rentDto.getUserId());
        rent.setStartDate(rentDto.getStartDate());
        rent.setEndDate(rentDto.getEndDate());
        rent.setPrice(rentDto.getPrice());
        rentRepository.save(rent);
        return new ResponseEntity("Rent was edid!",HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteRent(@PathVariable Long id) {
        Rent rent = rentRepository.findById(id).get();
        rentRepository.delete(rent);
        return new ResponseEntity("Rent was deleted!",HttpStatus.OK);
    }


}
