package com.leetcode;

public class SpiralMatrix {
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int start = 1, l = 0, r = n - 1, u = 0, d = n - 1;
		while (start < n * n) {
			for (int i = l; i <= r; i++) {
				matrix[u][i] = start;
				start++;
			}
			u++;
			for (int i = u; i <= d; i++) {
				matrix[i][r] = start;
				start++;
			}
			r--;
			for (int i = r; i >= l; i--) {
				matrix[d][i] = start;
				start++;
			}
			d--;
			for (int i = d; i >= u; i--) {
				matrix[i][l] = start;
				start++;
			}
			l++;
		}
		return matrix;
	}

	public static void main(String[] args) {
		SpiralMatrix sm = new SpiralMatrix();
		int[][] matrix =sm.generateMatrix(3);
		
	}
}
