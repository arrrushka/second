package com.company;

public class Gamer extends User {
    private String game;

    public Gamer() {

    }

    public Gamer(String name, String surname, String username, Password password) {
        super(name, surname, username, password);
        setAction(game);
    }

    public String getAction() {
        return game;
    }

    public void setAction(String game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return super.toString() + " " + game;
    }

}
