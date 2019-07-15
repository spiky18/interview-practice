package com.leetcode;

public class LC274 {
	
	public int hIndex(int[] citations) {
		int size=citations.length-1;
		int[] map=new int[size+1];
		for(int i:citations){
			if(i>=size)
				map[size]++;
			else
				map[i]++;
		}
		int total=0;
		for(int i=size;i>=0;i--){
			total+=map[i];
			if(total>=i)
				return i;
		}
		return 0;
	}

}
