package com.chrisfrederick.mvcmysqljsp.services;


import com.chrisfrederick.mvcmysqljsp.models.TvShow;
import com.chrisfrederick.mvcmysqljsp.models.User;
import com.chrisfrederick.mvcmysqljsp.repositories.TvShowRepo;
import com.chrisfrederick.mvcmysqljsp.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TvShowService {
    @Autowired
    private TvShowRepo tvShowRepo;
    @Autowired
    private UserRepo userRepo;

    public TvShowService(TvShowRepo tvShowRepo, UserRepo userRepo){
        this.tvShowRepo=tvShowRepo;
        this.userRepo=userRepo;
    }

    public List<TvShow> allShows(){
        return tvShowRepo.findAll();
    }

    public TvShow createShow(TvShow tvShow){
        return tvShowRepo.save(tvShow);
    }

    public TvShow updateShow(TvShow tvShow){
        return tvShowRepo.save(tvShow);
    }

    public List<User> allUsers(){
        return userRepo.findAll();
    }

    public TvShow findShowById(Long id){
        Optional<TvShow> optionalTvShow = tvShowRepo.findById(id);
        if(optionalTvShow.isPresent()){
            return optionalTvShow.get();
        }else{
            return null;
        }
    }


    public List<User> findAll(){
        return userRepo.findAll();
    }

    public void deleteShow(Long id){
        tvShowRepo.deleteById(id);
    }

 }
