package com.leetcode;

public class FindMinRotatedArray {

	public int findMin(int[] nums) {
		if(nums.length==1)
			return nums[0];
		if(nums.length==2)
			return Math.min(nums[0], nums[1]);
		return findPivot(nums, 0, nums.length-1);
	}
	
	public int findPivot(int[] nums,int low,int high){
		if(low>high) return -1;
		if(high==low) return nums[low];
		if(high-low==1) return Math.min(nums[high],nums[low]);
		if(nums[low]<=nums[low+1] && nums[high]>=nums[low])
			return nums[low];
		int mid=low+(high-low)/2;
		if(nums[mid]<=nums[mid-1])
			return nums[mid];
		if(nums[mid+1]<=nums[mid])
			return nums[mid+1];
		if(nums[mid]>=nums[low]){
			return findPivot(nums, mid+1, high);
		}
		return findPivot(nums, low,mid-1);
	}
	
	/*public int findPivot(int[] nums,int low,int high){
		if(high<low)
			return -1;
		
		if(nums[low]<nums[low+1] && nums[high]>nums[low])
			return nums[low];
		int mid=low+(high-low)/2;
		if(nums[low]>nums[high])
		{
		
		if(nums[low]>nums[mid])
			return findPivot(nums, mid+1,high);}
		
			return findPivot(nums, low,mid);
			
		
	}*/
	
	/*public int findPivot(int[] nums,int low,int high){
		if(high<low)
			return -1;
		if(high==low)
			return low;
		int mid=low+(high-low)/2;
		if(nums[mid]>=nums[low] && nums[mid]<nums[mid-1])
			return mid;
		if(nums[mid]>nums[mid+1])
			return mid+1;
	}*/
}
