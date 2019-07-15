package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC017 {
	public List<String> letterCombinations(String digits) {
		String letters = "abcdefghijklmnopqrstuvwxyz";
		HashMap<Integer, String> map = new HashMap<>();
		int j = 0;

		for (int i = 2; i < 10; i++) {
			int inc = i == 7 || i == 9 ? 4 : 3;
			map.put(i, letters.substring(j, j + inc));
			j += inc;
		}

		Queue<String> queue = new LinkedList<>();
		queue.add(map.get(digits.charAt(0) - '0'));
		int count = 1;
		while (count < digits.length()) {
			
			count++;
		}

		return (List)queue;
	}
}
