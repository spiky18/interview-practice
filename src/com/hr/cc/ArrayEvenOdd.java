package com.hr.cc;

import java.util.HashMap;
import java.util.Scanner;

public class ArrayEvenOdd {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
       // HashMap<Integer,Integer> socksPair=new HashMap<Integer,Integer>();
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
           
        }
        int evenSum=c[0]*c[2];
        int oddSum=c[1]*c[3];
        for(int c_i=1; 4*(c_i-1)< n; c_i++){
            	evenSum+=c[4*c_i]+c[4*c_i+2];
            	oddSum+=c[4*c_i+1]+c[4*c_i+3];
           
        }
        evenSum%=2;
        oddSum%=2;
        if(evenSum>oddSum)
        	System.out.println("EVEN");
        else if(oddSum>evenSum)
        	System.out.println("ODD");
        else
        	System.out.println("NEUTRAL");
        //socksPair.putIfAbsent(key, value)
        /*int pairsCount=0;
        for(int i : socksPair.keySet()){
        	int p=socksPair.get(i)/2;
        	pairsCount+=p;
        }*/
        System.out.println();
    }

}
