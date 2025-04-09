package org.example.Objects;

import java.util.ArrayList;
import java.util.List;

public class Suggest {

    private boolean accepted = false;
    private String artistUsername;
    private String SongName;
    private String MemberUsername;
    private int date;
    private int Edditing_Line;
    private String Suggested_Lyric;

    public Suggest(String artistUsername, String SongName, String MemberUsername, int date, int edditing_Line, String Suggested_Lyric) {
        this.artistUsername = artistUsername;
        this.SongName = SongName;
        this.MemberUsername = MemberUsername;
        this.date = date;
        Edditing_Line = edditing_Line;
        this.Suggested_Lyric = Suggested_Lyric;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public String getArtistUsername() {
        return artistUsername;
    }

    public String getSongName() {
        return SongName;
    }

    public int getEdditing_Line() {
        return Edditing_Line;
    }

    public String getMemberUsername() {
        return MemberUsername;
    }

    public int getDate() {
        return date;
    }

    public String getSuggested_lyric() {
        return Suggested_Lyric;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public void setSuggested_Lyric(String Suggested_Lyric) {
        this.Suggested_Lyric = Suggested_Lyric;
    }

    public void setEdditing_Line(int edditing_Line) {
        Edditing_Line = edditing_Line;
    }
}
