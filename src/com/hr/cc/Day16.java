package com.hr.cc;

import java.util.Scanner;

public class Day16 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        try{
        int out=Integer.parseInt(S);
        System.out.println(out);
        }
        catch (NumberFormatException e) {
        	System.out.println("Bad String");
		}
        
    }

}
