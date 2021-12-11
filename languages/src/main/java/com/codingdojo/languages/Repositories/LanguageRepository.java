package com.codingdojo.languages.Repositories;

import com.codingdojo.languages.Models.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Integer> {
}
