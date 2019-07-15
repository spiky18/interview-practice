package com.leetcode;

public class SingleNumber {
	 public int singleNumber(int[] nums) {
		 int count=0,m=1,res=0;
		 while(count<32){
			 int sum=0;
			 for(int i=0;i<nums.length;i++){
				 int a=nums[i]&m;
				 if(a>0)
					 sum+=1;
			 }
			 if(sum%3!=0)
				 res+=m;
			 m*=2;
			 count++;
		 }
	        return res;
	    }
}
