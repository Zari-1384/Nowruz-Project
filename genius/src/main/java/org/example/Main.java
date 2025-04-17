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
    static int index, age;
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
        int choose;
        System.out.println("""
                 What you want to do?\s
                 1. Show profile.\s
                 2. Add new Album. \
                
                 3. Show Albums list.\s
                 4. See suggest list.\s
                 5. Go to back page \
                """);

        choose = input.nextInt();
        while(true)
        {
            if(choose > 5 || choose < 1)
            {
                System.out.println(" Please enter a valid option! ");
                choose = input.nextInt();
            }
            else
            {
                break;
            }
        }

        if(choose == 1)
        {
            a.Show_profile();
            Enter_App_As_Artist(a);
        }

        if(choose == 2)
        {
            Add_new_Album();
        }

        if(choose == 3 )
        {
            Show_Artist_Albums();
        }

        if(choose == 4)
        {
            Show_suggests();
        }

    }

    public static void Enter_App_As_Member(Member a)
    {
        int choose;
        System.out.println("""
                 What you want to do?\s
                 1. Show profile.\s
                 2. Search.\s
                 3. See artists list.\s
                 4. Go to back page. \
                """);

        choose = input.nextInt();
        while(true)
        {
            if(choose > 4 || choose < 1)
            {
                System.out.println(" Please enter a valid option! ");
                choose = input.nextInt();
            }
            else
            {
                break;
            }
        }

        if(choose == 1)
        {
            a.Show_profile();
            Enter_App_As_Member(a);
        }

        if(choose == 2)
        {
            System.out.println(" What you want to search?");
            input.nextLine();
            Search = input.nextLine();
            Search(Search);
        }

        if(choose == 3)
        {
            Show_Artists_List();
        }
    }

    public static void Search(String search)
    {
        int choose;
        List<Object> founded = new ArrayList<>();
        Artist founded_Artist;
        Album founded_Album;
        Song founded_Song;
        int line = 1;
        boolean SomeThing_found = false;
        System.out.println(" Founded results : ");
        for(User a : AllUsers)
        {
            if(a instanceof Artist)
            {
                if(Search.equals(a.getUsername()))
                {
                    SomeThing_found = true;
                    System.out.println(line + " Artist username : " + Search);
                    line++;
                    founded.add(a);
                }
                if(Search.equals(a.getName()))
                {
                    SomeThing_found = true;
                    System.out.println(line + ". Artist name : " + Search);
                    line++;
                    founded.add(a);
                }
            }
        }
        for(Object a : EveryThing)
        {
            if(a instanceof Album)
            {
                if(Search.equals(((Album)a).getName()))
                {
                    SomeThing_found = true;
                    System.out.println(line + ". Album name : " + Search + ". from Artist : " + ((Album)a).getArtistUsername());
                    line++;
                    founded.add(a);
                }
            }
            if(a instanceof Song)
            {
                if(Search.equals(((Song)a).getTitle()))
                {
                    SomeThing_found = true;
                    System.out.println(line + ". Song name : " + Search + ". from Artist : " + ((Song)a).getArtistUsername());
                    line++;
                    founded.add(a);
                }
            }
        }

        if(!SomeThing_found)
        {
            System.out.println("Nothing found");
            Enter_App_As_Member(member);
        }
        else
        {
            System.out.println(" Which line you want to choose(choose the index)? " + "\n if you want to go to the back page enter 0");
            choose = input.nextInt();
            while (true)
            {
                if(choose < 0 || choose > founded.size() + 1)
                {
                    System.out.println(" Please enter a valid line! ");
                }
                else
                {
                    break;
                }
            }
            if(choose == 0)
            {
                Enter_App_As_Member(member);
            }
            else
            {
                if(founded.get(choose - 1) instanceof Artist)
                {
                    founded_Artist = (Artist) founded.get(choose - 1);
                    Show_Selected_Artist(founded_Artist);
                }
                if(founded.get(choose - 1) instanceof Song)
                {
                    founded_Song = (Song) founded.get(choose - 1);
                    founded_Song.Add_View();
                    founded_Song.Show_song();
                    Enter_App_As_Member(member);
                }
                if(founded.get(choose - 1) instanceof Album)
                {
                    founded_Album = (Album) founded.get(choose - 1);
                    founded_Album.Show_Album();
                    Enter_App_As_Member(member);
                }

            }

        }
    }

    public static void Show_Selected_Artist(Artist ARtist)
    {
        int choose_action;
        int index;
        Album choosed_album;
        System.out.println(" Artist username : " + ARtist.getUsername() + ".\n Artist account name : " + ARtist.getName()
        + ".\n");
        ARtist.Show_AlbumList();
        System.out.println("""
                 What you want to do ?\s
                 1. follow artist.\s
                 2. choose an album and view it.\s
                 3. go to the back page. \
                """);
        choose_action = input.nextInt();
        while(true)
        {
            if(choose_action > 3 || choose_action < 1)
            {
                System.out.println(" Please enter a valid option! ");
                choose_action = input.nextInt();
            }
            else
            {
                break;
            }
        }
        if(choose_action == 3)
        {
            Enter_App_As_Member(member);
        }
        if(choose_action == 1)
        {
            member.addFollowing(ARtist.getUsername());
            System.out.println(" artist successfuly aded to the followings. ");
            Enter_App_As_Member(member);
        }
        if(choose_action == 2)
        {
            System.out.println(" Choose an album : ");
            index = input.nextInt();
            while(true)
            {
                if(index > ARtist.getAlbums().size() + 1 || index < 1)
                {
                    System.out.println(" Please enter a valid option! ");
                    index = input.nextInt();
                }
                else
                {
                    break;
                }
            }
            choosed_album = ARtist.getAlbums().get(index - 1);
            Show_Selected_Album(choosed_album, ARtist);
        }
    }

    public static void Show_Artists_List()
    {
        int line = 1;
        int choose;
        List<Artist> AllArtists = new ArrayList<>();
        Artist chosen_artist;
        for(User a : AllUsers)
        {
            if(a instanceof Artist)
            {
                AllArtists.add((Artist) a);
            }
        }

        for(Artist a : AllArtists)
        {
            System.out.println(" Founded results : ");
            System.out.println(line + ". Artist username : " + a.getUsername());
            line++;
        }
        System.out.println(" Which one you want to choose (if you want to go to the back page enter 0) ? ");
        choose = input.nextInt();
        while(true)
        {
            if(choose > AllArtists.size() + 1 || choose < 0)
            {
                System.out.println(" Please enter a valid option! ");
                choose = input.nextInt();
            }
            else
            {
                break;
            }
        }
        if(choose == 0)
        {
            Enter_App_As_Member(member);
        }
        else
        {
            chosen_artist =AllArtists.get(choose - 1);
            Show_Selected_Artist(chosen_artist);
        }
    }

    public static void Show_Selected_Album(Album ALBUM, Artist ARTIST)
    {
        int choose;
        int index;
        Song choosed_song;
        ALBUM.Show_Album();
        System.out.println("""
                 What you want to do ?\s
                 1. choose a song and view it.\s
                 2. go to the back page. \
                """);
        choose = input.nextInt();
        while(true)
        {
            if(choose > 2 || choose < 1)
            {
                System.out.println(" Please enter a valid option! ");
                choose = input.nextInt();
            }
            else
            {
                break;
            }
        }

        if(choose == 2)
        {
            Show_Selected_Artist(ARTIST);
        }

        if(choose == 1)
        {
            System.out.println(" Choose a song : ");
            index = input.nextInt();
            while(true)
            {
                if(index > ALBUM.getAlbumSongs().size() + 1 || index < 1)
                {
                    System.out.println(" Please enter a valid option! ");
                    index = input.nextInt();
                }
                else
                {
                    break;
                }
            }
            choosed_song = ALBUM.getAlbumSongs().get(index - 1);
            Show_Selected_Song(choosed_song, ALBUM, ARTIST);

        }
    }

    public static void Show_Selected_Song(Song SONG, Album ALBUM, Artist ARTIST)
    {
        int choose;
        List<Comment> comments;
        SONG.Add_View();
        SONG.Show_song();
        System.out.println("""
                 What you want to do ?\s
                 1. send suggestion.\s
                 2. see comments.\s
                 3. add comment.\s
                 4. go to the back page. \
                """);
        choose = input.nextInt();

        while(true)
        {
            if(choose > 4 || choose < 1)
            {
                System.out.println(" Please enter a valid option! ");
                index = input.nextInt();
            }
            else
            {
                break;
            }
        }

        if(choose == 4)
        {
            Show_Selected_Album(ALBUM, ARTIST);
        }

        if(choose == 1)
        {
            member.setSuggestion();
            Show_Selected_Song(SONG, ALBUM, ARTIST);
        }

        if(choose == 2)
        {
            int line = 1;
            comments = SONG.getComments();
            for(Comment c : comments)
            {
                List<String> matn = c.getComment();
                for(String m : matn)
                {
                    System.out.println(m);
                }
                System.out.println(" By : " + c.getUsername() + " in : " + c.getDate());
            }
            Show_Selected_Song(SONG, ALBUM, ARTIST);
        }

        if(choose == 3)
        {
            member.AddComment(SONG);
            Show_Selected_Song(SONG, ALBUM, ARTIST);
        }
    }

    public static void Add_new_Album()
    {
        String AlbumName;
        int choose;
        System.out.println(" What you want to name it ? ");
        input.nextLine();
        AlbumName = input.nextLine();
        artist.addAlbum(AlbumName);
        System.out.println("""
                 Do you want to add song to it ?\s
                 1. yes.\s
                 2. no. \
                """);
        choose = input.nextInt();
        while(true)
        {
            if(choose > 2 || choose < 1)
            {
                System.out.println(" Please enter a valid option! ");
                index = input.nextInt();
            }
            else
            {
                break;
            }
        }
        if(choose == 2)
        {
            Enter_App_As_Artist(artist);
        }
        if(choose == 1)
        {
            String songname;
            String genre;
            System.out.println(" What you want to name the song ? ");
            input.nextLine();
            songname = input.nextLine();
            System.out.println(" What genre it is ? ");
            genre = input.nextLine();

            artist.getAlbums().getLast().addSong(songname, genre);
            Enter_App_As_Artist(artist);
        }
    }

    public static void Show_Artist_Albums()
    {
        int choose;
        int index;
        artist.Show_AlbumList();
        System.out.println("""
                 What you want to do ?\s
                 1. open an album.\s
                 2. go to back page. \
                """);
        input.nextLine();
        choose = input.nextInt();

        while(true)
        {
            if(choose > 2 || choose < 1)
            {
                System.out.println(" Please enter a valid option! ");
                index = input.nextInt();
            }
            else
            {
                break;
            }
        }

        if(choose == 2)
        {
            Enter_App_As_Artist(artist);
        }

        if(choose == 1)
        {
            System.out.println(" enter chosen album index number : ");
            index = input.nextInt();
            while(true)
            {
                if(index > artist.getAlbums().size() + 1 || index < 1)
                {
                    System.out.println(" Please enter a valid option! ");
                    index = input.nextInt();
                }
                else
                {
                    break;
                }
            }
            Show_Album_toArtist(index);
        }
    }

    public static void Show_Album_toArtist(int index)
    {
        int choose;
        int line;
        Album chosen_album;
        chosen_album = artist.getAlbums().get(index - 1);
        chosen_album.Show_Album();
        System.out.println(" What you want to do ? " + "\n 1. add a new song. " + "\n 2. edit album info. " +
                "\n 3. delete song. " + "\n 4. open song. " + "\n 5. go to the back page.");

        input.nextLine();
        choose = input.nextInt();

        while(true)
        {
            if(choose > 5 || choose < 1)
            {
                System.out.println(" Please enter a valid option! ");
                index = input.nextInt();
            }
            else
            {
                break;
            }
        }

        if(choose == 1)
        {
            String songname;
            String genre;
            System.out.println(" What you want to name the song ? ");
            input.nextLine();
            songname = input.nextLine();
            System.out.println(" What genre it is ? ");
            genre = input.nextLine();

            chosen_album.addSong(songname, genre);
            Show_Artist_Albums();
        }

        if(choose == 2)
        {
            String albumname, Artistusername;
            System.out.println(" Enter album's new name : ");
            input.nextLine();
            albumname = input.nextLine();

            System.out.println(" Enter artist's new username : ");
            Artistusername = input.nextLine();

            artist.EditAlbumInfo(index, albumname, Artistusername);
            Show_Artist_Albums();
        }

        if(choose == 3)
        {
            System.out.println(" Which song you want to delete (enter the index)? ");
            line = input.nextInt();
            chosen_album.deletSong(line);
            Show_Artist_Albums();
        }

        if(choose == 4)
        {
            System.out.println(" Which song you want to open (enter the index)? ");
            line = input.nextInt();
            Show_song_toArtist(line, chosen_album);
        }

        if(choose == 5)
        {
            Show_Artist_Albums();
        }
    }

    public static void Show_song_toArtist(int index, Album chosen_album)
    {
        Song chosen_song;
        int choose;
        int line;
        chosen_song = chosen_album.getAlbumSongs().get(index - 1);
        chosen_song.Show_song();
        System.out.println(" What you want to do ? " + "\n 1. edit song. " + "\n 2. go to the back page. ");
        input.nextLine();
        choose = input.nextInt();
        while(true)
        {
            if(choose > 2 || choose < 1)
            {
                System.out.println(" Please enter a valid option! ");
                index = input.nextInt();
            }
            else
            {
                break;
            }
        }
        if(choose == 1)
        {
            String songname;
            String artistUsername, genre, albumname;
            System.out.println(" enter the new song name : ");
            input.nextLine();
            songname = input.nextLine();
            System.out.println(" enter the new artist username : ");
            artistUsername = input.nextLine();
            System.out.println(" enter the new genre : ");
            genre = input.nextLine();
            System.out.println(" enter the new albumname : ");
            albumname = input.nextLine();

            chosen_album.EditSongInfo(index, songname, artistUsername, genre, albumname);
            Show_Artist_Albums();
        }
        if(choose == 2)
        {
            Show_Artist_Albums();
        }
    }

    public static void Show_suggests()
    {
        int line;
        artist.Show_suggestList();
        System.out.println("\n" + "\n Which suggest you accept ? " + "\n if you agree with non of them enter 0 and if you want to go to the back page enter -1");
        input.nextLine();
        line = input.nextInt();
        while(true)
        {
            if(line > artist.getSuggest_list().size() + 1 || line < -1)
            {
                System.out.println(" Please enter a valid option! ");
                index = input.nextInt();
            }
            else
            {
                break;
            }
        }
        if(line == -1)
        {
            Enter_App_As_Artist(artist);
        }
        else if(line == 0)
        {
            for(int i = 1; i <= artist.getSuggest_list().size(); i++)
            {
                artist.Remove_Suggest(i);
            }
            Enter_App_As_Artist(artist);
        }
        else
        {
            Suggest chosen_suggest;
            chosen_suggest = artist.getSuggest_list().get(line - 1);
            Artist chosen_artist = Finder.FindArtist(chosen_suggest.getArtistUsername());
            Album chosen_album = Finder.Album_finder(chosen_artist, chosen_suggest.getAlbumName());
            Song chosen_song = Finder.Song_finder(chosen_album, chosen_suggest.getSongName());
            chosen_song.getLyric().EditLyric(chosen_suggest.getEditing_Line(), chosen_suggest.getSuggested_lyric());
            Enter_App_As_Artist(artist);
        }
    }

}

