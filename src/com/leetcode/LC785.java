package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LC785 {

	public boolean isBipartite(int[][] graph) {
		int[] color = new int[graph.length];
		Arrays.fill(color, -1);
		for (int i = 0; i < graph.length; i++) {
			if (color[i] == -1 && !color(i, 0, graph, color))
				return false;

		}

		return true;
	}

	public boolean color(int node, int color, int[][] graph, int[] colors) {
		if (colors[node] != -1 && colors[node] != color)
			return false;
		colors[node] = color;
		for (int neighbors : graph[node]) {
			if (!color(neighbors, 1 - color, graph, colors)) {
				return false;
			}
		}
		return true;
	}

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

		int[] color = new int[graph.length];
		Arrays.fill(color, -1);
		List<List<Integer>> result = new ArrayList<>();
		dfs(graph, new ArrayList<>(), result, 0, color);

		return result;

	}

	public void dfs(int[][] graph, List<Integer> path, List<List<Integer>> result, int node, int[] color) {
		if (color[node] != -1 && node != graph.length - 1)
			return;
		color[node] = 0;
		path.add(node);
		if (node == graph.length - 1) {
			result.add(new ArrayList<>(path));

		} else {

			for (int neighbor : graph[node]) {
				dfs(graph, path, result, neighbor, color);
			}
		}

		path.remove(path.size() - 1);
		color[node] = -1;

	}

	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> wordSet = new HashSet<>(wordDict);
		boolean[] dp = new boolean[s.length()];
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <= i; j++) {
				String subString = s.substring(j, i + 1);
				if (s.contains(subString) && (j == 0 || dp[j - 1])) {
					dp[i] = true;
					break;
				}

			}
		}

		return dp[s.length() - 1];
	}

	public List<String> removeInvalidParentheses(String s) {
		List<String> result = new ArrayList<>();
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		queue.add(s);

		visited.add(s);
		boolean found = false;
		while (!queue.isEmpty()) {
			String front = queue.poll();
			if (isValidSequence(front)) {
				result.add(front);

				found = true;
			}
			if (found)
				continue;
			for (int i = 0; i < front.length(); i++) {
				if (front.charAt(i) != '(' && front.charAt(i) != ')')
					continue;
				String candidate = front.substring(0, i) + front.substring(i + 1);
				if (!visited.contains(candidate)) {
					queue.add(candidate);
					visited.add(candidate);
				}
			}

		}

		return result;
	}

	boolean isValidSequence(String s) {
		int count = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '(')
				count++;
			else if (ch == ')')
				count--;
			if (count < 0)
				return false;
		}

		return count == 0;
	}

}
