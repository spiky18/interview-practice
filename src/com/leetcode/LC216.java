package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC216 {
	
	 public List<List<Integer>> combinationSum3(int k, int n) {
		 List<List<Integer>> result=new ArrayList<>();
		 
		 helper(1,k,n,new ArrayList<Integer>(),result,0 );
		 return result;
	    }

	private void helper(int i, int k, int n, List<Integer> list, List<List<Integer>> result,int sum) {
		if(list.size()>k)
			return;
		if(sum>=n){
			if(sum==n && list.size()==k)
				result.add(new ArrayList<>(list));
			return;
		}
		for (int j = i; j < 9; j++) {
			list.add(j);
			helper(j+1, k, n, list, result, sum+j);
			list.remove(list.size()-1);
		}
		
		
		
	}
	 
	 

}
