package org.example.Objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lyric {

    private List<String> Full_Lyric = new ArrayList<>();

    public List<String> getFull_Lyric() {
        return Full_Lyric;
    }
    public void setFull_Lyric(List<String> Full_Lyric) {
        this.Full_Lyric.addAll(Full_Lyric);
    }

    public void WriteFull_Lyric()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Lyric (if you want to end writing, press 0 after enter) : ");
        while (input.hasNext())
        {
            if(input.next().equals("0"))
            {
                break;
            }
            Full_Lyric.add(input.nextLine());
        }

    }

    public void show_lyric()
    {
        int line = 1;
        System.out.println("Song's lyric : \n");
        for (String s : Full_Lyric) {
            System.out.println(line + " " + s);
            line++;
        }
    }

    public void EditLyric(int line, String suggested_lyric)
    {
        Full_Lyric.remove(line - 1);
        Full_Lyric.add(line - 1, suggested_lyric);
    }

    public int LyricLine_Counter(List<String> Lyric)
    {
        int line = 1;
        for(String s : Lyric)
        {
            line++;
        }
        return line;
    }

}
