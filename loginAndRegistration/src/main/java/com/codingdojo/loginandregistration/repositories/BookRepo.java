package com.codingdojo.loginandregistration.repositories;

import com.codingdojo.loginandregistration.models.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepo extends CrudRepository<Book, Long> {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    void deleteById(Long Id);
}
