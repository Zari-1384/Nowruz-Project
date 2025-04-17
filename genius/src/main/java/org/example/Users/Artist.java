package org.example.Users;

import org.example.Objects.Album;
import org.example.Objects.Suggest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Artist extends User {

    private List<Album> albums = new ArrayList<>();
    private List<Suggest> Suggests = new ArrayList<>();
    private int followers = 0;

    public Artist(String name, int age, String password, String email, String username) {
        super(name, age, password, email, username);
    }

    public void Show_profile()
    {
        System.out.println("your account name(first name and last name) : " + super.getName());
        System.out.println("your account username : " + super.getUsername());
        System.out.println("your account password : " + super.getPassword());
        System.out.println("your account email : " + super.getEmail());
        System.out.println("followers : " + followers);
    }

    public void Show_AlbumList()
    {
        int line = 1;
        System.out.println("Artist's Albums : ");
        for (Album a : albums)
        {
            System.out.println(line + " " + a.getName());
            line ++;
        }
    }

    public void Show_suggestList()
    {
        int line = 1;
        System.out.println("Member's Suggests : ");
        for (Suggest a : Suggests)
        {
            System.out.println(line);
            a.Show_suggest();
            line ++;
        }
    }

    public void deletAlbum(int index)
    {
        albums.remove(index - 1);
    }

    public void addAlbum(String albumName)
    {

        Album ArtistAlbum = new Album(albumName, new Date(), this.getUsername());
        albums.add(ArtistAlbum);
    }

    public void AddSuggest(Suggest suggest)
    {
        Suggests.add(suggest);
    }

    public void Remove_Suggest(int index)
    {
        Suggests.remove(index - 1);
    }

    public void EditAlbumInfo(int AlbumIndex, String albumName, String artistUserName) {

        albums.get(AlbumIndex - 1).setName(albumName);
        albums.get(AlbumIndex - 1).setArtistUsername(artistUserName);

    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void getSuggests(Suggest suggest) {
        Suggests.add(suggest);
    }

    public int getFollowers()
    {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public void setSuggests(List<Suggest> Suggests) {
        this.Suggests = Suggests;
    }

    public List<Suggest> getSuggest_list() {
        return Suggests;
    }

}
