package com.microsoft.challenge;

import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		String input=in.nextLine();
		String[] arr=input.split(",");
		double total=0;
		for(String a : arr){
			total+=Integer.parseInt(a);
		}
		System.out.println((int)(Math.round(total/arr.length)));
	}
}
