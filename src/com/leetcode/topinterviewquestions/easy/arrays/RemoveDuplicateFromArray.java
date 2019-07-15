package com.leetcode.topinterviewquestions.easy.arrays;

/**
 * Remove duplicate from sorted arrays
 * @author Himanshu
 *
 */
public class RemoveDuplicateFromArray {
	public int removeDuplicates(int[] nums) {
		int i=0,j=1;
		while(i<nums.length-1){
			if(nums[i]!=nums[i+1]){
				nums[j]=nums[i+1];
				j++;
				}
			i++;
			
		}
		return j;
	}
}
