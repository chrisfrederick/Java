package com.chrisfrederick.mvcmysqljsp.repositories;

import com.chrisfrederick.mvcmysqljsp.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
    List<User> findAll();
    Optional<User> findById(Long id);
    void deleteById(Long Id);
}
