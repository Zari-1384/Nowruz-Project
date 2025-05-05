package org.example.Users;

import org.example.Objects.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Member extends User {

    public Member(String name, int age, String password, String email, String username) {
        super(name, age, password, email, username);
    }

    Scanner input = new Scanner(System.in);
    private List<String> FollowingArtists = new ArrayList<>();
    private Suggest Suggest;

    public void addFollowing(String ArtistUsername)
    {
        FollowingArtists.add(ArtistUsername);
        Artist a = Finder.FindArtist(ArtistUsername);
        a.setFollowers(a.getFollowers() + 1);
    }

    public void Unfollow(String ArtistUsername)
    {
        FollowingArtists.remove(ArtistUsername);
        Artist a = Finder.FindArtist(ArtistUsername);
        a.setFollowers(a.getFollowers() - 1);
    }

    public void ShowFollowings(){
        int line = 1;
        for (String FollowingArtist : FollowingArtists) {
            System.out.println(line + FollowingArtist);
            line++;
        }
        System.out.println("\n");
    }

    public void AddComment(Song song)
    {

        System.out.print("Enter comment (if you want to end writing, press 0 after enter) : ");
        List<String> Comments = new ArrayList<>();
        while (input.hasNext())
        {
            if(input.next().equals("0"))
            {
                break;
            }
            Comments.add(input.nextLine());
        }

        Comment comment = new Comment(super.getUsername(), Comments, new Date());
        song.Add_Comment(comment);
    }

    public void AddReply(Comment comment, Song song)
    {
        System.out.println("Enter reply (if you want to end writing, press 0 after enter) : ");
        List<String> reply = new ArrayList<>();
        while (input.hasNext())
        {
            if(input.next().equals("0"))
            {
                break;
            }
            reply.add(input.nextLine());
        }

        Comment Reply = new Comment(super.getUsername(), reply, new Date());

        comment.addReply(Reply);
    }

    public void setSuggestion()
    {

        System.out.println("What is the artist username?");
        boolean Artist_foundt = false;
        String ArtistUsername = input.nextLine();
        Artist founded_Artist = Finder.FindArtist(ArtistUsername);
        while(!Artist_foundt)
        {
            if(founded_Artist != null)
            {
                Artist_foundt = true;
            }
            else
            {
                ArtistUsername = input.nextLine();
                founded_Artist = Finder.FindArtist(ArtistUsername);
            }
        }

        System.out.println("What is the album name?");
        String AlbumName = input.nextLine();
        boolean album_found = false;
        Album founded_album = Finder.Album_finder(founded_Artist, AlbumName);
        while(!album_found)
        {
            if(founded_album != null)
            {
                album_found = true;
            }
            else
            {
                AlbumName = input.nextLine();
                founded_album = Finder.Album_finder(founded_Artist, AlbumName);
            }
        }

        System.out.println("What is the Song's name?");
        String SongName = input.nextLine();
        boolean Song_found = false;
        Song founded_song = Finder.Song_finder(founded_album, SongName);
        while(!Song_found)
        {
            if(founded_song != null)
            {
                Song_found = true;
            }
            else
            {
                SongName = input.nextLine();
                founded_song = Finder.Song_finder(founded_album, SongName);
            }
        }



        System.out.println("Which line you want to suggest about?");
        int Editing_Line = input.nextInt();
        boolean currect_line = false;
        while(!currect_line)
        {
            if(Editing_Line > founded_song.getLyric().LyricLine_Counter(founded_song.getLyric().getFull_Lyric()))
            {
                System.out.println("the entred chosen line is more than song's lyric's line, please enter the line number again!");
                Editing_Line = input.nextInt();
            }
            else
            {
                currect_line = true;
            }
        }

        System.out.println("What is your suggestion?");
        String Suggested_lyric = input.nextLine();

        Suggest = new Suggest(ArtistUsername, AlbumName ,SongName, super.getUsername(), new Date(), Editing_Line, Suggested_lyric);

        founded_Artist.AddSuggest(Suggest);

    }

    public List<String> getFollowing() {
        return FollowingArtists;
    }

    public void Show_profile()
    {
        System.out.println("your account name(first name and last name) : " + super.getName());
        System.out.println("your account username : " + super.getUsername());
        System.out.println("your account password : " + super.getPassword());
        System.out.println("your account email : " + super.getEmail());
        System.out.println("the atrists you follow : ");
        if(FollowingArtists.isEmpty())
        {
            System.out.println("you are not following any artist" + "\n");
        }
        else
        {
            ShowFollowings();
        }
    }
}
