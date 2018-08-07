package com.rent.model.repository;

import com.rent.model.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository <Car, String > {

}
