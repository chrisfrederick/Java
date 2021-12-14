package com.codingdojo.loginandregistration.services;

import com.codingdojo.loginandregistration.models.User;
import com.codingdojo.loginandregistration.models.UserLogin;
import com.codingdojo.loginandregistration.repositories.UserRepo;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;


    public User register(User newUser, BindingResult result){
        if(userRepo.findByEmail(newUser.getEmail()).isPresent()){
            result.rejectValue("email", "Unique", "This email is already in use!");
        }
        if(!newUser.getPassword().equals(newUser.getConfirm())){
            result.rejectValue("password", "Matches", "Passwords do not match!");
        }
        if(result.hasErrors()){
            return null;
        } else {
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepo.save(newUser);
        }
    }

    public User login(UserLogin newLogin, BindingResult result){
        if(result.hasErrors()){
            return null;
        }
        Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
        if(!potentialUser.isPresent()){
            result.rejectValue("email", "Unique", "Unknown email!");
        }
        User user = potentialUser.get();
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())){
            result.rejectValue("password", "Matches", "Invalid Password!");
        }
        if(result.hasErrors()){
            return null;
        } else {
            return user;
        }
    }
}
