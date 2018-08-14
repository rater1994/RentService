package com.rent.serviceapiimpl;

import com.rent.model.dto.RentDto;
import com.rent.model.entity.Rent;
import com.rent.model.repository.RentRepository;
import com.rent.serviceapi.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.image.renderable.RenderableImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentRepository rentRepository;

    @Override
    public List<RentDto> getAllRentDto() {
        List<RentDto> list = new ArrayList<>();
        rentRepository.findAll().forEach(rent -> {
            list.add(rent.toRentDto());
        });
        return list;
    }

    @Override
    public RentDto addRent(RentDto rentDto) {
        Rent rent = new Rent();
        rent.update(rentDto);
        return rentRepository.save(rent).toRentDto();
    }

    @Override
    public RentDto findRent(Long id) {
        Rent rent = rentRepository.findById(id).get();
        return rent.toRentDto();
    }

    @Override
    public RentDto editRent(RentDto rentDto, Long id) {
        final Optional<Rent> dbRent = rentRepository.findById(id);
        if (dbRent.isPresent()) {
            Rent rent = dbRent.get();
            rent.setPrice(rentDto.getPrice());
            rent.setStartDate(rentDto.getStartDate());
            rent.setEndDate(rentDto.getEndDate());
            rent.setUserId(rentDto.getUserId());
            rent.setCarId(rentDto.getCarId());
            rentRepository.save(rent).toRentDto();
        }
        return null;
    }

    @Override
    public void deleteRent(Long id) throws RuntimeException {
        try {
            rentRepository.deleteById(id);
        } catch (Exception e) {
            throw  new RuntimeException("Cannot delete this rent!" + id);
        }
    }
}
