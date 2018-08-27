package com.rent.model.repository;
import com.rent.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepository extends JpaRepository <User, Integer> {
    Optional<User> findByUsername(String username);
  //  Optional<User> findByName(String username);
}