package org.example.Objects;

import java.util.List;

public class Song {

    private String title;
    private String artistUsername;
    private String album;
    private String genre;
    private int date;
    private int view;
    private Lyric lyric;

    public Song(String title, String artistUsername, String album, String genre, int date) {
        this.title = title;
        this.artistUsername = artistUsername;
        this.album = album;
        this.genre = genre;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getArtistUsername() {
        return artistUsername;
    }

    public int getView() {
        return view;
    }

    public String getAlbum() {
        return album;
    }

    public String getGenre() {
        return genre;
    }

    public int getDate() {
        return date;
    }

    public Lyric getLyric() {
        return lyric;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtistUsername(String artistUsername) {
        this.artistUsername = artistUsername;
    }

    public void setView(int view) {
        this.view = view;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setLyric(Lyric lyric) {
        this.lyric = lyric;
    }

}
