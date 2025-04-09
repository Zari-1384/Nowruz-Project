package org.example.Users;

import org.example.Objects.Suggest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Member extends User {

    public Member(String name, int age, String password, String email, String username) {
        super(name, age, password, email, username);
    }

    private List<String> FollowingArtists = new ArrayList<>();
    private Suggest Suggest;

    public void addFollowing(String ArtistUsername)
    {
        FollowingArtists.add(ArtistUsername);
    }

    public void Unfollow(String ArtistUsername)
    {
        FollowingArtists.remove(ArtistUsername);
    }

    public void ShowFollowings(List<String> FollowingArtists)
    {
        int line = 1;
        for (String FollowingArtist : FollowingArtists)
        {
            System.out.println(line + FollowingArtist);
            line++;
        }
    }

    public void GetSuggestion()
    {

        Scanner in = new Scanner(System.in);

        System.out.println("What is your username?");
        String MemberUsername = in.nextLine();
        //finder username(member)

        System.out.println("What is the Song's artist username?");
        String ArtistUsername = in.nextLine();
        //finder artist

        System.out.println("What is the Song's name?");
        String SongName = in.nextLine();
        //finder song

        System.out.println("What is todays date?");
        int Date = in.nextInt();

        System.out.println("Which line you want to suggest about?");
        int Edditing_Line = in.nextInt();

        System.out.println("What is your suggestion?");
        String Suggested_lyric = in.nextLine();

        Suggest = new Suggest(ArtistUsername, SongName, MemberUsername, Date, Edditing_Line, Suggested_lyric);
    }

    public List<String> getFollowing() {
        return FollowingArtists;
    }
}
