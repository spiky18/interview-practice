package com.hr.cc;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSShortestPath {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		BFSShortestPath obj=new BFSShortestPath();
		while(t>0){
			int n=in.nextInt();
			int m=in.nextInt();
			int[][] graph=new int[n][n];
			while(m-->0){
				int i=in.nextInt();
				int j=in.nextInt();
				graph[i-1][j-1]=1;
				graph[j-1][i-1]=1;
			}
			int s=in.nextInt();
			s-=1;
			int[] dist=obj.bfs(graph,s);
			obj.print(dist, s);
			t--;
		}
	}
	
	public int[] bfs(int[][] matrix,int s){
		int[] dist=new int[matrix.length];
		for(int i=0;i<dist.length;i++)
			dist[i]=Integer.MAX_VALUE;
		dist[s]=0;
		Queue<Integer> queue=new LinkedList<>();
		HashSet<Integer> visited=new HashSet<>();
		queue.add(s);
		visited.add(s);
		while(!queue.isEmpty()){
			int v=queue.poll();
			for(int i=0;i<matrix.length;i++){
				if(matrix[v][i]==1 && !visited.contains(i)){
					visited.add(i);
					queue.add(i);
					dist[i]=dist[v]+6;
				}
			}
			
		}
		return dist;
	}

	public void print(int[] arr,int s){
		for(int i=0;i<arr.length;i++){
			if(i==s)
				continue;
			System.out.print(arr[i]+" ");
		}
		 System.out.println();
	}
}
