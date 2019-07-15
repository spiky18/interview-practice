package com.leetcode;

public class SortColors {
	public void sortColors(int[] nums) {
		int i_0=-1,i_1=-1,i_2=-1;
		for(int i=0;i<nums.length;i++){
			if(nums[i]==0)
			{
				nums[++i_2]=2;
				nums[++i_1]=1;
				nums[++i_0]=0;
				
			}
			else if(nums[i]==1){
				nums[++i_2]=2;
				nums[++i_1]=1;
			}
			else
				nums[++i_2]=2;
		}
	}
}
