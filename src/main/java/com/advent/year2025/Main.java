package com.advent.year2025;

import com.advent.year2025.Day_Four.DayFour;
import com.advent.year2025.Day_Three.DayThree;
import com.advent.year2025.Day_Two.DayTwo;
import com.advent.year2025.Day_One.DayOne;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

            //day_one();
          //  day_two();
            //day_three();
        day_four();
    }
    public static void day_one() throws IOException {
        DayOne.part_a(true);
        DayOne.part_b(true);
        DayOne.part_a(false);
        DayOne.part_b(false);
    }
    public static void day_two() throws IOException {
       DayTwo.part_a(true);
       DayTwo.part_b(true);
       DayTwo.part_a(false);
       DayTwo.part_b(false);

    }
    public static void day_three() throws IOException {
        System.out.println(DayThree.part_a(true));
        System.out.println(DayThree.part_b(true));
        System.out.println(DayThree.part_a(false));
        System.out.println(DayThree.part_b(false));
    }
    public static void day_four() throws IOException {
        System.out.println(DayFour.part_a(true));
        System.out.println(DayFour.part_a(false));
        System.out.println(DayFour.part_b(true));
        System.out.println(DayFour.part_b(false));
    }
}
