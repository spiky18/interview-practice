package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MultiplyStrings {

	public static String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0"))
			return "0";
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[num1.length() + num2.length()];

		int k = arr.length - 1;
		for (int i = num1.length() - 1; i >= 0; i--) {
			int temp = k, c = 0;
			for (int j = num2.length() - 1; j >= 0; j--) {
				int sum = c + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

				c = sum / 10;
				arr[k] += (sum % 10);
				if (arr[k] > 9) {
					arr[k - 1] += arr[k] / 10;
					arr[k] %= 10;
				}
				if ((c > 0 && j == 0)) {
					arr[k - 1] += c;
				}
				// System.out.println(sum+" "+arr[k]);
				k--;
			}
			k = temp - 1;
		}

		// System.out.println(Arrays.toString(arr));
		int i = 0;
		while (i < arr.length && arr[i] == 0) {

			i++;
		}
		for (; i < arr.length; i++)
			sb.append(arr[i]);
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(multiply("123", "45"));
	}
	
	 public List<List<String>> solveNQueens(int n) {
		 List<List<String>> result=new ArrayList<List<String>>();
		 char[][] board=new char[n][n];
		 for(char[] arr : board)
			 Arrays.fill(arr, '.');
		 
		 helper(board, 0, 0, n, result);
		 return result;
	        
	    }
	 
	 public void helper(char[][] board,int i,int j,int n,List<List<String>> list){
		 if(i==n){
			 list.add(convertBoardToList(board));
			 return;
		 }
		 board[i][j]='Q';		 
		 if(isValidBoard(board, i, j)){
			 for(int k=0;k<n;k++){
				 helper(board, i+1, k, n, list);
			 }
			 
		 }
		 
		 
		 board[i][j]='.';
	 }
	 
	 public boolean isValidBoard(char[][] board,int r,int c){
		 for(int i=0;i<board.length;i++){
			 if((i!=r && board[i][c]=='Q') || (i!=c && board[r][i]=='Q')){
				 return false;
			 }
				 
		 }
		 int[] rows={-1,1};
		 int[] cols={-1,1};
		 int i=r,j=c;
		 for(int k=0;k<4;k++){
			 for(int l=0;l<4;l++){
				 while(i>=0 && i<board.length && j>=0 && j<board.length){
					 if(i!=r && j!=c && board[i][j]=='Q')
						 return false;
					 i+=rows[i];
					 j+=cols[j];
				 }
				 i=r;
				 j=c;
			 }
		 }
		 
		 return true;
	 }
	 
	 public List<String> convertBoardToList(char[][] board){
		 List<String> result=new ArrayList<>();
		 
		 for(char[] b : board)
			 result.add(String.valueOf(b));
		 
		 return result;
	 }
	 
	 public void wallsAndGates(int[][] rooms) {
		 for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if(rooms[i][j]==0)
					dfs(rooms, i, j, 0);
			}
		}
		 
	    }
	 
	 
	 public void dfs(int[][] rooms,int i,int j,int level){
		 if(i<0 || j<0 || i>=rooms.length||j>=rooms[0].length)
			 return;
		 if(rooms[i][j]==-1 || rooms[i][j]<level)
			 return;
		 rooms[i][j]=level;
		 dfs(rooms, i-1, j, level+1);
		 dfs(rooms, i+1, j, level+1);
		 dfs(rooms, i, j-1, level+1);
		 dfs(rooms, i, j+1, level+1);
		 
		 
	 }
	 
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] inDegree = new int[numCourses];
		int[][] graph = new int[numCourses][numCourses];
		List<Integer> order = new ArrayList<>();

		for (int[] edges : prerequisites) {

			graph[edges[1]][edges[0]] = 1;
			inDegree[edges[0]]++;

		}
		List<Integer> startNodes = new ArrayList<>();
		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] == 0)
				startNodes.add(i);
		}
		if (startNodes.isEmpty())
			return new int[0];
		for (int start : startNodes) {
			Queue<Integer> queue = new LinkedList<>();
			queue.add(start);
			while (!queue.isEmpty()) {
				int head = queue.poll();
				order.add(head);
				for (int i = 0; i < graph.length; i++) {
					if (graph[head][i] == 1) {
						inDegree[i]--;
						if (inDegree[i] == 0)
							queue.add(i);
					}
				}

			}

		}

		//System.out.println(order.toString());

		if (order.size() != numCourses)
			return new int[0];
		int[] res = new int[numCourses];
		for (int i = 0; i < numCourses; i++)
			res[i] = order.get(i);

		return res;

	}
	
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> paths=new ArrayList<>();
		HashSet<String> wordSet=new HashSet<>(wordList);
		HashSet<String> visited=new HashSet<>();
		Queue<String> queue=new LinkedList<>();
		Set<String> lastWords=new HashSet<>();
		queue.add(beginWord);
		visited.add(beginWord);
		int dist=1;
		boolean found=false;
		while(!queue.isEmpty()){
			int size=queue.size();
			for (int i = 0; i < size; i++) {
				String front=queue.poll();
				char[] arr=front.toCharArray();
				for (int j = 0; j < arr.length; j++) {
					for(char ch='a';ch<='z';ch++){
						char temp=arr[j];
						if(temp!=ch){
							arr[j]=ch;
							String cand=String.valueOf(arr);
							if(cand.equals(endWord)){
								lastWords.add(front);
								found=true;
								
							}
							if(found)
								continue;
							if(!visited.contains(cand) && wordSet.contains(cand)){
								queue.add(cand);
								visited.add(cand);
							}
						}
						arr[j]=temp;
					}
				}
				
				
			}
			if(!found)
				dist++;
		}
		//dist++;
		System.out.println(lastWords.toString());
		
		return paths;
    }
	
	public void dfs(String startWord, String searchWord, String endWord, int maxDist, int currDist, Set<String> wordSet,
			List<String> currPath, List<List<String>> paths, Set<String> visited) {
		//if(currDist>maxDist || currDist==maxDist && searchWord.equals(anObject))
	}
	
}
