package org.example.Objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Song {

    private String title;
    private String artistUsername;
    private String album;
    private String genre;
    private Date date;
    private int view = 0;
    private Lyric lyric;
    private List<Comment> Comments = new ArrayList<>();

    public Song(String title, String artistUsername, String album, String genre, Date date) {
        this.title = title;
        this.artistUsername = artistUsername;
        this.album = album;
        this.genre = genre;
        this.date = date;
    }

    public void Show_song()
    {
        System.out.println("Title: " + title + "\nArtist: " + artistUsername + "\nAlbum: " + album + "\nGenre: " + genre
        + "\nDate: " + date + "\nView: " + view + "\n" );
        lyric.show_lyric();
    }

    public void Show_comments()
    {
        if(Comments.isEmpty())
        {
            System.out.println("Nothing to show");
        }
        else
        {
            int line = 1;
            System.out.println("Song's comments : \n");
            for (Comment s : Comments) {
                System.out.println((line) + " ");
                s.Show_comment();
                line++;
            }
        }
    }

    public void Add_Comment(Comment comment)
    {
        Comments.add(comment);
    }

    public void Add_View()
    {
        view++;
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

    public Date getDate() {
        return date;
    }

    public Lyric getLyric() {
        return lyric;
    }

    public List<Comment> getComments() {
        return Comments;
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

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLyric(Lyric lyric) {
        this.lyric = lyric;
    }

}
