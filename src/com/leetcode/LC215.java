package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class LC215 {

	public int findKthLargest(int[] nums, int k) {
		return partition(nums, 0, nums.length - 1, nums.length - k + 1);
	}

	public int randPartition(int[] nums, int left, int right) {
		Random r = new Random();
		int k = left + r.nextInt(right - left);
		k = nums[k];
		int i = left, j = left - 1;
		while (i <= right) {
			if (nums[i] <= k) {
				j++;
				swap(nums, j, i);
			}

		}
		j++;
		swap(nums, j, right);

		return j;
	}

	public int partition(int[] nums, int left, int right, int k) {
		int pivot = nums[right];
		int i = left, j = left - 1;
		while (i <= right) {
			if (nums[i] <= pivot) {
				j++;
				swap(nums, i, j);
			}
			i++;
		}
		j++;
		swap(nums, j, right);
		if (j == k)
			return nums[k];
		if (j < k)
			return partition(nums, j + 1, right, k);
		else
			return partition(nums, left, j - 1, k);
	}

	void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;

	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

		Set<String> set = new HashSet<>(wordList);
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();

		queue.add(beginWord);
		visited.add(beginWord);
		int dist = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int j = 0; j < size; j++) {
				char[] frontArr = queue.poll().toCharArray();
				for (int i = 0; i < frontArr.length; i++) {
					char temp = frontArr[i];
					for (char ch = 'a'; ch <= 'z'; ch++) {
						if (ch != temp) {
							frontArr[i] = ch;
							String word = String.valueOf(frontArr);
							if (word.equals(endWord) && set.contains(word))
								return dist + 1;
							if (!visited.contains(word) && set.contains(word)) {
								visited.add(word);
								queue.add(word);
							}

						}

					}
					frontArr[i] = temp;
				}
			}
			dist++;
		}

		return 0;
	}

	public static void main(String[] args) {
		System.out.println(ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
	}
	
	public int minMutation(String beginWord, String endWord, String[] bank) {

		Set<String> set = new HashSet<>(Arrays.asList(bank));
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();

		queue.add(beginWord);
		visited.add(beginWord);
		int dist = 1;
		char[] mutations={'A', 'C', 'G', 'T'};
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int j = 0; j < size; j++) {
				char[] frontArr = queue.poll().toCharArray();
				for (int i = 0; i < frontArr.length; i++) {
					char temp = frontArr[i];
					for (char ch :mutations) {
						if (ch != temp) {
							frontArr[i] = ch;
							String word = String.valueOf(frontArr);
							if (word.equals(endWord) && set.contains(word))
								return dist + 1;
							if (!visited.contains(word) && set.contains(word)) {
								visited.add(word);
								queue.add(word);
							}

						}

					}
					frontArr[i] = temp;
				}
			}
			dist++;
		}

		return -1;
    }
	
	public boolean exist(char[][] board, String word) {
		for(int i=0;i<board.length;i++){
			for (int j = 0; j < board[0].length; j++) {
				if(dfs(board, word, 0, i, j))
					return true;
			}
			
		}
		
		return false;
		
	}
	
	public boolean dfs(char[][] board,String word,int currIndex,int i,int j){
		if(currIndex==word.length())
			return true;
		
		if(i<0 || i>=board.length || j<0 ||j>board[0].length)
			return false;
		
		if(word.charAt(currIndex)==board[i][j]){
			char temp=board[i][j];
			board[i][j]='#';
			
			boolean dfs= dfs(board, word, currIndex+1, i, j-1)||dfs(board, word, currIndex+1, i, j+1)||dfs(board, word, currIndex+1, i-1, j)||dfs(board, word, currIndex+1, i+1, j);
			if(dfs)
				return true;
			board[i][j]=temp;
		}
		return false;
	}
}
