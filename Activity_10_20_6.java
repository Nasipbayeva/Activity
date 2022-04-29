package com.example.javafxproject;

import java.util.*;

public class Activity_10_20_6 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5000000; i++) {
            linkedList.add(i);
        }
        long start = System.currentTimeMillis();
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext())
            iterator.next();
        long end = System.currentTimeMillis();
        System.out.println("Time to traverse the list using an iterator: " + (end - start) + " millis");

        start = System.currentTimeMillis();
        for (int i = 0; i < 5000000; i++) {
            linkedList.get(i);
        }
        end = System.currentTimeMillis();
        System.out.println("Time to traverse the list using the get(index) method: " + (end - start) + " millis");
    }
}
