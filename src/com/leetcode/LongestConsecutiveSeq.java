package com.leetcode;

import java.util.HashMap;

public class LongestConsecutiveSeq {
	public int longestConsecutive(int[] nums) {
        int max=0,min=Integer.MAX_VALUE;
        HashMap<Integer,Boolean> map=new HashMap<>();
        
        for(int i : nums){
        	if(i<min)
        		min=i;
        	map.put(i, false);
        }
        for(int i : map.keySet()){
        	int len=0;
        	
        	if(len>max)
        		max=len;
        }
        return max;
    }
}
