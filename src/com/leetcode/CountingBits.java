package com.leetcode;

public class CountingBits {
	public int[] countBits(int num) {
		int[] arr = new int[num + 1];
		int powOf2=1;
		for(int i=1;i<=num;i++){
			if(i%powOf2==0){
				arr[i]=1;
				powOf2*=2;
			}
			else if(i%2==0)
				arr[i]=arr[i-1];
			else
				arr[i]=1+arr[i-1];
		}
		return arr;
	}
}
