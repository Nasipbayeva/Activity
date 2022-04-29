package com.example.javafxproject;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Activity_10_20_1 {
    public static void main(String[] args) {
        File file = new File("text.txt");
        TreeSet<String> set = new TreeSet<>();
        try {
          Scanner scan = new Scanner(file);
          String line;
            while ((line = scan.nextLine()) != null) {
                set.add(line);
            }
        }
        catch (Exception ignored) {}
        Iterator<String> iterator = set.iterator();
        System.out.println("Ascending alphabetical order: ");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
