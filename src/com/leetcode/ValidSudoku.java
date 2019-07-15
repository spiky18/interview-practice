package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		for (int k = 0; k < board.length; k++) {
			Set<Integer> rows = new HashSet<>();
			Set<Integer> cols = new HashSet<>();
			for (int i = 0; i < board.length; i++) {
				if (Character.isDigit(board[k][i])) {
					if (rows.contains(board[k][i]))
						return false;
					rows.add((int) board[k][i]);
				}
				if (Character.isDigit(board[i][k])) {
					if (cols.contains(board[i][k]))
						return false;

					cols.add((int) board[k][i]);
				}
			}
		}
		

		return true;
	}
	
	public boolean validateSquare(char[][] board,int row,int col){
		for(int i=row;i<col+3;i++){
			Set<Integer> square = new HashSet<>();
			for(int j=row;j<col+3;j++){
				if (Character.isDigit(board[i][j])) {
					if (square.contains(board[i][j]))
						return false;
					square.add((int) board[i][j]);
				}
			}
		}
		return true;
	}

}
