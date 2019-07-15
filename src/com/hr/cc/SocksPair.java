package com.hr.cc;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SocksPair {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        HashMap<Integer,Integer> socksPair=new HashMap<Integer,Integer>();
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
            if(socksPair.containsKey(c[c_i]))
            {
            	int newVal=socksPair.get(c[c_i])+1;
            	socksPair.put(c[c_i], newVal);
            }
            else
            	socksPair.put(c[c_i], 1);
        }
        //socksPair.putIfAbsent(key, value)
        int pairsCount=0;
        for(int i : socksPair.keySet()){
        	int p=socksPair.get(i)/2;
        	pairsCount+=p;
        }
        System.out.println(pairsCount);
    }
}

