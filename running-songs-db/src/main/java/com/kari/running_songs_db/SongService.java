package com.kari.running_songs_db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kari.running_songs_db.Song;

import java.util.List;
import java.util.Optional;

@Service  // This makes it a Spring-managed service bean
public class SongService {

    @Autowired
    private SongRepository songRepository;  // Injecting the repository to interact with the database

    // Method to get all songs
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    // Method to get a song by ID
    public Optional<Song> getSongById(Long id) {
        return songRepository.findById(id);
    }

    // Method to save a new song
    public Song saveSong(Song song) {
        return songRepository.save(song);
    }

    // Method to delete a song by ID
    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }
}
