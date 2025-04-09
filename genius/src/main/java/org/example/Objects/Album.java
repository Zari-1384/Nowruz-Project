package org.example.Objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Album {

    private String name;
    private int date;
    private String artistUsername;
    private List<Song> AlbumSongs = new ArrayList<>();

    public Album(String name, int date, String artistUsername)
    {
        this.name = name;
        this.date = date;
        this.artistUsername = artistUsername;
    }

    public void addSong(String title, String genre, int date)
    {

        Song song = new Song(title, this.getArtistUsername(), this.name, genre, date);

        Lyric SongLyric = new Lyric();
        SongLyric.setFull_Lyric();
        song.setLyric(SongLyric);

        AlbumSongs.add(song);
    }

    public void deletSong(int index)
    {
        AlbumSongs.remove(index - 1);
    }

    public void EditSongInfo(int SongIndex, String title, String artistUsername, String genre, String albumName, int date) {
        String answer;
        boolean available = false;
        Scanner input = new Scanner(System.in);

        System.out.println("Song info : \nSong's name : " + AlbumSongs.get(SongIndex).getTitle() + "\nSong's artist user name : "
        + AlbumSongs.get(SongIndex).getArtistUsername() + "\nSong's genre : " + AlbumSongs.get(SongIndex).getGenre() +
        "\nSong's Album name : " + AlbumSongs.get(SongIndex).getAlbum() + "\nSong's date : " + AlbumSongs.get(SongIndex).getDate());
        AlbumSongs.get(SongIndex).setTitle(title);
        AlbumSongs.get(SongIndex).setArtistUsername(artistUsername);
        AlbumSongs.get(SongIndex).setGenre(genre);
        AlbumSongs.get(SongIndex).setAlbum(albumName);
        AlbumSongs.get(SongIndex).setDate(date);
        System.out.println("Song info edited!");

        System.out.println("Do you want to edit the song lyrics too? \n1.yes \n2.no");
        answer = input.nextLine();
        while(!available)
        {
            if (answer.equals("yes"))
            {
                EditSongLyric(SongIndex, available);
            }

            if(answer.equals("no"))
            {
                available = true;
            }

            else
            {
                System.out.println("the answer is not available, please try again");
            }
        }

    }

    public void EditSongLyric(int SongIndex, boolean available)
    {
        Scanner input = new Scanner(System.in);

        AlbumSongs.get(SongIndex).getLyric().show_lyric(AlbumSongs.get(SongIndex).getLyric().getFull_Lyric());
        System.out.println("Which line you want to edit ?");
        int line = input.nextInt();
        System.out.println("What you want to write instead?");
        String suggested = input.nextLine();
        AlbumSongs.get(SongIndex).getLyric().EditLyric(line, suggested, AlbumSongs.get(SongIndex).getLyric().getFull_Lyric());

        System.out.println("Song's new lyric : ");
        AlbumSongs.get(SongIndex).getLyric().show_lyric(AlbumSongs.get(SongIndex).getLyric().getFull_Lyric());

        System.out.println("is the song's new lyric accepted? (yes/no)");
        suggested = input.nextLine();

        if(suggested.equals("yes"))
        {
            available = true;
        }
        else
        {
            EditSongLyric(SongIndex, available);
        }
    }

    public String getName() {
        return name;
    }

    public int getDate() {
        return date;
    }

    public String getArtistUsername() {
        return artistUsername;
    }

    public void setArtistUsername(String artistUsername) {
        this.artistUsername = artistUsername;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(int date) {
        this.date = date;
    }

}
