package com.rent.model.repository;
import com.rent.model.entity.Rent;
import org.springframework.data.repository.CrudRepository;

public interface RentRepository extends CrudRepository<Rent, Long> {

}
