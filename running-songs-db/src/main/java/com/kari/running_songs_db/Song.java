package com.kari.running_songs_db;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity   // This tells Spring that this is an entity class
public class Song {

    @Id// This marks the field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String artist;
    private String genre;
    private Integer bpm;

    // Constructors, getters, and setters
    public Song() {} //JPA requires a no-argument constructor

    public Song(String title, String artist, String genre, Integer bpm) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.bpm = bpm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getBpm() {
        return bpm;
    }

    public void setBpm(Integer bpm) {
        this.bpm = bpm;
    }
}
