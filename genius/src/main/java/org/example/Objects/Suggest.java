package org.example.Objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Suggest {

    private boolean accepted = false;
    private String artistUsername;
    private String AlbumName;
    private String SongName;
    private String MemberUsername;
    private Date date;
    private int Editing_Line;
    private String Suggested_Lyric;

    public Suggest(String artistUsername, String AlbumName, String SongName, String MemberUsername, Date date, int editing_Line, String Suggested_Lyric) {
        this.artistUsername = artistUsername;
        this.AlbumName = AlbumName;
        this.SongName = SongName;
        this.MemberUsername = MemberUsername;
        this.date = date;
        Editing_Line = editing_Line;
        this.Suggested_Lyric = Suggested_Lyric;
    }

    public void Show_suggest()
    {
        System.out.println("   Send by : " + MemberUsername + " in " + date + " for the song " + SongName + ". the artist : " + artistUsername
        + ". suggesting to edit line " + Editing_Line + " with " + Suggested_Lyric + "\n");
    }

    public boolean isAccepted() {
        return accepted;
    }

    public String getArtistUsername() {
        return artistUsername;
    }

    public String getAlbumName() {
        return AlbumName;
    }

    public String getSongName() {
        return SongName;
    }

    public int getEditing_Line() {
        return Editing_Line;
    }

    public String getMemberUsername() {
        return MemberUsername;
    }

    public Date getDate() {
        return date;
    }

    public String getSuggested_lyric() {
        return Suggested_Lyric;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public void setAlbumName(String AlbumName) {
        this.AlbumName = AlbumName;
    }

    public void setSuggested_Lyric(String Suggested_Lyric) {
        this.Suggested_Lyric = Suggested_Lyric;
    }

    public void setEditing_Line(int editing_Line) {
        Editing_Line = editing_Line;
    }
}