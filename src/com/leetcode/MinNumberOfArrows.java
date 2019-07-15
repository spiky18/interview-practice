package com.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MinNumberOfArrows {
	public int findMinArrowShots(int[][] points) {

		List<Interval> queue = new LinkedList<Interval>();
		for (int[] arr : points) {
			queue.add(new Interval(arr[0], arr[1]));
		}
		Collections.sort(queue);

		Interval prev = null;
		int cnt = 0;
		while (queue.size() > 0) {
			cnt++;
			prev = queue.get(0);
			int i = 1;
			while (i < queue.size()) {
				Interval temp=queue.get(i);
				if (prev.end <= temp.start) {
					queue.remove(prev);
					prev = temp;
				}
				i++;
			}
			queue.remove(prev);
		}

		return cnt;
	}

	class Interval implements Comparable<Interval> {
		public int start, end;

		public Interval(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Interval o) {
			return this.end - o.end;
		}
	}
}
