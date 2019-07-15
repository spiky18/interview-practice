package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	 public List<List<Integer>> combinationSum3(int k, int n) {
	        List<List<Integer>> result=new ArrayList<>();
	        int[] nums={1,2,3,4,5,6,7,8,9};
	        helperIII(nums,0,k,n,result);
	        return result;
	    }
	    
	    public List<List<Integer>> helperIII(int[] nums,int i,int k,int target,List<List<Integer>> result){
	        List<List<Integer>> subset=new ArrayList<>();
	        if(i==9){
	            List<Integer> list=new ArrayList<>();
	            subset.add(list);
	            return subset;
	        }
	        subset=helperIII(nums,i+1,k,target,result);
	        List<List> tempSubset=new ArrayList<>(subset);
	        for(List<Integer> list : tempSubset){
	            if(list.size()==k)
	                continue;
	            int sum=nums[i];
	            for(int j : list){
	                sum+=j;
	            }
	            List<Integer> temp=new ArrayList<>(list);
	            temp.add(nums[i]);
	            subset.add(temp);
	            if(sum==target && temp.size()==k)
	                result.add(temp);
	        }
	        return subset;
	    }
	    
	    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	    	
	    	return null;
	    }
	    
	    public List<List<Integer>> container(List<List<Integer>> result,int i,int[] nums,int target){
	    	List<List<Integer>> subset=new ArrayList<>();
	    	if(i<=-1){
	    		List<Integer> list=new ArrayList<>();
	    		subset.add(list);
	    		return subset;
	    	}
	    	subset=container(result, i-1, nums, target);
	    	List<List<Integer>> tempList=new ArrayList<>(subset);
	    	for(List<Integer> list : tempList){
	    		int sum=0;
	    		while(sum<target){
	    			for(int k : list){
	    				sum+=k;
	    			}
	    			
	    		}
	    	}
	    	return subset;
	    }
	    
	    
	    
}
