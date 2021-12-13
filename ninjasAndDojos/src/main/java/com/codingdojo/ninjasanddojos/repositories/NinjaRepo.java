package com.codingdojo.ninjasanddojos.repositories;

import com.codingdojo.ninjasanddojos.models.Dojo;
import com.codingdojo.ninjasanddojos.models.Ninja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NinjaRepo extends CrudRepository<Ninja, Long> {
    List<Ninja> findAll();
    Optional<Ninja> findById(Long id);
    void deleteById(Long Id);
}
