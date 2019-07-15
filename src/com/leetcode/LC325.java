package com.leetcode;

import java.util.HashMap;
import java.util.Iterator;

public class LC325 {

	 public int maxSubArrayLen(int[] nums, int k) {
		 if(nums.length==0)
			 return 0;
	        int sum=0,max=0;
	        HashMap<Integer,Integer> map=new HashMap<>();
	        map.put(0, -1);
	        for (int i = 0; i < nums.length; i++) {
				sum+=nums[i];
				if(!map.containsKey(sum))
					map.put(sum, i);
				if(map.containsKey(sum-k)){
					max=Math.max(max, i-map.get(sum-k));
				}
			}
	        
	        return max;
	    }
}
