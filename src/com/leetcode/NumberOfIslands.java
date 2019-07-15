package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NumberOfIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int r = in.nextInt();
		int c = in.nextInt();
		in.nextLine();
		char[][] image = new char[r][c];
		boolean[][] vis = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			String row = in.nextLine();
			for (int j = 0; j < c; j++)
				image[i][j] = row.charAt(j);
		}
		int numOfIslands = numIslands(image);
		System.out.println(numOfIslands);
	}

	public static int numIslands(char[][] grid) {
		int r = grid.length;
		int c = grid[0].length;
		boolean[][] visited = new boolean[r][c];
		int[] xMoves = { 0, 0, 1, -1 };
		int[] yMoves = { 1, -1, 0, 0 };
		int noOfIslands = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (visited[i][j] == false && grid[i][j] == '1') {
					noOfIslands++;
					visited[i][j] = true;
					Point point = new Point(i, j);
					Queue<Point> queue = new LinkedList<Point>();
					queue.offer(point);
					while (!queue.isEmpty()) {
						Point p = queue.poll();
						int px = p.x;
						int py = p.y;
						for (int k = 0; k < 4; k++) {
							if ((px + xMoves[k] >= 0 && px + xMoves[k] < r)
									&& (py + yMoves[k] >= 0 && py + yMoves[k] < c)
									&& (visited[px + xMoves[k]][py + yMoves[k]] == false
											&& grid[px + xMoves[k]][py + yMoves[k]] == '1')) {
								visited[px + xMoves[k]][py + yMoves[k]] = true;
								Point temp = new Point(px + xMoves[k], py + yMoves[k]);
								queue.offer(temp);
							}
						}
					}
				}
			}
		}
		return noOfIslands;
	}

	public static class Point {
		public int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}