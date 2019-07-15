package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import com.ufpt.MinIslands.Point;

public class IslandPerimerter {
	public static class Point {
		int x, y; // row column
		/*
		 * public Point(int x,int y){ this.x=x; this.y=y; }
		 */

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public int islandPerimeter(int[][] grid) {
		int r = grid.length;
		int c = grid[0].length;
		boolean[][] vis = new boolean[r][c];
		int perimeter = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 1 && !vis[i][j]) {

					Point start = new Point(i, j);
					Queue<Point> queue = new LinkedList<>();
					vis[i][j] = true;
					queue.add(start);
					while (!queue.isEmpty()) {
						Point toProcess = queue.poll();
						int currRowPos = toProcess.x;
						int currColPos = toProcess.y;
						// check west Neighbor
						if (currColPos - 1 >= 0 && !vis[currRowPos][currColPos - 1]
								&& (grid[currRowPos][currColPos - 1] == 1)) {
							vis[currRowPos][currColPos - 1] = true;
							grid[currRowPos][currColPos - 1] = 1;
							queue.add(new Point(currRowPos, currColPos - 1));
						}
						else if (currColPos - 1 < 0 || !vis[currRowPos][currColPos - 1])
							perimeter++;
						// check east neighbour
						if (currColPos + 1 < c && !vis[currRowPos][currColPos + 1]
								&& (grid[currRowPos][currColPos + 1] == 1)) {
							vis[currRowPos][currColPos + 1] = true;
							grid[currRowPos][currColPos + 1] = 1;
							queue.add(new Point(currRowPos, currColPos + 1));
						}
						else if(currColPos + 1 >= c || !vis[currRowPos][currColPos + 1])
							perimeter++;
						// check north neighbor
						if (currRowPos - 1 >= 0 && !vis[currRowPos - 1][currColPos]
								&& (grid[currRowPos - 1][currColPos] == 1)) {
							vis[currRowPos - 1][currColPos] = true;
							grid[currRowPos - 1][currColPos] = 1;
							queue.add(new Point(currRowPos - 1, currColPos));
						}
						else if(currRowPos - 1 < 0 || !vis[currRowPos - 1][currColPos])
							perimeter++;
						// check south neighbor
						if (currRowPos + 1 < r && !vis[currRowPos + 1][currColPos]
								&& (grid[currRowPos + 1][currColPos] == 1)) {
							vis[currRowPos + 1][currColPos] = true;
							grid[currRowPos + 1][currColPos] = 1;
							queue.add(new Point(currRowPos + 1, currColPos));
						}
						else if (currRowPos + 1 >= r || !vis[currRowPos - 1][currColPos])
							perimeter++;
					}
				}

			}
			if(perimeter!=0)
				break;
		}
		return perimeter;
	}
}
