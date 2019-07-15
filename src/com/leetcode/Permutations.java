package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	List<List<Integer>> list;
	
	public List<List<Integer>> permute(int[] nums) {
        list=new ArrayList<>();
        permuteHelper(nums, 0, nums.length-1);
        return list;
    }
	
	public void permuteHelper(int[] nums,int l,int r){
		if(l==r){
			List<Integer> temp=new ArrayList<>();
			for(int i : nums)
				temp.add(i);
			list.add(temp);
			}
		else{
			for(int i=l;i<=r;i++){
				swap(nums,l,i);
				permuteHelper(nums, l+1, r);
				swap(nums,l,i);
			}
		}
	}

	private void swap(int[] nums, int i, int i2) {
		int temp=nums[i];
		nums[i]=nums[i2];
		nums[i2]=temp;
	}
	
}
