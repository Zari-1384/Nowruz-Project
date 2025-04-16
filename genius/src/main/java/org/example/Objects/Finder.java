package org.example.Objects;

import org.example.Users.Artist;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Finder {

    public static List<Artist> artists = new ArrayList<>();

    public static Artist FindArtist(String ArtistUsername)
    {
        for(Artist a : artists)
        {
            if(a.getUsername().equals(ArtistUsername))
            {
                return a;
            }
        }
        System.out.println("the entered artist username does not exist, enter artist username again");
        return null;
    }

    public static Album Album_finder(Artist artist, String AlbumName)
    {
        for(Album a : artist.getAlbums())
        {
            if(a.getName().equals(AlbumName))
            {
                return a;
            }
        }
        System.out.println("the entered Album name  does not exist, enter ALbum name again");
        return null;
    }

    //todo song seta begire
    public static Song Song_finder (Album album, String SongName)
    {
        for(Song a : album.getAlbumSongs())
        {
            if(a.getTitle().equals(SongName))
            {
                return a;
            }
        }
        System.out.println("the entered Song name  does not exist, enter Song name again");
        return null;
    }

    public static void Add_Artist(Artist Artist)
    {
        artists.add(Artist);
    }

}
