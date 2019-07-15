package com.leetcode;

public class Reversebits {
	public int reverseBits(int n) {
        String bstring=Integer.toBinaryString(n);    
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<32-bstring.length();i++)
        	sb.append(0);
        sb.append(bstring);
        sb=sb.reverse();
        long decimal=Long.parseLong(sb.toString(),2);
        return (int) decimal;
        
    }
	
	public static void main(String[] args) {
		Reversebits rb=new Reversebits();
		System.out.println(rb.reverseBits(2147483647));
	}
}
