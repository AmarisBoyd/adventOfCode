package com.advent.year2025.Day_Four;

import com.advent.year2025.Utility;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DayFour {

    public static int part_a(boolean test) throws IOException {
        // count of how many rolls can be moved
        int count = 0;

        // get the input

        List<String> lines = Utility.readInput(4, test);
        //make the height of the map the number of rows in lines
        int height = lines.size();

        // make the width of the map the length of the first line since the input is rectangular
        int width = lines.get(0).length();
        // create two-dimensional array to represent the map of the floor

        boolean[][] map = buildMap(test);

        for (int h = 0; h <height; h++) {
            for (int w = 0; w <width; w++) {
                if (map[h][w]) {
                    if (checkMoveable(height, width, h, w, map)) {
                        count++;

                    }
                }


            }



        }


        return count;
    }
    public static int part_b(boolean test) throws IOException {
// count of how many rolls can be moved
        int count = 0;
        int oldCount=0;

        // get the input

        List<String> lines = Utility.readInput(4, test);
        //make the height of the map the number of rows in lines
        int height = lines.size();

        // make the width of the map the length of the first line since the input is rectangular
        int width = lines.get(0).length();
        // create two-dimensional array to represent the map of the floor

        boolean[][] map = buildMap(test);
        boolean[][] removable = Arrays.copyOf(map, width);
        boolean hasMoved=false;
        do{
        for (int h = 0; h <height; h++) {
            for (int w = 0; w < width; w++) {
                if (map[h][w]) {
                    if (checkMoveable(height, width, h, w, map)) {
                        count++;
                        removable[h][w] = false;


                    }
                }


            }


        }
        if(oldCount<count){
            map=Arrays.copyOf(removable, width);
            oldCount=count;
            hasMoved=true;
        }else {
            hasMoved=false;
        }


        }while(hasMoved==true);


        return count;

    }

    public static boolean checkMoveable(int height, int width, int h, int w, boolean[][] map) {
        if (!map[h][w]){
            return false;
        }
        int count = 0;
        int maxEast =width-1;
        int maxNorth =0;
        int maxSouth = height-1;
        int maxWest = 0;
/*TODO the fact i got this working was luck go back over it when i have time to figure out the logic

 */
        //check true north
        if (h != maxNorth) {
            if (map[h - 1][w]) {
                count++;
            }
        }
        //check south
        if (h < maxSouth) {
            if (map[h + 1][w]) {
                count++;
            }}

        //check east
        if (w != maxEast) {
            //check true east
            if (map[h][w + 1]) {
                count++;
            }
            //check north-east
            if (h != maxNorth) {
                if (map[h - 1][w + 1]) {
                    count++;
                }
            }

            //check south-east
            if (h != maxSouth) {

                if (map[h +1][w + 1]) {
                    count++;
                }
            }

        }



        //check west
        if (w != maxWest) {
            // check true west
            if (map[h][w - 1]) {
                count++;
            }
                //check south-west
                if (h < maxSouth) {
                    if (map[h + 1][w - 1]) {
                        count++;
                    }
                }

                //check north-west
                if (h > maxNorth) {
                    if (map[h - 1][w - 1]) {
                        count++;
                    }
                }

            }




        return count < 4;
    }


    //builds the map for testing
    public static boolean[][] buildMap(boolean test) throws IOException {
        // get the input
        List<String> lines = Utility.readInput(4, test);
        //make the height of the map the number of rows in lines
        int height = lines.size();

        // make the width of the map the length of the first line since the input is rectangular
        int width = lines.get(0).length();
        // create two-dimensional array to represent the map of the floor
        boolean[][] map = new boolean[height][width];
        //fill the map
        for (int i = 0; i < height; i++) {
            for (int w = 0; w < width; w++) {

                if (lines.get(i).charAt(w) == '@') {
                    map[i][w] = true;

                }


            }

        }




        return map;
    }
}


