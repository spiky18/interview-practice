package com.leetcode;

public class MatrixMinPathSum {
	public int minPathSum(int[][] grid) {
		int m=grid.length,n=0;
		if(m!=0)
			n=grid[0].length;
		else
			return 0;
		for(int i=m-1;i>=0;i--){
			for(int j=n-1;j>=0;j--){
				if(i==m-1 && j==n-1)
					continue;
				else if(i==m-1)
					grid[i][j]+=grid[i][j+1];
				else if(j==n-1)
					grid[i][j]+=grid[i+1][j];
				else{
					grid[i][j]+=Math.min(grid[i+1][j], grid[i][j+1]);
				}
			}
		}
		return grid[0][0];
	}
	//recursive function
	public int minPathHelper(int[][] grid,int i,int j){
		int m=grid.length,n=0;
		if(m!=0)
			n=grid[0].length;
		if((i==m-1 && j==n-2 )||(i==m-2 && j==n-1 ))
			return grid[m-1][n-1]+grid[i][j];
		else
			return grid[i][j]+Math.min(minPathHelper(grid, i+1, j),minPathHelper(grid, i, j+1));
	}
}
