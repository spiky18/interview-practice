package com.leetcode;

public class ReshapeMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int origR=nums.length;
        int origC=nums[0].length;
        if(origR*origC != r*c)
            return nums;
        int x=0,y=0;
        int[][] reshapedMat=new int[r][c];
        for(int i=0;i<origR;i++){
        	for(int j=0;j<origC;j++){
        		reshapedMat[x][y]=nums[i][j];
        		y=y+1;
        		if(y==c)
        			{
        				x=(x+1);
        				if(x==r)
        					break;
        				y=0;
        			}
        	}
        }
        
        return nums;
    }

}
