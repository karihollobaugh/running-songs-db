package com.kari.running_songs_db;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

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

    // GET /songs/{id} - Retrieves a specific song by ID
    @GetMapping("/songs/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable Long id) {
        Optional<Song> song = songRepository.findById(id);
        return song.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /songs - Adds a new song
    @PostMapping
    public ResponseEntity<List<Song>> addSongs(@RequestBody List<Song> songs) {
        try {
            List<Song> savedSongs = songRepository.saveAll(songs);
            return ResponseEntity.ok(savedSongs);
        } catch (Exception e) {
            e.printStackTrace();  // Print the stack trace to console for debugging
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // DELETE /songs/{id} - Deletes a specific song by ID
    @DeleteMapping("/songs/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable Long id) {
        Optional<Song> song = songRepository.findById(id);
        if (song.isPresent()) {
            songRepository.delete(song.get());  // Deletes the song if found
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();  // If song not found
    }

    @RestController
    public class TestController {
        @GetMapping("/test")
        public String test() {
            return "App is running!";
        }
    }

}
