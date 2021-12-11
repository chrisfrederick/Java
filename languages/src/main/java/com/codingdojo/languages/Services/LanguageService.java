package com.codingdojo.languages.Services;

import com.codingdojo.languages.Models.Language;
import com.codingdojo.languages.Repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService  {
    @Autowired
    LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository){
        this.languageRepository = languageRepository;
    }

    //Return all languages
    public List<Language> allLanguages(){
        return (List<Language>) languageRepository.findAll();
    }

    public Language findLanguage(Integer id){
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()){
            return optionalLanguage.get();
        }else{
            return null;
        }
    }

    //Create a new Language
    public Language createLanguage(Language language){
        return languageRepository.save(language);
    }

    public Language updateLanguage(Language language){
        return languageRepository.save(language);
    }

    public void delete(Integer id){
        languageRepository.deleteById(id);
    }


}
