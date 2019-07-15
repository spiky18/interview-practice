package com.ufpt;

public class SetMatrixZeros {
	public void setZeroes(int[][] m) {
		int r = m.length, c = 0;
		if (r != 0)
			c = m[0].length;
		int col0 = 1;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (m[i][0] == 0)
					col0 = 0;
				if (m[i][j] == 0) {
					m[i][0] = 0;
					m[0][j] = 0;
				}
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (m[i][0] == 0 || m[0][j] == 0) {
					m[i][j] = 0;
				}
			}
			if (col0 == 0)
				m[i][0] = 0;

		}
	}

}
