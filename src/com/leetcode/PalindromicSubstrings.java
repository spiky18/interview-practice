package com.leetcode;

public class PalindromicSubstrings {
	public int countSubstrings(String s) {
		int sum = 0;
		int[][] dp = new int[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if (s.charAt(j-i) == s.charAt(j)) {
					if (((i - 2) >= 0 && (j - 1) >= 0 && dp[i - 2][j - 1] == 1) || i <= 1) {
						dp[i][j] = 1;
						sum+=1;
					}
				}
			}
		}
		return sum;
	}
}
