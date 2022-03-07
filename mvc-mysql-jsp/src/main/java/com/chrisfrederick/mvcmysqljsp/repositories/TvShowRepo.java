package com.chrisfrederick.mvcmysqljsp.repositories;

import com.chrisfrederick.mvcmysqljsp.models.TvShow;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TvShowRepo extends CrudRepository<TvShow, Long> {
    List<TvShow> findAll();
    Optional<TvShow> findById(Long id);
    void deleteById(Long Id);
}
