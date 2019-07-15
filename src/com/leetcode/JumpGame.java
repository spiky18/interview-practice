package com.leetcode;

public class JumpGame {

	public boolean canJump(int[] nums) {
     boolean[] visited=new boolean[nums.length];   
     boolean[] result=new boolean[nums.length];
     result[nums.length-1]=true; 
     return isReachable(nums, 0, visited, result);
    }
	
	public boolean canJumpII(int[] nums) {
	     //boolean[] visited=new boolean[nums.length];   
	     boolean[] result=new boolean[nums.length];
	     result[nums.length-1]=true; 
	     int smallest_dist=1,i=nums.length-2;
	     while(i>=0){
	    	 if(nums[i]>=smallest_dist)
	    		 {
	    		 	result[i]=true;
	    		 	smallest_dist=1;
	    		 }
	    	 else
	    		 smallest_dist++;
	    	 i--;
	     }
	     return result[0];
	    }
	
	public boolean isReachable(int[] nums,int i,boolean[] visited,boolean[] result){
		if(visited[i])
			return result[i];
		if(i>=nums.length)
			return false;
		if(i==nums.length-1)
			return true;
		int val=i+nums[i];
		while(i<val){
			result[i]=result[i]|isReachable(nums, i+1, visited, result);
			visited[i]=true;
			i++;
		}
		return result[i];
	}
	
	public static void main(String[] args) {
		JumpGame obj=new JumpGame();
		int[] nums={1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		System.out.println(nums.length);
		System.out.println(obj.canJump(nums));
	}
}
