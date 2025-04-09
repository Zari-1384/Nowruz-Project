package org.example.Users;

import org.example.Objects.Album;

import java.util.ArrayList;
import java.util.List;

public class Artist extends User {

    private List<Album> albums = new ArrayList<>();

    public Artist(String name, int age, String password, String email, String username) {
        super(name, age, password, email, username);
    }

    public void deletAlbum(int index)
    {
        albums.remove(index - 1);
    }

    public void addAlbum(String albumName, int date) {

        Album ArtistAlbum = new Album(albumName, date, this.getUsername());
        albums.add(ArtistAlbum);
    }

    public List<Album> getAlbums() {
        return albums;
    }

    /* Album getLastAlbum()
    {
        return albums.getLast();
    }*/

    public void EditAlbumInfo(int AlbumIndex, String albumName, int date, String artistUserName) {

        albums.get(AlbumIndex).setName(albumName);
        albums.get(AlbumIndex).setDate(date);
        albums.get(AlbumIndex).setArtistUsername(artistUserName);

    }

}
