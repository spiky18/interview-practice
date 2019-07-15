package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Vertex[] graph = new Vertex[numCourses];
		for (int[] arr : prerequisites) {
			if(graph[arr[1]]==null)
				graph[arr[1]]=new Vertex(arr[1]);
			if(graph[arr[0]]==null)
				graph[arr[0]]=new Vertex(arr[0]);
			graph[arr[1]].add(graph[arr[0]]);
		}
		Stack<Integer> order = new Stack<>();
		for (Vertex v : graph) {
			if(v.color=='w'){
			if (!topologicalSort(v, order)){
				return new int[0];
				}
			}
		}
		int[] orderArray = new int[order.size()];
		for (int i = 0; i < orderArray.length; i++) {
			orderArray[i] = order.pop();
		}
		return orderArray;
	}

	public boolean topologicalSort(Vertex v, Stack<Integer> topSortSeq) {
		if (v.color == 'g'){
			topSortSeq.clear();
			topSortSeq=null;
			return false;
			}
		else if (v.color == 'w') {
			v.color = 'g';
			boolean result=true;
			for (Vertex u : v.adjacents) {
				result=result&topologicalSort(u, topSortSeq);
				if(!result)
					break;
			}
			v.color = 'b';
			if(result)
				topSortSeq.push(v.label);
			return result;
		}
		return true;
	}

	class Vertex {
		public int label, inDegree;
		public List<Vertex> adjacents;
		public char color;

		public Vertex(int lab) {
			this.label = lab;
			inDegree = 0;
			adjacents = new ArrayList<>();
			color = 'w';
		}

		public void add(Vertex v) {
			v.inDegree++;
			adjacents.add(v);
		}
	}

	public static void main(String[] args) {
		int numcourses=1;
		int[][] prerequisite={};
		CourseScheduleII obj=new CourseScheduleII();
		int[] res=obj.findOrder(numcourses, prerequisite);
		for(int i : res)
			System.out.print(i+" ");
		
	}
}
