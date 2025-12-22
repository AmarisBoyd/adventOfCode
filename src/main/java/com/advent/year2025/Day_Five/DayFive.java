package com.advent.year2025.Day_Five;

import com.advent.year2025.Utility;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DayFive {
    public static int part_a(boolean test) throws IOException {
        int numberFresh = 0;
        List<String> lines = Utility.readInput(5, test);
        ArrayList<Range> ranges = getRanges(test);

        out:
        for (String line : lines) {

            if (line.isEmpty()) {
                continue;
            }
            if (!line.contains("-")) {
                for (Range range : ranges) {
                    if (range.checkRange(Long.parseLong(line))) {
                        numberFresh++;
                        continue out;
                    }
            }
            }

        }


        return numberFresh;
    }

    public static long part_b(boolean test) throws IOException {
        long numberFresh = 0;
        ArrayList<Range> ranges = getRanges(test);

        ranges.sort(Range::compareTo);


        for (int i = 0; i <ranges.size() ; i++){
            if (i == ranges.size()) {
            }
        if(i<ranges.size()-1){
            ranges.get(i).checkMerge(ranges.get(i+1));

        }
        }

        // this is dumb idk why i couldn't get this working in the previous for loop
        for(Range range:ranges){
            numberFresh= numberFresh+range.getSize();
        }




        return numberFresh;
    }

    public static ArrayList<Range> getRanges(Boolean test) throws IOException {
        ArrayList<Range> ranges = new ArrayList<>();
        List<String> lines = Utility.readInput(5, test);

        for (String line : lines) {

            if (line.isEmpty()) {
                continue;
            }
            if (line.contains("-")) {
                ranges.add(new Range(line.split("-")[0], line.split("-")[1]));
            }
        }



        return ranges;
    }


}
