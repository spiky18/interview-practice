package com.leetcode;

public class LC042 {

	public int trap(int[] height) {
        int[] left=new int[height.length];
        int[] right=new int[height.length];
        left[0]=0;
        int maxLeft=height[0];
        for(int i=1;i<height.length;i++){
        	left[i]=maxLeft;
        	maxLeft=Math.max(maxLeft, height[i]);
        }
        right[height.length-1]=0;
        int maxRight=height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
        	right[i]=maxRight;
        	maxRight=Math.max(maxRight, height[i]);
        }
        int total=0;
        for(int i=0;i<height.length;i++){
        	total+=Math.max(Math.min(left[i], right[i])-height[i],0);
        }
        return total;
    }

}
