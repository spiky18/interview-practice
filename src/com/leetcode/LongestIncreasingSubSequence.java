package com.leetcode;

public class LongestIncreasingSubSequence {
public int lengthOfLIS(int[] nums) {
        int[] memo=new int[nums.length];
        memo[nums.length-1]=1;
        int max=1,maxI=nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
        	for(int j=i+1;j<maxI;j++){
        		if(nums[i]<nums[j]){
        			memo[i]=1+memo[j];
        			if(memo[i]>max)
        			{
        				max=memo[i];
        				maxI=i;
        			}
        		}
        	}
        }
        
        return max;
    }
}
