package com.ufpt;

import java.util.Scanner;

public class Misspell {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int tc=in.nextInt();
		int k=1;
		Misspell obj=new Misspell();
		in.nextLine();
		for(int i=0;i<tc;i++){
			String s=in.nextLine();
			System.out.println(k+++" "+obj.removeChar(s));
			/*System.out.println(k+++" "+obj.removeChar("4 MISSPELL"));
			System.out.println(k+++" "+obj.removeChar("1 PROGRAMMING"));
			System.out.println(k+++" "+obj.removeChar("7 CONTEST"));
			System.out.println(k+++" "+obj.removeChar("3 BALLOON"));*/
			//k++;
		}
	}

	public String removeChar(String s){
		String[] sArr=s.split(" ");
		int val=Integer.parseInt(sArr[0]);
		StringBuilder sb=new StringBuilder(sArr[1]);
		sb.deleteCharAt(val-1);
		return sb.toString();
	}
}
