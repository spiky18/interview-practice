package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
	public List<Integer> partitionLabels(String S) {
		List<Integer> result = new ArrayList<Integer>();
		int[] map = new int[26];
		char[] arr = S.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			map[arr[i] - 'a'] = i;
		}
		int last = 0;
		int start = -1;
		for (int i = 0; i < arr.length; i++) {
			last = Math.max(last, map[arr[i] - 'a']);
			if (last == i) {
				result.add(last - start);
				start = last;
			}
		}
		return result;

	}

}
