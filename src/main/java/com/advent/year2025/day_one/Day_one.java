package com.advent.year2025.day_one;

import com.advent.year2025.Utility;

import java.io.IOException;
import java.util.List;


public class Day_one {


    public static void part_a(boolean test) throws IOException {
        List<String> lines = Utility.readInput(1, false);
        int dial = 50;
        int count = 0;
        for (String line : lines) {
            if (line.isBlank()) continue;
            String direction = line.substring(0, 1);
            int num = Integer.parseInt(line.substring(1));
            switch (direction) {
                case "L":
                    dial = (dial - num + 100) % 100;
                    break;
                case "R":
                    dial = (dial + num) % 100;
                    break;

            }
            if (dial == 0) count++;

        }
        System.out.println(count);
    }

    public static void part_b(boolean test) throws IOException {
        List<String> lines = Utility.readInput(1, true);
        int dial = 50;
        int count = 0;
        for (String line : lines) {
            if (line.isBlank()) continue;
            String direction = line.substring(0, 1);
            int num = Integer.parseInt(line.substring(1));
            for (int i = 0; i < num; i++) {
                if (direction.equals("R")) {
                    dial++;
                    if (Math.abs(dial) == 100) dial = 0;

                    if (dial == 0) {
                        count++;
                    }
                }

                if (direction.equals("L")) {

                    dial--;
                    if (dial < 0) dial = 99;

                    if (dial == 0) {
                        count++;
                    }
                }
            }
        }


        System.out.println(count);
    }
}

