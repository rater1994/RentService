package com.rent.restapiimpl;

import com.rent.model.dto.RentDto;
import com.rent.restapi.Rent.RentController;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RentControllerImpl implements RentController {
    @Override
    public List<RentDto> getAllRents() {
        return null;
    }
}
