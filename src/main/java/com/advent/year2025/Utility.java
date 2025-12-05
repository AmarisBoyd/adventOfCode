package com.advent.year2025;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utility {
    public static List<String> readInput(boolean test,int day,boolean partb) throws IOException {
        String testdir="src/main/resources/";
        if(test){
            testdir+= (partb)? "test_b_":"test_a_";
        }
        else {
            testdir+= (partb)? "input_b_":"input_a_";

        }
        BufferedReader br=new BufferedReader( new FileReader(testdir+"day"+day+".txt"));
        List<String> list=new ArrayList<String>();
        String line;
        while((line=br.readLine())!= null){
            list.add(line);

        }
        return list;
    }
}
