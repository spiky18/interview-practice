package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Vertex[] graph=new Vertex[numCourses];
		for(int i=0;i<numCourses;i++)
			graph[i]=new Vertex(i);
		Set<Vertex> startNodes=new HashSet<>();
		for(int[] arr : prerequisites){
			graph[arr[1]].add(graph[arr[0]]);
		}
		for(int i=0;i<numCourses;i++){
			if(graph[i].inDegree==0)
				startNodes.add(graph[i]);
			}
		if(startNodes.isEmpty())
			return false;
		Set<Vertex> visited=new HashSet<>();
		for(Vertex v : startNodes){
			visited=topologicalSort(v, visited);
			if(visited.isEmpty())
				return false;
		}
		return visited.size()==numCourses;
	}

	class Vertex {
		public int label, inDegree;
		public List<Vertex> adjacents;

		public Vertex(int lab) {
			this.label = lab;
			inDegree = 0;
			adjacents = new ArrayList<>();
		}

		public void add(Vertex v) {
			v.inDegree++;
			adjacents.add(v);
		}
	}
	
	public Set<Vertex> topologicalSort(Vertex startNode,Set<Vertex> set){
		Queue<Vertex> queue=new LinkedList<>();
		queue.add(startNode);
		
		while(!queue.isEmpty()){
			Vertex u=queue.poll();
			set.add(u);
			for(Vertex v : u.adjacents)
			{
				if(!set.contains(v)){
				v.inDegree--;
				if(v.inDegree==0)
					queue.add(v);
				}
				else
					return new HashSet<Vertex>();
			}
		}
		
		return set;
		
	}
}
