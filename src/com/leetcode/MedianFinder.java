package com.leetcode;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class MedianFinder {
	
	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;
	TreeSet<Integer> set;
	
	public MedianFinder() {
		minHeap=new PriorityQueue<>((a,b)->Integer.compare(a, b));
		maxHeap=new PriorityQueue<>((a,b)->Integer.compare(b, a));
		
	}

	public void addNum(int num) {
		if(maxHeap.size()<minHeap.size()){
			if(num>minHeap.peek()){
				
			}
				
		}else{
			
		}
		
	}

	

	public double findMedian() {
		if(maxHeap.size()==minHeap.size()){
			return (maxHeap.peek()+minHeap.peek())/2.0;
		}
		return maxHeap.peek();
	}
}
