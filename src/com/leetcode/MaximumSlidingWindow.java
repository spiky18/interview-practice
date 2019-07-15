package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumSlidingWindow {
	 public int[] maxSlidingWindow(int[] nums, int k) {
		 int[] result=new int[nums.length-k+1];
		 PriorityQueue<Integer> heap=new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.intValue()-o1.intValue();
			}
		});
		 int j=0;
		for(int i=0;i<nums.length;i++){
			if(heap.size()>=k){
				result[j]=heap.poll();
				j++;
				heap.add(nums[i]);
			}
			heap.add(nums[i]);
		}
		return result;
	 }
}
