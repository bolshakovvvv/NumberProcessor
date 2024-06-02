package org.example;

import java.io.*;
import java.util.Random;

public class NumbersGeneration {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\vladt\\IdeaProjects\\TESTING\\input_1000000_el.txt"));
        Random rand = new Random();
        for (int i = 0; i < 1000000; i++) {
            bw.write(rand.nextInt(-100, 100) + " ");
        }
        bw.close();
    }
}