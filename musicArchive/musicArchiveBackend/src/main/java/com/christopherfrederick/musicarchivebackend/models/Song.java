package com.christopherfrederick.musicarchivebackend.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data //annotation for getters and setters
public class Song {

    @Id
    private String id;

    private String fileName;

    private String title;

    private String artist;

    private boolean isFavorite;

    public Song() {
    }

    public Song(String fileName, String title, String artist, boolean isFavorite) {
        this.fileName = fileName;
        this.title = title;
        this.artist = artist;
        this.isFavorite = isFavorite;
    }
}
