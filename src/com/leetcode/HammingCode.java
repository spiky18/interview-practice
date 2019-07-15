package com.leetcode;

public class HammingCode {
	 public int hammingWeight(int n) {
	        int count=0;
	        while(n!=0){
	            int t=n & 1;
	        	if(t==1)
	                count++;
	            n=n>>>1;
	        }
	        return count;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HammingCode h=new HammingCode(); 
		System.out.println(h.hammingWeight(-2147483648));

	}

}
