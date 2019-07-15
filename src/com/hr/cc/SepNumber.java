package com.hr.cc;

import java.util.Scanner;

public class SepNumber {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            // your code goes here
        }
    }
    public String incremental(String s){
        StringBuilder sb=new StringBuilder(s);
        int i=1,count=1;
        int initialNumber=Integer.parseInt(sb.substring(0, 1));
        int expectedNum=initialNumber+1;
        int actualNum=0;
        while(actualNum!=expectedNum){
        	
        }
        while(i<s.length()){
        	String n=String.valueOf(sb.substring(i, i+count));
        	sb=new StringBuilder(n);
        	actualNum=Integer.parseInt(sb.toString());
        	if(expectedNum != actualNum )
        		return "False";
        	 //initialNumber=expectedNum;
        	 expectedNum++;
        	i=count;
        	count=n.length();
        	
        	//count
        }
        return "YES";
    }
}
