package com.codingdojo.dojosandninjas.services;


import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.repositories.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    @Autowired
    NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository){
        this.ninjaRepository = ninjaRepository;
    }

    public List<Ninja> getAllNinjas(){
        return (List<Ninja>)ninjaRepository.findAll();
    }

    public Ninja createNinja(Ninja ninja){
        return ninjaRepository.save(ninja);
    }

    public Ninja findNinjaById(Long id){
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if(optionalNinja.isPresent()){
            return optionalNinja.get();
        } else {
            return null;
        }
    }

    public Ninja updateNinja(Ninja ninja){
        return ninjaRepository.save(ninja);
    }

    public void destroyNinja(Long id){
        ninjaRepository.deleteById(id);
    }
}
