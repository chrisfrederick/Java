package com.christopherfrederick.musicarchivebackend.contorllers;

import com.christopherfrederick.musicarchivebackend.models.Song;
import com.christopherfrederick.musicarchivebackend.repositories.SongRepository;
import com.christopherfrederick.musicarchivebackend.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class SongController {

    private final StorageService storageService;
    private final SongRepository songRepository;


    @Autowired
    public SongController(StorageService storageService, SongRepository songRepository) {
        this.storageService = storageService;
        this.songRepository = songRepository;
    }

    @GetMapping("/songs")
    public ResponseEntity<List> getSongs() {
        return ResponseEntity.ok(songRepository.findAll());
    }

    @GetMapping("/songs/{id}")
    public ResponseEntity<Song> getSong(@PathVariable String id) {
        Optional<Song> song = songRepository.findById(id);
        if (song.isPresent()) {
            return ResponseEntity.ok(song.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<?> createSong(@RequestPart("song")Song song, @RequestPart("file") MultipartFile file) throws IOException {
        if(songRepository.existsSongByFileNameEquals(file.getOriginalFilename()) || songRepository.existsSongByTitleEquals(song.getTitle())){
            return ResponseEntity.badRequest().body("this file is already taken");
        }else {
            System.out.println("Uploading the file...");
            storageService.uploadSong(file);

            song.setFileName(file.getOriginalFilename());
            Song insertedSong = songRepository.insert(song);

            return  new ResponseEntity<>(insertedSong, HttpStatus.CREATED);
        }
    }

    @PutMapping("/songs/{id}")
    public ResponseEntity<Song> updateSong(@PathVariable String id, @RequestBody Song songData){
        Optional<Song> songOptional = songRepository.findById(id);
        if(songOptional.isPresent()){
            Song song = songOptional.get();
            if (songData.getTitle() != null){
                song.setTitle(songData.getTitle());
            }
            if(songData.getArtist()!=null){
                song.setArtist(songData.getArtist());
            }
            song.setFavorite(songData.isFavorite());
            songRepository.save(song);
            return ResponseEntity.ok(song);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Song> deleteSong(@PathVariable String id){
        if(songRepository.existsById(id)){
            songRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
