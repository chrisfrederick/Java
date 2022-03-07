package com.codingdojo.manytomany.repositories;

import com.codingdojo.manytomany.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {
}
