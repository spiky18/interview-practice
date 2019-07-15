package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordset = new HashSet<>();
		Map<String, Integer> map = new HashMap<>();
		map.put(beginWord, 0);
		int i = 1, endIndex = 0;
		for (String s : wordList) {
			wordset.add(s);
			map.put(s, i);
			if (s.equals(endWord))
				endIndex = i;
			i++;
		}
		int graph[][] = new int[1 + wordList.size()][1 + wordList.size()];
		i = -1;
		String start = beginWord;
		while (i < wordList.size()) {
			for (String s : wordList) {
				if (s != start) {
					if (oneEdit(s, start)) {
						graph[map.get(s)][map.get(start)] = 1;
						graph[map.get(start)][map.get(s)] = 1;
					}
				}
			}
			i++;
			if (i < wordList.size())
				start = wordList.get(i);
		}
		return bfs(graph, endIndex);
	}

	public boolean oneEdit(String s1, String s2) {
		int i = 0, cnt = 0;
		while (i < s1.length()) {
			if (s1.charAt(i) != s2.charAt(i))
				cnt++;
			if (cnt > 1)
				return false;
			i++;
		}
		return cnt == 1;
	}

	public int bfs(int[][] graph, int endIndex) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		int[] dist = new int[graph.length];
		HashSet<Integer> visited = new HashSet<>();
		while (!queue.isEmpty()) {
			int i = queue.poll();
			visited.add(i);
			for (int j = 0; j < graph.length; j++) {
				if (graph[i][j] == 1 && !visited.contains(j)) {
					visited.add(j);
					queue.add(j);
					dist[j] = dist[i] + 1;
				}
			}
		}
		System.out.println(endIndex);
		return 1+dist[endIndex];
	}

	public static void main(String[] args) {
		WordLadder wl = new WordLadder();
		List<String> list = new ArrayList<>();
		list.add("hot");
		list.add("dot");
		list.add("dog");
		list.add("lot");
		list.add("log");
		list.add("cog");
		System.out.println(wl.ladderLength("hit", "cog", list));
		System.out.println(new StringBuilder("Test").replace(2, 3, "3"));

	}
}
