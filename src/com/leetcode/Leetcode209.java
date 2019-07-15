package com.leetcode;

public class Leetcode209 {
	 public int minSubArrayLen(int s, int[] nums) {
		 int start=0,end=0,len=Integer.MAX_VALUE,sum=0;
		 while(end<nums.length){
			 while(end<=nums.length-1 && sum<s){
				 sum+=nums[end];
				 end++;
			 }
			 while(start<=end && sum>=s){
				 len=Math.min(len, end-start);
				 System.out.println(len);
				 sum-=nums[start];
				 start++;
			 }
		 }
		 return len;
	 }
	 
	 public static void main(String[] args) {
		Leetcode209 obj=new Leetcode209();
		System.out.println(obj.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
	}
}
