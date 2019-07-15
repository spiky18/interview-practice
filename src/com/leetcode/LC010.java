package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC010 {

	public boolean isMatch(String s, String p) {
		boolean[][] dp=new boolean[s.length()+1][p.length()+1];
		dp[0][0]=true;
		
		for (int i = 1; i < dp[0].length; i++) {
			if(p.charAt(i-1)=='*')
				dp[0][i]=dp[0][i-2];
		}
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.'){
					dp[i][j]=dp[i-1][j-1];
				}else if(p.charAt(j-1)=='*'){
					dp[i][j]=dp[i][j-2];
					
					if(p.charAt(j-2)=='.'|| p.charAt(j-2)==s.charAt(i-1))
						dp[i][j]|=dp[i-1][j];
				}
			}
		}
		
		
		
		return dp[s.length()][p.length()];
	}
	
	public boolean isMatchRecursive(String s, String p) {
		if(p.length()==0)
			return s.isEmpty();
		
		
		boolean firstMatch=!s.isEmpty() && s.charAt(0)==p.charAt(0)||p.charAt(0)=='.';
		
		
		if(p.length()>1 && p.charAt(1)=='*'){
			return isMatchRecursive(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
		}
		
		
		
		return firstMatch && isMatchRecursive(s.substring(1), p.substring(1));
		
	}
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list=new ArrayList<>();
		subsetHelper(nums, 0, list);
		
		return list;
		
    }
	
	public void subsetHelper(int[] nums,int index,List<List<Integer>> subsets){
		if(index==nums.length){
			List<Integer> emptySet=new ArrayList<Integer>();
			subsets.add(emptySet);
			return;
		}
		subsetHelper(nums, index+1, subsets);
		List<List<Integer>> tempPowerSet=new ArrayList<>(subsets);
		for(List<Integer> l: tempPowerSet){
			List<Integer> temp=new ArrayList<>(l);
			temp.add(nums[index]);
			subsets.add(temp);
			
		}
		
	}
	
	
}
