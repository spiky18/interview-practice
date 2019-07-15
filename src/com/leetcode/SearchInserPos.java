package com.leetcode;

public class SearchInserPos {
	public int searchInsert(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
    }
    public int binarySearch(int[] nums,int l,int r,int target){
        if(l>r)
            return l;
        int mid=(l+r)/2;
        if(nums[mid]==target)
            return mid;
        if(nums[mid]>target)
            return binarySearch(nums,l,mid-1,target);
        else
            return binarySearch(nums,mid+1,r,target);
    }

}
