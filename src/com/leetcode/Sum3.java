package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
	
	public static void main(String[] args) {
		int a[]={-1,0,1,2,-1,-4,-1};
		List<List<Integer>> list= threeSum(a);
		for(List<Integer> templist : list ){
			System.out.print("[");
			for(int i : templist){
				System.out.print(i+",");
			}
			System.out.print("]");
			System.out.println();
		}
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list= new ArrayList<>();
		for(int i=0;i<nums.length-2;i++){
			if(i>0 && nums[i-1]==nums[i])
				continue;
			int low=i+1,high=nums.length-1;
			int target=-nums[i];
			while(low<high){
				int sum=nums[low]+nums[high];
				if(low>i+1 && nums[low-1]==nums[low]){
					low++;
					continue;
					}
				if(sum==target){
					List<Integer> arrlist=new ArrayList<>();
					arrlist.add(nums[i]);
					arrlist.add(nums[low]);
					arrlist.add(nums[high]);
					list.add(arrlist);
					low++;
				}
				else if(sum>target)
					high--;
				else
					low++;
			}
		}
		return list;
	}
}
