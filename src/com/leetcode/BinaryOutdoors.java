package com.leetcode;

//Problem        : Binary Ouroboros
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_75
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.Scanner;
//Your submission should *ONLY* use the following class name
public class BinaryOutdoors
{
  public static void main(String[] args)
  {

     Scanner stdin = new Scanner(System.in);
     int n =stdin.nextInt();
     int k =stdin.nextInt();
     int kcheck=(int) Math.pow(2, n);
    
     int start=0;
     int rancount=2;
     if(k>kcheck)
    	 System.out.println(-1);
     else{
     for(int i=0;i<n;i++){
    	 int pow=(int) Math.pow(2, i);
    	 
    	 int xornum= rancount-1;
    	 rancount=rancount*rancount;
    	 int temp=start^xornum;
    	 start=(start<<pow);
    	 start+=temp;
    	 //System.out.println("0"+Integer.toBinaryString(start) + "  "+temp);
    	 
     }
     String s= Integer.toBinaryString(start);
     s="0"+s;
     System.out.println(s);
     System.out.println(s.charAt(k-1));
     
     }
     stdin.close();
  }

}
