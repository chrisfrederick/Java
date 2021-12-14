package com.codingdojo.authentication.repositories;

import com.codingdojo.authentication.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
