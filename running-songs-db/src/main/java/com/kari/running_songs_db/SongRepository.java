package com.kari.running_songs_db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
    // You can add custom queries here if needed later
}
