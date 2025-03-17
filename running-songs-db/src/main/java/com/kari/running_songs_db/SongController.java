package com.kari.running_songs_db;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/songs")  // This is the base URL for the songs
public class SongController {

    private List<Song> songList = new ArrayList<>();

    // GET /songs - Retrieves all songs
    @GetMapping("/songs")
    public List<Song> getAllSongs() {
        return songList;
    }

    // POST /songs - Adds a new song
    @PostMapping("/songs")
    public ResponseEntity<List<Song>> addSongs(@RequestBody List<Song> songs) {
        List<Song> savedSongs = songRepository.saveAll(songs); // Saves all songs at once
        return ResponseEntity.ok(savedSongs);
    }
}
