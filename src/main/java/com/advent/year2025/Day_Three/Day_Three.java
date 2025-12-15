package com.advent.year2025.Day_Three;

import com.advent.year2025.Utility;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Day_Three {
    /*Goal: find largest two integers in each array and combine them into a two digit integer add that to sum for result
     */
    public static int part_a(  boolean test)throws IOException{
    // get the arrays will probably be used in part B as well so break out into own function
        // find the largest int in the array stopping at array length -1 because it has to have at least one number after it
        ArrayList<int[]> list = get_input( test);
        int sum = 0;
        for(int [] number:list){

            int largest =0;
            int secondLargest =0;
            //index to track where the largest number is
            int index = 0;
            // look from beginning of the array to the
            for(int i=0;i<number.length-1;i++){
                if(number[i]>largest){
                    largest = number[i];
                    index = i;
                }
            }
            //from where we found the last largest number to the end of the array look for the next largest number
            for(int j=index+1;j<number.length;j++){
                if(number[j]>secondLargest){
                    secondLargest = number[j];

                }
            }
            int FinalNumber = largest*10+secondLargest;
            sum+=FinalNumber;

        }
        return sum;
    }
    //Similar idea but we want to make it so we find the largest 12 numbers
    public static BigInteger part_b ( boolean test)throws IOException{
        ArrayList<int[]> numbers = get_input( test);
        // Use big int to store sum because with the second part it always ends up being huge
        BigInteger sum = BigInteger.ZERO;
        // Loop through all the integer arrays
        for (int[] num : numbers) {

            // Same as before start an idex
            int index = 0;
            // will use this to store the number because parsing to big int is easier than the multiplication shenanigans
            String number = "";
            // Start at the back of the array and loop through it until the numbers left equal 0
            for (int boundary = 11; boundary > -1; boundary--) {
                //find the largest number and the index it is at this
                List<Integer> res = Day_Three.findLargest(num, boundary, index);
                // set index to the index of the largest number so we don't look at it again
                index = res.get(0);
                //add the number to the string
                number += "" + res.get(1);
            }
            // increment sum with the total built number
            sum = sum.add(new BigInteger(number));

        }
        return sum;


    }



    public static ArrayList<int []> get_input(boolean test) throws IOException {
        //
        ArrayList<int []> list = new ArrayList<>();
        int[] tempArray;
        List<String> lines = Utility.readInput(3, test);
        for (String line : lines) {
            //Init temp holding array to size of the string
            tempArray = new int[line.length()];
            // split the string up into individual digits
            String[] numbers = line.split("");
            //put the string digit into the int array
            for(int i=0;i<numbers.length;i++){
                tempArray[i] =Integer.parseInt(numbers[i]);
            }
            //add the array to the list of arrays to work with later
            list.add(tempArray);
        }
        return  list;

    }
    public static List<Integer> findLargest( int[] numbers,int boundary, int index) {
        //temp index for "inner" loop
        int tempIndex = 0;
        // set largest to 0 for now
        int largest = 0;
        //loop through the array from the index to the end minus the boundary (the minimum number of numbers that have to follow the number)
    for(int i=index;i<numbers.length-boundary;i++){
        //if the number at the current spot is larger than the current largest
        if (numbers[i]>largest){
            // that number becomes the largest
            largest = numbers[i];
            // the temp index becomes the location of the next number
            tempIndex = i+1;
        }



    }   //return the largest and where to start the search next
        return  Arrays.asList(tempIndex,largest);
    }


}
