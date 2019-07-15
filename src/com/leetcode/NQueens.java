package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	public List<List<String>> solveNQueens(int n) {
		char[][] matrix = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				matrix[i][j] = '.';
		}
		List<List<String>> resultList = new ArrayList<>();
		helper(matrix, 0, resultList);

		return resultList;
	}

	public boolean helper(char[][] matrix, int row, List<List<String>> resultList) {
		if (row == matrix.length){
            List<String> list = new ArrayList<>();
			for (int k = 0; k < matrix.length; k++) {
				list.add(String.valueOf(matrix[k]));
				}
			resultList.add(list);
			return true;
        }
		else {
			for (int i = 0; i < matrix.length; i++) {

				if (isSafe(matrix, row, i)) {
					matrix[row][i] = 'Q';
					helper(matrix, row + 1, resultList);
					/*if (helper(matrix, row + 1, resultList)) {

						return true;
					}*/

					matrix[row][i] = '.';
				}
			}
		}
		return false;
	}

	public boolean isSafe(char[][] matrix, int row, int col) {
		for (int i = 0; i < matrix.length; i++) {
			if (i != row && matrix[i][col] == 'Q')
				return false;
			if (i != col && matrix[row][i] == 'Q')
				return false;
		}
		int i = row - 1, j = col - 1;
		while (i >= 0 && j >= 0) {
			if (matrix[i][j] == 'Q')
				return false;
			i--;
			j--;
		}
		i = row + 1;
		j = col + 1;
		while (i < matrix.length && j < matrix.length) {
			if (matrix[i][j] == 'Q')
				return false;
			i++;
			j++;
		}
		i = row - 1;
		j = col + 1;
		while (i >= 0 && j < matrix.length) {
			if (matrix[i][j] == 'Q')
				return false;
			i--;
			j++;
		}

		i = row + 1;
		j = col - 1;
		while (i < matrix.length && j >= 0) {
			if (matrix[i][j] == 'Q')
				return false;
			i++;
			j--;
		}
		return true;
	}
	
	
}
