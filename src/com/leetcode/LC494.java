package com.leetcode;

import java.util.Arrays;

public class LC494 {
	int count;
	public int findTargetSumWays(int[] nums, int S) {
		count=0;
		 int[][] dp=new int[nums.length][S+2001];
		 for(int[] ar: dp){
			 Arrays.fill(ar, -1);
		 }
		helper(nums, 0, 0, S);
		
		return count;
    }
	
	void helper(int[] nums,int i,int sum,int s){
		if(i==nums.length){
			if(sum==s)
				count++;
			return;
		}
		helper(nums, i+1, sum+nums[i], s);
		helper(nums, i+1, sum-nums[i], s);
	}
	
	void helper(int[] nums,int i,int sum,int s,int[][] dp){
		if(i==nums.length){
			if(sum==s)
				count++;
			return;
		}
		helper(nums, i+1, sum+nums[i], s);
		helper(nums, i+1, sum-nums[i], s);
	}
}
