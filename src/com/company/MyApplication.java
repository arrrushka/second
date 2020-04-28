package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.Scanner;

public class MyApplication {
    // users - a list of users
    private Scanner sc = new Scanner(System.in);
    private User signedUser;
    private LinkedList<User> usersList;

    private void addUser(User user) {
        usersList.add(user);
    }

    public MyApplication() {
        usersList = new LinkedList<>();
    }


    private void menu() throws FileNotFoundException {
        while (true) {
            if (signedUser == null) {
                System.out.println("You are not signed in.");
                System.out.println("1. Authentication");
                System.out.println("2. Exit");
                int choice = sc.nextInt();
                if (choice == 1) authentication();
                else break;
            } else {
                userProfile();
            }
        }
    }

    private void userProfile() throws FileNotFoundException {
        while (true) {
            System.out.println("1. Log out");
            if (sc.nextInt() == 1) logOff();
        }
    }

    private void logOff() throws FileNotFoundException {
        signedUser = null;
        start();
    }


    private void authentication() {
        while (true) {
            System.out.println("1. Sign in");
            System.out.println("2. Sign up");
            int choice = sc.nextInt();
            if (choice == 1) {
                signIn();
            } else {
                signUp();
            }
        }
    }

    private void signIn() {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();
        String password = scanner.next();
        Password p = new Password(password);

        for (User user : usersList) {
            if (username.equals(user.getUsername()) && p.equals(user.getPassword())) {
                signedUser = user;
            }
        }
    }

    private void signUp() {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.next();
        String username = scanner.next();
        String name = scanner.next();
        String surname = scanner.next();

        if (password != null && username != null && name != null && surname != null) {
            User user = new User();
            user.setName(name);
            user.setSurname(surname);
            user.setUsername(username);
            Password p = new Password(password);
            user.setPassword(p);

            if (p.check(user)) {
                addUser(user);
                authentication();
            }
        }
    }

    public void start() throws FileNotFoundException {
        File file = new File("C:\\Users\\bestd\\IdeaProjects\\second\\src\\com\\company\\db.txt");
        Scanner fileScanner = new Scanner(file);

        while (true) {
            System.out.println("Welcome to my application!");
            System.out.println("Select command:");
            System.out.println("1. Menu");
            System.out.println("2. Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                menu();
            } else {
                break;
            }
        }
    }

    private void saveUserList() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("C:\\Users\\bestd\\IdeaProjects\\second\\src\\com\\company\\db.txt");
        for (User user : usersList) {
            printWriter.println("Username: " + user.getUsername() +
                    "\n Name: " + user.getName() +
                    "\n Surname: " + user.getSurname() +
                    "\n Password: " + user.getPassword());
        }
        printWriter.close();
    }
}
