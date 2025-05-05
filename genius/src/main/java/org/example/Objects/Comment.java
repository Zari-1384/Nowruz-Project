package org.example.Objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comment {

    private List<Comment> Replies = new ArrayList<>();
    private String Username;
    private List<String> comment = new ArrayList<>();
    private Date date;

    public Comment(String username, List<String> comment, Date date) {
        this.Username = username;
        this.comment = comment;
        this.date = date;
    }

    public void addReply(Comment comment) {
        Replies.add(comment);
    }

    public void Show_comment()
    {
        for(String str : comment)
        {
            System.out.println(str);
        }
        System.out.println(" By : " + Username + " in : " + date);
    }

    public void Show_replies(List<Comment> replies)
    {
        int line = 1;
        for(Comment comment : replies)
        {
            System.out.println(line + ". " + comment.Username + " : " + comment.comment + " . Date : " + comment.date);
        }
    }

    public String getUsername() {
        return Username;
    }

    public List<String> getComment() {
        return comment;
    }

    public Date getDate() {
        return date;
    }

    public List<Comment> getReplies() {
        return Replies;
    }

    /*public String toString(){
        return Username +"--" + date;
    }*/
}
