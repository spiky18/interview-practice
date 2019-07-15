package com.leetcode;

import java.util.Stack;

public class LongestSubArray {
	
	
	public int findMaxLength(int[] nums) {
		Stack<Integer> stk0=new Stack<>();
		Stack<Integer> stk1=new Stack<>();
		int max=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]==0){
				stk0.push(i);
				if(!stk1.isEmpty()){
					stk1.pop();
					int diff=stk1.peek() -i;
					if(diff>max)
						max=diff;
				}
			}
			else
			{
				stk1.push(i);
				if(!stk0.isEmpty()){
					stk0.pop();
					int diff=stk0.peek() -i;
					if(diff>max)
						max=diff;
				}
			}
		}
		return max;
	}
	
	//Naive way
	public int findMaxLengthII(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            int cnt0=0,cnt1=0;
            for(int j=i;j<nums.length;j++){
                if(nums[j]==0)
                    cnt0++;
                else
                    cnt1++;
                if(cnt0==cnt1){
                    //int subArrlngth=cnt0+cnt1;
                    max=max>2*cnt0?max:2*cnt0;
                }
            }
        }
        return max;
    }
}
