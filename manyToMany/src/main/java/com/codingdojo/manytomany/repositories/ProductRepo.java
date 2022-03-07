package com.codingdojo.manytomany.repositories;

import com.codingdojo.manytomany.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
}
