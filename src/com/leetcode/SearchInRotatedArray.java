package com.leetcode;

public class SearchInRotatedArray {
	public int search(int[] nums, int target) {
		return modifiedBinarySearch(nums, 0, nums.length - 1, target);
	}
	
	public int modifiedBinarySearch(int[] nums, int low, int high, int key) {
		if(low>high)return -1;
		int mid=(low+high)/2;
		if(nums[mid]==key)
			return mid;
		if(nums[low]<=nums[mid]){
			if(nums[mid]>=key && nums[low]<=key) //sorted sequence from low to mid
				return modifiedBinarySearch(nums, low, mid-1, key);
			return modifiedBinarySearch(nums, mid+1, high, key);
		}
		if(key>=nums[mid] && key<=nums[high]) //sorted sequence from mid to high
			return modifiedBinarySearch(nums, mid+1, high, key);
		return modifiedBinarySearch(nums, low, mid-1, key);
	}
	
	/*public int modifiedBinarySearch(int[] nums, int low, int high, int key) {
		if(low<=high){
			int mid = low + (high - low) / 2;
			if(nums[mid]==key)
				return mid;
			if(nums[mid]>key && key>nums[low] ) //No rotation _ordinary Binary Search
				return modifiedBinarySearch(nums, low, mid-1, key);
			if(nums[mid]<key && key<nums[high] ) //No rotation _ordinary Binary Search
				return modifiedBinarySearch(nums, mid+1, high, key);
			if(nums[mid]<key && key<nums[low] ) 
				return modifiedBinarySearch(nums, mid+1, high, key);
			if(nums[mid]>key && key>nums[high] ) 
				return modifiedBinarySearch(nums,low, mid-1, key);
			
		}
		return -1;
	}*/

	/*public int modifiedBinarySearch(int[] nums, int low, int high, int key) {
		if (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == key)
				return mid;
			if(mid-1<0 || mid+1>nums.length-1)
				return -1;
			if (nums[low] <= nums[mid]) {
				if (key >= nums[low] && key <= nums[mid - 1])
					return modifiedBinarySearch(nums, low, mid - 1, key);
				else
					return modifiedBinarySearch(nums, mid + 1, high, key);
			}
			if (key >= nums[mid] && key <= nums[high])
				return modifiedBinarySearch(nums, mid+1, high, key);
			else
				return modifiedBinarySearch(nums, low, mid - 1, key);
		}
		return -1;
	}*/
}
