package com.company;

public class User {
    // id (you need to generate this id by static member variable)
    // name, surname
    // username
    // password

    private String username;
    private String name;
    private String surname;
    private int id;
    private static int id_gen = 1;
    private Password password;

    public User() {
        setId(id);
        id_gen++;
    }

    public User(String username, String name, String surname, Password password) {
        this();
        setName(name);
        setSurname(surname);
        setUsername(username);
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
