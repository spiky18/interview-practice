package com.hr.cc;

import java.util.Scanner;

public class StrangerCounter {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        long t = in.nextLong();
        double time=(double) t;
        double ceilVal= Math.ceil(time/3);
        //System.out.println(ceilVal);
        double n=Math.ceil(Math.log(ceilVal+1)/Math.log(2));
        //System.out.println(n);
        //int sizeOfBlock=(int) (3*(Math.pow(2, n-1)));
        double startCount=(3*(Math.pow(2, n-1)));
        double startTime=startCount-2;
       // int endTime=startTime+sizeOfBlock-1;
        double sum=startCount+startTime;
        startCount=sum-time;
        System.out.println((long)startCount);

	}

}
