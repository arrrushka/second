package com.company;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        MyApplication application = new MyApplication();
        System.out.println("An application is about to start..");
        application.start();

        List<User> users = new LinkedList<>();
        File file = new File("C:\\Users\\bestd\\IdeaProjects\\second\\src\\com\\company\\db.txt");
        Scanner fsc = new Scanner(file);

        while (fsc.hasNext()) {
            int id = fsc.nextInt();
            String name = fsc.next();
            String surname = fsc.next();
            String username = fsc.next();
            Password password = new Password(fsc.next());
            User user = new User(id, name, surname, password);
            users.add(user);
        }
    }
}
