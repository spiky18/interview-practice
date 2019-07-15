package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC743 {
	
	public int networkDelayTime(int[][] times, int N, int K) {
		int[][] graph=new int[N][N];
		for(int i=0;i<times.length;i++){
				graph[times[i][0]-1][times[i][1]-1]=times[i][2];
		}
		
		
        return 0;
    }
	
	public void djikstra(int[][] graph,int k){
		int[] distance=new int[graph.length];
		Arrays.fill(distance, -1);
		distance[k]=0;
		PriorityQueue<Vertex> pq=new PriorityQueue<>();
		pq.add(new Vertex(k, 0));
		while(pq.isEmpty()){
			Vertex v=pq.poll();
			if(distance[v.label]==-1){
				distance[v.label]=v.dist;
			}/*else if(distance[v.label]>dis){
				
			}*/
		}
		
	}
	
	class Vertex implements Comparable<Vertex>{
		public int label,dist;
		Vertex(int l,int d){
			this.label=l;
			this.dist=d;
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return this.dist-o.dist;
		}
		
	}
	
	

}
