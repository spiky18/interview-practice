package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4 {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> list= new ArrayList<>();
		for(int i=0;i<nums.length-3;i++){
			if(i>0 && nums[i-1]==nums[i])
				continue;
			for(int j=i+1;j<nums.length-2;j++){
				int sum=target-nums[i]-nums[j];
				int low=j+1,high=nums.length-1;
				if(low>j+1 && nums[low-1]==nums[low])
				{
					low++;
					continue;
				}
				while(low<high){
					
					if(nums[low]+nums[high]==sum){
						list.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
						low++;
					}
					else if(nums[low]+nums[high]>sum)
						high--;
					else
						low++;
				}
			}
		}
		return list;
    }
}
