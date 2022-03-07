package com.christopherfrederick.musicarchivebackend;

import com.christopherfrederick.musicarchivebackend.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MusicArchiveBackendApplication {


    public static void main(String[] args) {
       SpringApplication.run(MusicArchiveBackendApplication.class, args);

    }

}
