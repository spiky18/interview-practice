package com.leetcode;

public class NearestZero {
		public int[][] updateMatrix(int[][] m) {
			int r = m.length, c = 0;
			if (r != 0)
				c = m[0].length;
			boolean[][] visited = new boolean[m.length][m[0].length];
			int[][] result = new int[r][c];
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[0].length; j++) {
					if (m[i][j] == 1 && !visited[i][j])
						dfs(m, i, j, visited, result);
				}
			}
			return result;
		}
	
		public boolean isValidIndex(int i, int j, int r, int c) {
			return (i >= 0 && i < r && j >= 0 && j < c);
		}
	
		public void dfs(int[][] m, int i, int j, boolean[][] visited, int[][] result) {
			if (!isValidIndex(i, j, m.length, m[0].length))
				return;
			if (m[i][j] == 0 || visited[i][j])
				return;
			visited[i][j] = true;
			int u = 0, d = 0, l = 0, r = 0;
			if (isValidIndex(i + 1, j, m.length, m[0].length)) {
				dfs(m, i + 1, j, visited, result);
				d = 1 + result[i + 1][j];
			}
			if (isValidIndex(i - 1, j, m.length, m[0].length)) {
				dfs(m, i - 1, j, visited, result);
				u = 1 + result[i - 1][j];
			}
			if (isValidIndex(i, j - 1, m.length, m[0].length)) {
				dfs(m, i, j - 1, visited, result);
				l = 1 + result[i][j - 1];
			}
			if (isValidIndex(i, j + 1, m.length, m[0].length)) {
				dfs(m, i, j + 1, visited, result);
				r = 1 + result[i][j + 1];
			}
			result[i][j] = Math.min(Math.min(r, l), Math.min(u, d));
		}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
		NearestZero obj = new NearestZero();
		
		System.out.println(obj.updateMatrix(matrix));
	}

	public int[][] updateMatrixII(int[][] m) {
		int r = m.length, c = 0;
		if (r != 0)
			c = m[0].length;
		int[][] result = new int[r][c];
		boolean[][] visited = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (m[i][j] == 0)
					result[i][j] = 0;
			}
		}
		return result;

	}

}
