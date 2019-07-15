package com.leetcode;

public class GameOfLife {

	public void gameOfLife(int[][] board) {
		int[] xMoves = { 0, 0, 1, -1,-1,1, 1,-1};
		int[] yMoves = { 1, -1, 0, 0, 1,1,-1,-1};
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				int livingNeighbors=0;
				for(int k=0;k<xMoves.length;k++){
					if(i+xMoves[k]>=0 && i+xMoves[k]<board.length && j+yMoves[k]>=0 && j+yMoves[k]<board[0].length){
						if(board[i+xMoves[k]][j+yMoves[k]]==1)
							livingNeighbors++;
					}
					if(livingNeighbors<2)
						board[i][j]=0;
					else if(board[i][j]==1 && livingNeighbors>=2 && livingNeighbors<=3)
						board[i][j]=1;
					else if(board[i][j]==1 && livingNeighbors>3)
						board[i][j]=0;
					else if(board[i][j]==0 && livingNeighbors==3)
						board[i][j]=1;
				}
			}
		}
        
    }
}
