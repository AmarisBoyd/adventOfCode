package com.advent.year2025.Day_Five;

import org.jspecify.annotations.NonNull;

public class Range implements Comparable<Range> {
    Long lower;
    Long upper;
    private final int id;
    private static int idCount = 0;
    public Range(String lower, String upper) {
        this.lower = Long.parseLong(lower);
        this.upper = Long.parseLong(upper);
        this.id = idCount++;

    }
    public boolean checkRange(long toCheck) {
        return toCheck >= lower && toCheck <= upper;
    }
    public boolean checkMerge(Range testRange) {

        if (testRange.id == this.id) return false;
        if (this.checkRange(testRange.lower)) {

            testRange.lower = this.lower;
            this.upper =0L;
            this.lower=0L;
            return true;
        }
        return false;
    }


    @Override
    public int compareTo( Range range) {
        int toReturn = 0;
        if (this.lower<=range.lower&&this.upper<=range.upper) {
            toReturn= -1;
        }
        else if (this.lower>range.lower){
            toReturn= 1;
        }

        return toReturn;
    }
    public long getSize() {

        if (this.upper==0&&this.lower ==0)
                return 0;
        else return this.upper-this.lower+1;
    }

    @Override
    public String toString() {
        return "Range{" +
                "lower=" + lower +
                ", upper=" + upper +
                '}';
    }
}
