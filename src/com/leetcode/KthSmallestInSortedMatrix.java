package com.leetcode;

import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {

	class temp implements Comparable<temp> {
		public int row, col, key;

		public temp(int r, int c, int k) {
			row = r;
			col = c;
			key = k;
		}

		@Override
		public int compareTo(temp o) {
			// TODO Auto-generated method stub
			return key - o.key;
		}

	}

	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<temp> minHeap=new PriorityQueue<>();
		for(int i=0;i<matrix[0].length;i++)
		{
			minHeap.add(new temp(0, i, matrix[0][i]));
		}
		int kVal=0;
		while(k>0){
			temp min=minHeap.poll();
			if(min.row+1<matrix.length)
				minHeap.add(new temp(min.row+1,min.col,matrix[min.row+1][min.col]));
			if(k==0)
				kVal=min.key;
			k--;
		}
		return kVal;
	}
}
