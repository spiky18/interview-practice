package com.hr.cc;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class DjikstraAlgorithm  {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] graph=new int[n][n];
            for(int a1 = 0; a1 < m; a1++){
                int x = in.nextInt();
                int y = in.nextInt();
                int r = in.nextInt();
                graph[x-1][y-1]=r;
                graph[y-1][x-1]=r;
            }
            int s = in.nextInt();
            s-=1;
            DjikstraAlgorithm obj=new DjikstraAlgorithm();
            obj.shortestPath(graph, s);
        }
    }
	
	public void shortestPath(int[][] graph,int s){
		//int[] dist=new int[graph.length];
		PriorityQueue<Vertex> queue=new PriorityQueue<>();
		Set<Vertex> set=new HashSet<>();
		Vertex[] vertices=new Vertex[graph.length];
		for(int i=0;i<graph.length;i++)
		{
			Vertex v=new Vertex(i);
			if(i==s)
				v.dist=0;
			queue.add(v);
			vertices[i]=v;
		}
		
		while(!queue.isEmpty()){
			Vertex u=queue.poll();
			set.add(u);
			int i=u.label;
			for(int j=0;j<graph.length;j++){
				if(graph[i][j]!=0 && !set.contains(vertices[j])){
					if(vertices[j].dist>vertices[i].dist+graph[i][j])
						//queue.remove(vertices[j]);
						vertices[j].dist=vertices[i].dist+graph[i][j];						//queue.add(vertices[j]);
				}
			}
			queue.poll();
		}
		
		for(int i=0;i<graph.length;i++){
			if(s!=i){
				if(!set.contains(vertices[i]))
					System.out.print(-1+" ");
				else
					System.out.println(vertices[i].dist+" ");
			}
		}
	}
	
	class Vertex implements Comparable<Vertex>{
		public int label;
		public int dist;
		public Vertex(int label){
			dist=Integer.MAX_VALUE;
		}
		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return this.dist-o.dist;
		}
	}
	
	
}
