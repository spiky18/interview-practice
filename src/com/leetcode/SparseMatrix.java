package com.leetcode;

public class SparseMatrix {

	public int[][] multiplySparse(int[][] A, int[][] B) {
		int p = A.length, q = B.length, r = B[0].length;
		int[][] C = new int[p][r];
		for (int i = 0; i < p; i++) {
			for (int k = 0; k < q; k++) {
				if (A[i][k] != 0) {
					for (int j = 0; j < r; j++) {
						C[i][j] += A[i][k] * B[k][j];
					}
				}

			}

		}
		return C;
	}

	public int[][] multiply(int[][] A, int[][] B) {
		int p = A.length, q = B.length, r = B[0].length;
		int[][] C = new int[p][r];
		for (int i = 0; i < p; i++) {
			for (int j = 0; j < r; j++) {
				for (int k = 0; k < q; k++) {
					C[i][j] += A[i][k] * B[k][j];
				}

			}

		}
		return C;
	}

}
