package com.ufpt;

import java.util.Arrays;

public class UnionFind {
	private int[] id;

	public UnionFind(int[] nums) {
		id = new int[nums.length];
		id = Arrays.copyOf(nums, nums.length);
	}
	
	public int root(int i){
		while(i!=id[i] )
			i=id[i];
		return i;
	}
	
	public boolean isConnected(int i, int j){
		return root(i)==root(j);
	}
	
	public void union(int p,int q){
		int i=root(p);
		int j=root(q);
		id[j]=i;
	} 
}
