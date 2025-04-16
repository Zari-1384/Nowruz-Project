package org.example;

import org.example.Objects.*;
import org.example.Users.Artist;
import org.example.Users.Member;
import org.example.Users.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static Scanner input = new Scanner(System.in);
    static List<User> AllUsers = new ArrayList<>();
    static List<Object> EveryThing = new ArrayList<>();
    static List<String> matnAhang = new ArrayList<>();
    static Artist artist;
    static Member member;
    static Album album;
    static Comment comment;
    static Lyric lyric;
    static Song song;
    static Suggest suggest;
    static String username = "", password = "", name = "", email, genre;
    static String Search;
    static int index, age, answer;
    static boolean exit = false;
    static boolean founded = false;

    public static void main(String[] args)
    {
        //add an Album an Artist a Member a Song , ... to save them and use them when you want to call methods
        // add an index variable
        Seed_Data();
        while (!exit)
        {
            Enter_page();
        }
        System.out.println("Fare the well my friend!");
    }

    public static void Seed_Data()
    {
        name = "Gorbeh"; username = "Gorbeh_power"; password = "gorba_mew"; email = "Gorbeh_power@gmail.com"; age = 3;
        artist = new Artist(name, age, password, email, username);
        name = "no meow";
        artist.addAlbum(name);
        EveryThing.add(artist.getAlbums().getFirst());
        name = "you meowed me"; genre = "Pop";
        matnAhang.add("you meowed me");
        matnAhang.add("you meowed me meow");
        matnAhang.add("i'm ghahr with the meow");
        matnAhang.add("i meow you");
        matnAhang.add("num num num");
        matnAhang.add("forever meowwwwww!");
        lyric = new Lyric();
        lyric.setFull_Lyric(matnAhang);
        matnAhang.clear();
        song = new Song(name, artist.getUsername(), artist.getAlbums().getFirst().getName(), genre, new Date());
        song.setLyric(lyric);
        artist.getAlbums().getFirst().getAlbumSongs().add(song);
        EveryThing.add(song);
        AllUsers.add(artist);
        Finder.Add_Artist(artist);
        EveryThing.add(artist);

        name = "Shahram"; username = "Shahram_king"; password = "ShShSh"; email = "Shahram_king@gmail.com"; age = 67;
        artist = new Artist(name, age, password, email, username);
        name = "tireh ravan";
        artist.addAlbum(name);
        EveryThing.add(artist.getAlbums().getFirst());
        name = "maloon"; genre = "rap";
        matnAhang.add("oon mardak maloon bood");
        matnAhang.add("dokhtare kheyli tala bood");
        matnAhang.add("baraye harky ke miresid");
        matnAhang.add("naghshe hash kheyli zesht bood");
        lyric = new Lyric();
        lyric.setFull_Lyric(matnAhang);
        matnAhang.clear();
        song = new Song(name, artist.getUsername(), artist.getAlbums().getFirst().getName(), genre, new Date());
        song.setLyric(lyric);
        artist.getAlbums().getFirst().getAlbumSongs().add(song);
        EveryThing.add(song);
        AllUsers.add(artist);
        Finder.Add_Artist(artist);
        EveryThing.add(artist);

        name = "Somaye"; username = "SomiJoon"; password = "SSmi"; email = "hanjare_tala@gmail.com"; age = 32;
        artist = new Artist(name, age, password, email, username);
        name = "chokare?!";
        artist.addAlbum(name);
        EveryThing.add(artist.getAlbums().getFirst());
        name = "biro"; genre = "Pop";
        matnAhang.add("to gofti behem boro");
        matnAhang.add("man goftam to bia");
        matnAhang.add("pas ye tarkib misazam");
        matnAhang.add("esmesham hast biro");
        matnAhang.add("pas oon bro be jaye in bia");
        lyric = new Lyric();
        lyric.setFull_Lyric(matnAhang);
        matnAhang.clear();
        song = new Song(name, artist.getUsername(), artist.getAlbums().getFirst().getName(), genre, new Date());
        song.setLyric(lyric);
        artist.getAlbums().getFirst().getAlbumSongs().add(song);
        EveryThing.add(song);
        AllUsers.add(artist);
        Finder.Add_Artist(artist);
        EveryThing.add(artist);

    }

    public static void Enter_page()
    {
        System.out.println(" Welcome to the most useless app! ");
        System.out.println("""
                     What would you like to do?\s
                     1. login
                     2. Creat acount
                     3. exit\
                    """);

        int choosing = input.nextInt();
            switch (choosing) {
                case 1:
                    Login();
                    break;
                case 2:
                    Creat_Account();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println(" Please enter a valid option! ");
                    break;
            }
    }

    public static void Login()
    {
        System.out.println(" please enter your username : ");
        input.nextLine();
        username = input.nextLine();

        System.out.println(" please enter your password : ");
        password = input.nextLine();

        Check_Login();
    }

    public static void Check_Login()
    {
        for(User a : AllUsers)
        {
            if(a.getUsername().equals(username) && a.getPassword().equals(password))
            {
                System.out.println("Welcome back " + a.getName());
                founded = true;
                if(a instanceof Member)
                {
                    Enter_App_As_Member((Member) a);
                }
                if(a instanceof Artist)
                {
                    Enter_App_As_Artist((Artist) a);
                }
                break;
            }
        }
        if(!founded)
        {
            System.out.println("wrong password or username, make sure they are correct or creat a new account");
        }
    }

    public static void Creat_Account()
    {
        int choose;
        System.out.println("""
                choose your position :\s
                1. Artist.\s
                2. Member.\s
                3. go to back page""");
        input.nextLine();
        choose = input.nextInt();
        while(true)
        {
            if(choose > 3 || choose < 1)
            {
                System.out.println(" Please enter a valid option! ");
                choose = input.nextInt();
            }
            else
            {
                break;
            }
        }
        if(choose == 3)
        {
            return;
        }

        System.out.println("Enter a username : ");
        input.nextLine();
        username = input.nextLine();
        for(User a : AllUsers)
        {
            if(a.getUsername().equals(username))
            {
                System.out.println(" this username is already token, please choose another one");
                username = input.nextLine();
            }
        }

        System.out.println("Enter a password : ");
        password = input.nextLine();

        System.out.println("Enter your first name and last name : ");
        name = input.nextLine();

        System.out.println("Enter your email : ");
        email = input.nextLine();

        System.out.println("Enter your age : ");
        age = input.nextInt();

        if(choose == 1)
        {
            artist = new Artist(name, age, password, email, username);
            Finder.Add_Artist(artist);
            AllUsers.add(artist);
            System.out.println(" you successfully create an artist account! \n");
            Enter_App_As_Artist(artist);
        }
        if(choose == 2)
        {
            member = new Member(name, age, password, email, username);
            AllUsers.add(member);
            System.out.println(" you successfully create a member account! \n");
            Enter_App_As_Member(member);
        }
    }

    private static void Enter_App_As_Artist(Artist a)
    {
        System.out.println("""
                 What you want to do?\s
                 1. Show profile.\s
                 2. Search.\s
                 3. Add new Album. \
                
                 4. Show Albums list.\s
                 5. See suggest list.\s
                 6. Go to back page \
                """);

        answer = input.nextInt();
        while(true)
        {
            if(answer > 4 || answer < 1)
            {
                System.out.println(" Please enter a valid option! ");
                answer = input.nextInt();
            }
            else
            {
                break;
            }
        }

        if(answer == 1)
        {
            a.Show_profile();
        }

        if(answer == 2)
        {
            System.out.println(" What you want to search?");
            input.nextLine();
            Search = input.nextLine();
        }

    }

    public static void Enter_App_As_Member(Member a)
    {
        System.out.println("""
                 What you want to do?\s
                 1. Show profile.\s
                 2. Search.\s
                 3. See artists list.\s
                 4. Go to back page. \
                """);

        answer = input.nextInt();
        while(true)
        {
            if(answer > 4 || answer < 1)
            {
                System.out.println(" Please enter a valid option! ");
                answer = input.nextInt();
            }
            else
            {
                break;
            }
        }
        if(answer == 1)
        {
            a.Show_profile();
        }
    }

}
