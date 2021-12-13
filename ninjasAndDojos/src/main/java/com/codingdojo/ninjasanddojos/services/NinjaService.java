package com.codingdojo.ninjasanddojos.services;

import com.codingdojo.ninjasanddojos.models.Dojo;
import com.codingdojo.ninjasanddojos.models.Ninja;
import com.codingdojo.ninjasanddojos.repositories.DojoRepo;
import com.codingdojo.ninjasanddojos.repositories.NinjaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    @Autowired
    NinjaRepo ninjaRepo;
    @Autowired
    DojoRepo dojoRepo;

    public NinjaService(NinjaRepo ninjaRepo, DojoRepo dojoRepo){
        this.dojoRepo = dojoRepo;
        this.ninjaRepo = ninjaRepo;
    }

    public List<Ninja> allNinjas() {
        return ninjaRepo.findAll();
    }


    public Ninja saveNinja(Ninja ninja){
        return ninjaRepo.save(ninja);
    }

    public List<Dojo> allDojos(){
        return dojoRepo.findAll();
    }

    public Dojo findDojoById(Long id){
        Optional<Dojo> optionalDojo = dojoRepo.findById(id);
        if(optionalDojo.isPresent()){
            return optionalDojo.get();
        } else {
            return null;
        }
    }
}

