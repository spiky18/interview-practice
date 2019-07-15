package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class GraphValidTree {

	public boolean validTree(int n, int[][] edges) {
		int[][] graph = new int[n][n];

		for (int[] e : edges) {
			graph[e[0]][e[1]] = 1;
			graph[e[1]][e[0]] = 1;
		}
		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);

		while (!queue.isEmpty()) {
			int node = queue.poll();
			if (visited[node])
				return false;
			for (int i = 0; i < n; i++) {
				if (!visited[i] && graph[node][i] == 1) {

					queue.add(i);
				}
			}
			visited[node] = true;
		}
		for (boolean b : visited) {
			if (!b)
				return false;
		}

		return true;
	}

	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		HashMap<String,Set<String>> emailMap=new HashMap<>();
		HashMap<String,String> emailToUserMap=new HashMap<>();
		
		for(List<String> list : accounts){
			String userName=list.get(0);
			for (int i = 1; i <list.size(); i++) {
				Set<String> neighbors=emailMap.getOrDefault(list.get(i), new HashSet<>());
				if(i==1)
					continue;
				neighbors.add(list.get(i-1));
				emailMap.get(list.get(i-1)).add(list.get(i));
				emailMap.put(list.get(i), neighbors);
				emailToUserMap.put(list.get(i), userName);
			}
			
		}
		HashSet<String> visited=new HashSet<>();
		List<List<String>> result=new ArrayList<>();
		for(String email : emailMap.keySet()){
			if(!visited.contains(email)){
				//visited.add(email);
				List<String> temp=new ArrayList<>();
				temp.add(email);
				dfs(emailMap, email, visited, temp);
				temp.add(0, emailToUserMap.get(email));
				result.add(temp);
			}
			
		}
		return result;
	}
	
	public void dfs(HashMap<String, Set<String>> map,String email,HashSet<String> visited,List<String> list){
		
		if(!visited.contains(email)){
			visited.add(email);
			list.add(email);
		for(String neighbor  : map.get(email)){
			//if(!visited.contains(neighbor)){
				
				//visited.add(neighbor);
				dfs(map, neighbor, visited, list);
			//}
		}
		
		}
	}
}
