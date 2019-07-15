package com.leetcode;

import java.util.PriorityQueue;

public class KthLargestInArray {

	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> maxHeap=new PriorityQueue<>();
		for(int i=0;i<nums.length;i++)
			maxHeap.add(nums[i]);
		int kthLarge=0;
		int i=0;
		while(i<nums.length-k)
		{
			maxHeap.poll();
			i++;
		}
        return maxHeap.poll();
    }

}
