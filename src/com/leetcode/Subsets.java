package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		return null;
	}

	public List<List<Integer>> subsets(int[] nums) {
		return subsetHelper(nums, 0);
	}

	public List<List<Integer>> subsetHelper(int[] nums,int i){
		List<List<Integer>> powerSet=new ArrayList<>();
		if(i==nums.length){
			List<Integer> list=new ArrayList<>();
			powerSet.add(list);
			return powerSet;
		}
		powerSet=subsetHelper(nums, i+1);
		List<List<Integer>> tempPowerSet=new ArrayList<>(powerSet); //to avoid infinite loop
		for(List<Integer> currSet : tempPowerSet){
			List<Integer> tempSet=new ArrayList<>(currSet);
			tempSet.add(nums[i]);
			powerSet.add(tempSet);
		}
		return powerSet;
	}
	
}
