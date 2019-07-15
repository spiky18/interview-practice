package com.leetcode;

public class PredictWinner {
	public boolean PredictTheWinner(int[] nums) {
		boolean[] dp=new boolean[nums.length];
		
		return dp[0]||dp[dp.length-1];
	}
	
	/*public boolean helper(int[] nums,int l,int r){
		if(l==r)
			return true;
		
	}*/
}
