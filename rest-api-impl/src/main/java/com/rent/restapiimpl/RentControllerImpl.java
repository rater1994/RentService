package com.rent.restapiimpl;

import com.rent.model.dto.RentDto;
import com.rent.model.entity.Rent;
import com.rent.model.repository.RentRepository;
import com.rent.restapi.Rent.RentController;
import com.rent.serviceapi.RentService;
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
    private RentRepository rentRepository;

    @Autowired
    private RentService rentService;

    @Override
    public List<RentDto> getAllRents() {
        return rentService.getAllRentDto();
    }

    @Override
    public ResponseEntity addRent(@RequestBody RentDto rentDto) {
      rentService.addRent(rentDto);
        return ResponseEntity.ok(rentDto);
    }

    @Override
    public RentDto findRent(@PathVariable Long id) {
       return rentService.findRent(id);
    }

    @Override
    public ResponseEntity editRent(@RequestBody RentDto rentDto,@PathVariable Long id) {
      final RentDto returnRentDto = rentService.editRent(rentDto, id);
      if(returnRentDto == null){
          return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok(returnRentDto);
    }

    @Override
    public ResponseEntity deleteRent(@PathVariable Long id) {
        try{
            rentService.deleteRent(id);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }


}
