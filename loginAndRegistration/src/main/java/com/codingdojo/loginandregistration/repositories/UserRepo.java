package com.codingdojo.loginandregistration.repositories;

import com.codingdojo.loginandregistration.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
    List<User> findAll();
    Optional<User> findById(Long id);
    void deleteById(Long Id);
}
