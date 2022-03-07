package com.christopherfrederick.musicarchivebackend.repositories;

import com.christopherfrederick.musicarchivebackend.models.Song;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongRepository extends MongoRepository<Song, String> {

    boolean existsSongByTitle(String title);

    boolean existsSongByFileNameEquals(String fileName);

    boolean existsSongByTitleEquals(String title);
}
