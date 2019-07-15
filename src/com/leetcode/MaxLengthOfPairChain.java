package com.leetcode;

import java.util.Arrays;

public class MaxLengthOfPairChain {
	public int findLongestChain(int[][] pairs) {
		int res=0;
		Pair[] arr=new Pair[pairs.length];
		int i=0;
        for(int[] p : pairs){
        	arr[i]=new Pair(p);
        	i++;
        }
        Arrays.sort(arr);
        Pair curr=arr[0];
        for(i=1;i<pairs.length;i++){
        	if(curr.pair[1]<arr[i].pair[0]){
        		res++;
        		curr=arr[i];
        	}
        }
        
        return res;
    }
	
	class Pair implements Comparable<Pair>{
		public int[] pair;
		public Pair(int[] p) {
			// TODO Auto-generated constructor stub
			pair=p;
		}
		
		@Override
		public int compareTo(Pair o) {
			
			return this.pair[1]-o.pair[1];
		}
		
	}
}
