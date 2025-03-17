package com.kari.running_songs_db;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/songs")  // This is the base URL for the songs
public class SongController {

    @Autowired
    private SongRepository songRepository; //Injects the SongRepository

    // GET /songs - Retrieves all songs from the database
    @GetMapping
    public List<Song> getAllSongs() {
        return songRepository.findAll();  // This fetches all songs from the database
    }

    // POST /songs - Adds a new song
    @PostMapping
    public ResponseEntity<List<Song>> addSongs(@RequestBody List<Song> songs) {
        List<Song> savedSongs = songRepository.saveAll(songs); // Saves all songs at once
        return ResponseEntity.ok(savedSongs);
    }
}
