package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		int r=board.length;
		if(r==0)
			return false;
		int c=board[0].length;
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				if(dfsII(0, word, i,j, board))
					return true;
			}
		}
		return false;
	}

	public boolean dfs(int i, String s, Point point, Set<Point> pointSet, char[][] board) {
		if(!isValidIndex(point.x, point.y, board))
			return false;
		if (!pointSet.contains(point)) {
			if (board[point.x][point.y] == s.charAt(i)) {
				if (i == s.length() - 1)
					return true;
				pointSet.add(point);
				Point left = new Point(point.x - 1, point.y);
				boolean l = dfs(i + 1, s, left, pointSet, board);
				if (l)
					return true;
				Point right = new Point(point.x + 1, point.y);
				boolean r = dfs(i + 1, s, right, pointSet, board);
				if (r)
					return true;
				Point up = new Point(point.x, point.y - 1);
				boolean u = dfs(i + 1, s, up, pointSet, board);
				if (u)
					return true;
				Point down = new Point(point.x, point.y + 1);
				boolean d = dfs(i + 1, s, down, pointSet, board);
				if (d)
					return true;
				pointSet.remove(point);
			}
		}
		return false;
	}

	public boolean dfsII(int indx, String s, int i,int j, char[][] board) {
		if(!isValidIndex(i, j, board))
			return false;
			if (board[i][j] == s.charAt(indx)) {
				if (indx == s.length() - 1)
					return true;
				char temp=board[i][j];
				board[i][j]='#';
				boolean l = dfsII(indx + 1, s, i-1,j, board);
				if (l)
					return true;
				boolean r =  dfsII(indx + 1, s, i+1,j, board);
				if (r)
					return true;
				boolean u = dfsII(indx + 1, s,  i,j-1, board);
				if (u)
					return true;
				boolean d = dfsII(indx + 1, s, i,j+1 , board);
				if (d)
					return true;
				board[i][j]=temp;
			}
		
		return false;
	}
	
	class Point {
		public int x, y;

		public Point(int i, int j) {
			x = i;
			y = j;
		}

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return 1;
		}

		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			if (obj instanceof Point) {
				Point temp = (Point) obj;
				return temp.x == this.x && temp.y == this.y;
			}
			return false;
		}
	}
	
	public boolean isValidIndex(int i,int j,char[][] board){
		return i>=0 && i<board.length && j>=0 && j<board[0].length;
	}
}
