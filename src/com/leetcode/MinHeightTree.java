package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinHeightTree {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		Vertex[] graph = new Vertex[n];
		for (int i = 0; i < n; i++)
			graph[i] = new Vertex(i);
		for (int i = 0; i < edges.length; i++) {
			Vertex u = graph[edges[i][0]];
			Vertex v = graph[edges[i][1]];
			u.add(v);
			v.add(u);
		}
		Queue<Vertex> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (graph[i].size == 1)
				queue.add(graph[i]);
		}
		while (n > 2) {
			n -= queue.size();

			int i = 0, j = queue.size();
			while (i < j) {
				Vertex v = queue.poll();
				for (Vertex u : v.adjacents) {
					u.remove(v);
					if (u.size == 1)
						queue.add(u);
				}
				i++;
			}
		}
		List<Integer> result = new ArrayList<>();
		while (!queue.isEmpty()) {
			result.add(queue.poll().label);
		}
		return result;
	}

	

	class Vertex {
		public int label, size;
		public List<Vertex> adjacents;

		// public boolean isDegree1;
		public Vertex(int lab) {
			label = lab;
			adjacents = new LinkedList<>();
			size = 0;
		}

		public void add(Vertex v) {
			adjacents.add(v);
			size++;
		}

		public void remove(Vertex v) {
			adjacents.remove(v);
			size--;
		}

	}

	/*
	 * public int bfs(int[][] edges, int s){ int[] dist=new int[edges.length];
	 * int height=Integer.MA Queue<Integer> queue=new LinkedList<>();
	 * queue.add(s); Set<Integer> visited=new HashSet<>(); visited.add(s);
	 * while(!queue.isEmpty()){ int i=queue.poll(); for(int
	 * j=0;j<edges.length;j++){ if(!visited.contains(j) && ) } }
	 * 
	 * }
	 */
}
