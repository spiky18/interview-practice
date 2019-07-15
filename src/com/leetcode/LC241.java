package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC241 {

	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*') {
				List<Integer> res1 = diffWaysToCompute(input.substring(0, i));
				List<Integer> res2 = diffWaysToCompute(input.substring(i + 1, input.length()));
				for (int j : res1) {
					for (int k : res2) {
						if (ch == '+') {
							result.add(j + k);
						} else if (ch == '-') {
							result.add(j - k);
						} else {
							result.add(j * k);
						}
					}

				}
				

			}
			

		}
		if(result.size()==0)
			result.add(Integer.parseInt(input));
		return result;

	}

}
