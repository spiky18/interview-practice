package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC675 {
	public static int cutOffTree(List<List<Integer>> forest) {

		PriorityQueue<Point> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
		for (int i = 0; i < forest.size(); i++) {
			for (int j = 0; j < forest.get(i).size(); j++) {
				if (forest.get(i).get(j) > 1) {
					if (i > 0 && forest.get(i - 1).get(j) > 0 || i < forest.size() - 1 && forest.get(i + 1).get(j) > 0
							|| j > 0 && forest.get(i).get(j - 1) > 0
							|| j < forest.get(i).size() - 1 && forest.get(i).get(j + 1) > 0)
						heap.add(new Point(forest.get(i).get(j), i, j));
					else
						return -1;
				}
			}
		}
		Point start = new Point(0, 0, 0);
		int minDist = 0;
		while (!heap.isEmpty()) {
			Point point = heap.poll();
			minDist += Math.abs(point.x - start.x) + Math.abs(point.y - start.y);
			start = point;

		}
		return minDist;
	}

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Integer> list2 = Arrays.asList(0, 0, 4);
		List<Integer> list3 = Arrays.asList(7, 6, 5);
		List<List<Integer>> forest = new ArrayList<>();
		forest.add(list1);
		forest.add(list2);
		forest.add(list3);

		System.out.println(cutOffTree(forest));

	}

	public int[][] listToMatrix(List<List<Integer>> forest) {
		int[][] matrix = new int[forest.size()][];
		int i = 0;
		for (List<Integer> l : forest) {

			for (int j = 0; j < l.size(); j++) {
				matrix[i][j] = l.get(j);

			}
			i++;

		}

		return matrix;
	}
}

class Point {
	int val, x, y;

	Point(int v, int i, int j) {
		this.val = v;
		this.x = i;
		this.y = j;
	}

}