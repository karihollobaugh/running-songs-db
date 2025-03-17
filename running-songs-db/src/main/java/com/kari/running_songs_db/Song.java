package com.kari.running_songs_db;

public class Song {

    private String title;
    private String artist;
    private String genre;
    private int bpm;

//Constructor
public Song(String title, String artist, String genre, int bpm) {
    this.title = title;
    this.artist = artist;
    this.genre = genre;
    this.bpm = bpm;
}

//Getters and Setters
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

public int getBpm() {
    return bpm;
}

public void setBpm(int bpm) {
    this.bpm = bpm;
}
}