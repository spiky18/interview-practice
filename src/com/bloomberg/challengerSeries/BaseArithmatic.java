package com.bloomberg.challengerSeries;

import java.util.Scanner;

public class BaseArithmatic {

	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		String num1String=in.nextLine();
		String num2String=in.nextLine();
		BaseArithmatic obj=new BaseArithmatic();
		long num1=obj.convertToBase10(num1String, obj.getBase(num1String));
		long num2=obj.convertToBase10(num2String, obj.getBase(num2String));
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num1+num2);
	}
	
	public long convertToBase10(String numString,long base){
		long res=0,multiplier=1;
		long[] hexCodes={10,11,12,13,14,15};
		for(int i=numString.length()-1;i>=0;i--){
			long temp=0;
			if(Character.isAlphabetic(numString.charAt(i))){
				temp=hexCodes[numString.charAt(i)-'A'];
			}
			else
				temp=numString.charAt(i)-'0';
			res+=multiplier*temp;
			multiplier*=base;
		}
		
		return res;
	}

	public long getBase(String numString){
		long[] hexCodes={10,11,12,13,14,15};
		long base=0;
		for(int i=0;i<numString.length();i++){
			long temp=0;
			if(Character.isAlphabetic(numString.charAt(i))){
				temp=hexCodes[numString.charAt(i)-'A'];
			}
			else
				temp=numString.charAt(i)-'0';
			base=Math.max(base, temp);
		}
		return base+1;
	}
}
