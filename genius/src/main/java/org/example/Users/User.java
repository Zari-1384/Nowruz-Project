package org.example.Users;

public abstract class User {
    private String name;
    private String username;
    private int age;
    private String password;
    private String email;

    public User(String name, int age, String password, String email, String username) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.email = email;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

}
