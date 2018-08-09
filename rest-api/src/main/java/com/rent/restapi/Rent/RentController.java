package com.rent.restapi.Rent;

import com.rent.model.dto.RentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rent")
public interface RentController {

    @GetMapping("/list")
    List<RentDto> getAllRents();

    @PostMapping("/add")
    ResponseEntity addRent(@RequestBody RentDto rentDto);

    @GetMapping("/find/{id}")
    RentDto findRent(@PathVariable Long id);

    @PutMapping("/edit/{id}")
    ResponseEntity editRent(@RequestBody RentDto rentDto,@PathVariable Long id);

    @DeleteMapping("/delete/{id}")
    ResponseEntity deleteRent(@PathVariable Long id);
}
