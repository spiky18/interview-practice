package com.leetcode;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
	     int[][] a=new int[m][n];
	     for(int i=m-1;i>=0;i--){
	         for(int j=n-1;j>=0;j--){
	             if(i==m-1)
	                a[i][j]=1;
	            else if(j==n-1)
	                a[i][j]=1;
	            else
	                a[i][j]=a[i+1][j]+a[i][j+1];
	         }
	     }
	        return a[0][0];
	    }
}
