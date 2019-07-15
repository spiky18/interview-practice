package com.leetcode;


public class DiagonalTraversalMatrix {
	public int[] findDiagonalOrder(int[][] matrix) {
		int r = matrix.length, c = matrix[0].length;
		int[] arr = new int[r * c];
		int i = 0, j = 0, k = 0;
		boolean upwards = true;
		while (k<r*c) {
			arr[k] = matrix[i][j];
			if(upwards){
				if(i==0 && j+1==c){
					upwards=false;
					i++;
					continue;
				}
				if(i==0 || j+1==c){
					upwards=false;
					if(i==0)
						j=j+1;
					else
						i=i+1;
					continue;
				}
				i--;
				j++;
			}
			else{
				if(j==0 && i+1==r){
					upwards=true;
					j++;
					continue;
				}
				if(j==0 || i+1==r){
					upwards=true;
					if(j==0)
						i++;
					else
						j++;
					continue;
				}
				i++;
				j--;
			}
			k++;
		}

		return arr;
	}

}
