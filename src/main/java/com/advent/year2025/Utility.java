package com.advent.year2025;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utility {
    public static List<String> readInput(int day, boolean test) throws IOException {
        String testdir = "src/main/resources/";
        if (test) {
            testdir +=  "test_";
        } else {
            testdir +=  "input_";

        }
        testdir = testdir + "day" + day + ".txt";
        System.out.println("Reading input files from " + testdir);
        BufferedReader br = new BufferedReader(new FileReader(testdir));
        List<String> list = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);

        }
        return list;
    }
}
