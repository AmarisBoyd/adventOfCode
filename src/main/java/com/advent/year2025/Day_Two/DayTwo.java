package com.advent.year2025.Day_Two;

import com.advent.year2025.Utility;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class DayTwo {
    public static void calc(boolean test, boolean partb) throws IOException {
        Long minimumRange;
        //int to store upper bound of the ranges
        Long maximumRange;
        // List to store ranges as string gotten from inputfile
        List<String> stringRanges = new ArrayList<>();
        // big integer just in case the result is very big
        BigInteger result = BigInteger.ZERO;
        //read in the lines
        List<String> lines = stringRanges = getRanges(test, 2, partb);
        for (String stringRange : stringRanges) {
            // split the substring again
            String[] range = stringRange.split("-");
            //store the min range
            minimumRange = Long.parseLong(range[0]);
            // store the max
            maximumRange = Long.parseLong(range[1]);
            //loop through all the numbers in the range

            for (long i = minimumRange; i < maximumRange + 1; i++) {
                if (partb) {
                    if (partBInvalidID(String.valueOf(i)))
                        result = result.add(BigInteger.valueOf(i));
                }
                //if not part b use the part A validate ?possibly a way to make this one function?
               else if (partAInvalidID(String.valueOf(i))) {
                    result = result.add(BigInteger.valueOf(i));
                }

            }
        }
        System.out.println(result);
    }

    public static List<String> getRanges(boolean test, int day, boolean partb) throws IOException {
        Long minimumRange;
        //int to store upper bound of the ranges
        Long maximumRange;
        // List to store ranges as string gotten from inputfile
        List<String> stringRanges = new ArrayList<>();
        // big integer just in case the result is very big
        BigInteger result = BigInteger.ZERO;
        //read in the lines
        List<String> lines = (Utility.readInput(day, partb));
        //in case there is more than one line read each one and add it to string ranges
        for (String line : lines) {
            stringRanges.addAll(List.of(line.split(",")));

        }
        return stringRanges;
    }

    public static boolean partAInvalidID(String idString) {

        // get the middle of the integer
        int middle = idString.length() / 2;
        // check if the front half is equal to the back half
        if (idString.substring(0, middle).equals(idString.substring(middle))) {
            // if it is return true
            return true;
        }
        //otherwise return false
        return false;
    }

    public static boolean partBInvalidID(String idString) {

        int len = idString.length();
        int middle = idString.length() / 2;
        outer:
        for (int part = 1; part < middle + 1; part++) {
            //if the string can be divided equally into chunks the size of part use part as the substing
            if (len % part == 0) {
                //create a substring chunk starting from the start of the string until part
                //ex if part is 1 then it will only be the two first letters
                String chunk = idString.substring(0,part);
                for (int i = 1; i < len / part; i++) {
                    // check if the substring in each position after "chunk" equals it
                    if (!idString.substring(part * i, part * (i + 1)).equals(chunk)) {
                        //if not go back to the outer loop
                        continue outer;
                    }
                }
                //if all the substrings equal "chunk" return true
                return true;
            }
        }
        //if no substring "chunk" can be found that meets the requirements return false
        return false;
    }



public static void part_a(boolean test) throws IOException {
    calc(test, false);
}
public static void part_b(boolean test) throws IOException {
        calc(test, true);
}

}



