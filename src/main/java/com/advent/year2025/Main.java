package com.advent.year2025;

import com.advent.year2025.Day_Three.Day_Three;
import com.advent.year2025.Day_Two.Day_two;
import com.advent.year2025.day_one.Day_one;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

            //day_one();
          //  day_two();
            //day_three();
    }
    public static void day_one() throws IOException {
        Day_one.part_a(true);
        Day_one.part_b(true);
        Day_one.part_a(false);
        Day_one.part_b(false);
    }
    public static void day_two() throws IOException {
       Day_two.part_a(true);
       Day_two.part_b(true);
       Day_two.part_a(false);
       Day_two.part_b(false);

    }
    public static void day_three() throws IOException {
        System.out.println(Day_Three.part_a(true));
        System.out.println(Day_Three.part_b(true));
        System.out.println(Day_Three.part_a(false));
        System.out.println(Day_Three.part_b(false));
    }
}
