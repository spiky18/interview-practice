package com.leetcode;

public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int currZeroInd=-1;
		for(int i=0;i<nums.length;i++){
			if(nums[i]==0 && currZeroInd==-1){
				currZeroInd=i;
			}
			else if(currZeroInd>-1 && nums[i]!=0){
				nums[currZeroInd]=nums[i];
				currZeroInd++;
				nums[i]=0;
			}
			
		}
	}

}
