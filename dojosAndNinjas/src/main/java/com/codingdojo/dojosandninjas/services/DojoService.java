package com.codingdojo.dojosandninjas.services;


import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.repositories.DojoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DojoService {
    @Autowired
    DojoRepository dojoRepository;

    public DojoService(DojoRepository dojoRepository){
        this.dojoRepository = dojoRepository;
    }

    public List<Dojo> findAllDojos(){
        return (List<Dojo>)dojoRepository.findAll();
    }

    public Dojo createDojo(Dojo dojo){
        return dojoRepository.save(dojo);
    }

    public Dojo findDojoById(Long id){
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()){
            return optionalDojo.get();
        } else {
            return null;
        }
    }

    public Dojo updateDojo(Dojo dojo){
        return dojoRepository.save(dojo);
    }

    public void destroyDojo(Long id){
        dojoRepository.deleteById(id);
    }








}
