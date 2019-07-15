package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC022 {
		public List<String> generateParenthesis(int n) {
			List<String> list = new ArrayList<>();
			helper("", 0, 0, n, list);
			return list;
		}

	public void helper(int n, String currString, int insertPos, List<String> list) {
		StringBuilder sb = new StringBuilder(currString);
		sb.insert(insertPos, "()");
		if (n == 1) {
			list.add(sb.toString());
			return;
		}
		helper(n - 1, sb.toString(), insertPos + 1, list);
		helper(n - 1, sb.toString(), insertPos + 2, list);
	}

	public void helper(String s, int open, int close, int max, List<String> list) {
		if (s.length() == 2 * max) {
			list.add(s);
			return;
		}
		if (open < max)
			helper(s + "(", open + 1, close, max, list);
		if (close < open)
			helper(s + ")", open, close + 1, max, list);
	}
}
