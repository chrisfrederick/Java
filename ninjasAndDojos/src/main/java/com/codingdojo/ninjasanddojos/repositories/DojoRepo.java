package com.codingdojo.ninjasanddojos.repositories;

import com.codingdojo.ninjasanddojos.models.Dojo;
import com.codingdojo.ninjasanddojos.models.Ninja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface DojoRepo extends CrudRepository<Dojo, Long> {
    List<Dojo> findAll();
    Optional<Dojo> findById(Long id);
    void deleteById(Long Id);
}
