package com.hr.cc.q2;

import java.util.Scanner;

public class question2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=4;
		double d=4.0;
		String s="HackerRank";
		Scanner scan=new Scanner(System.in);
		   /* Declare second integer, double, and String variables. */
        int i2=0;
        double d2=0;
        String s2="";
    /* Read and save an integer, double, and String to your variables.*/
        i2=scan.nextInt();
        d2=scan.nextDouble();
        scan.nextLine();
        s2=scan.nextLine();
        //System.out.println("s2 "+s2);
    /* Print the sum of both integer variables on a new line. */
        System.out.println(i+i2);
    /* Print the sum of the double variables on a new line. */
	    System.out.println(d+d2);
    /* Concatenate and print the String variables on a new line; 
    	the 's' variable above should be printed first. */
        System.out.println(s+s2);
        scan.close();
		}

}
