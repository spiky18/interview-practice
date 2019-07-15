package com.leetcode;

public class StrRev {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abcdefghi";
		//System.out.println(strrev(s));
		//ystem.out.println(strrev2(s));
		System.out.println(revCh(s));

	}
	
	public static String strrev(String s){
		char[] a=s.toCharArray();
		StringBuilder sb=new StringBuilder();
		for(int i=a.length-1;i>=0;i--)
			sb.append(s.charAt(i));
		return sb.toString();
	}
	
	public static String revCh(String s){
		if(s.length()==0)
			return s;
		return revCh(s.substring(1)+s.charAt(0));
	}
	
	public static String strrev2(String s){
		char[] a=s.toCharArray();
		for(int i=a.length-1;i>a.length/2;i--)
			{
				char ch = a[i];
				a[i]=a[a.length-1-i];
				a[a.length-1-i]=ch;
			}
		return String.valueOf(a);
	}
	
}
