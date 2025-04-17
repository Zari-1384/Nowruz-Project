package org.example.Objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Album {

    private String name;
    private Date date;
    private String artistUsername;
    private List<Song> AlbumSongs = new ArrayList<>();

    public Album(String name, Date date, String artistUsername)
    {
        this.name = name;
        this.date = date;
        this.artistUsername = artistUsername;
    }

    public void addSong(String title, String genre)
    {

        Song song = new Song(title, this.getArtistUsername(), this.name, genre, new Date());

        Lyric SongLyric = new Lyric();
        SongLyric.WriteFull_Lyric();
        song.setLyric(SongLyric);

        AlbumSongs.add(song);
    }

    public void Show_Album()
    {
        System.out.println("Name: " + name + "\nArtist: " + artistUsername + "\ndate released: " + date + "\n");
        Show_SongsList(AlbumSongs);
    }

    public void Show_SongsList(List<Song> Songs)
    {
        int line = 1;
        System.out.println("Album songs list : ");
        for (Song song : Songs)
        {
            System.out.println(line + " " + song.getTitle());
            line++;
        }
    }

    public void deletSong(int index)
    {
        AlbumSongs.remove(index - 1);
    }

    public void EditSongInfo(int SongIndex, String title, String artistUsername, String genre, String albumName) {
        String answer;
        boolean available = false;
        Scanner input = new Scanner(System.in);

        System.out.println("Song info : \nSong's name : " + AlbumSongs.get(SongIndex - 1).getTitle() + "\nSong's artist user name : "
        + AlbumSongs.get(SongIndex - 1).getArtistUsername() + "\nSong's genre : " + AlbumSongs.get(SongIndex - 1).getGenre() +
        "\nSong's Album name : " + AlbumSongs.get(SongIndex).getAlbum());
        AlbumSongs.get(SongIndex -1).setTitle(title);
        AlbumSongs.get(SongIndex - 1).setArtistUsername(artistUsername);
        AlbumSongs.get(SongIndex - 1).setGenre(genre);
        AlbumSongs.get(SongIndex -1).setAlbum(albumName);
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

        AlbumSongs.get(SongIndex -1).getLyric().show_lyric();
        System.out.println("Which line you want to edit ?");
        int line = input.nextInt();
        System.out.println("What you want to write instead?");
        String suggested = input.nextLine();
        AlbumSongs.get(SongIndex - 1).getLyric().EditLyric(line, suggested);

        System.out.println("Song's new lyric : ");
        AlbumSongs.get(SongIndex - 1).getLyric().show_lyric();

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

    public Date getDate() {
        return date;
    }

    public List<Song> getAlbumSongs()
    {
        return AlbumSongs;
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

    public void setDate(Date date) {
        this.date = date;
    }

}
