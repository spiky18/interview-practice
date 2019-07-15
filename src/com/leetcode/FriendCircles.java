package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FriendCircles {
	public int findCircleNum(int[][] M) {
		int count = 0;
		int r = M.length, c = 0;
		if (r != 0)
			c = M[0].length;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (M[i][j] == 1) {
					dfs(M, i, j);
					count++;
				}
			}
		}
		return count;
	}

	public void dfs(int[][] m, int i, int j) {
		if (i < 0 || j < 0 || i >= m.length || j > m[0].length || m[i][j]==0)
			return;
		m[i][j] = 0;
		dfs(m, i - 1, j);
		dfs(m, i + 1, j);
		dfs(m, i, j + 1);
		dfs(m, i, j - 1);
	}	
	
	public int bfs(int[][]M){
		int count = 0;
		int r = M.length, c = 0;
		if (r != 0)
			c = M[0].length;
		if(c==0)
			return count;
		int[] dx={-1,1,0,0};
		int[] dy={0,0,-1,1};
		
		for(int i=0;i<r;i++){
			for (int j = 0; j < c; j++) {
				if(M[i][j]==1){
					count++;
					Point pnt=new Point(i, j);
					Queue<Point> queue=new LinkedList<>();
					queue.add(pnt);
					while(!queue.isEmpty()){
						Point temp=queue.poll();
						int x=temp.x,y=temp.y;
						M[x][y]=0;
						for(int k=0;k<4;k++){
							if((x+dx[k])>=0 && (x+dx[k])<r && (y+dy[k])>=0 && (y+dy[k])<c && M[x+dx[k]][y+dy[k]]==1){
								Point adj=new Point(x+dx[k], y+dy[k]);
								queue.add(adj);
								M[x+dx[k]][y+dy[k]]=0;
							}
						}
					}
				}
			}
		}
		
		return count;
	}
	static class Point{
		int x,y;
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) {
		FriendCircles f=new FriendCircles();
		int[][] m=new int[100][100];
		for(int i=0;i<100;i++){
			for(int j=0;j<100;j++)
				m[i][j]=1;
		}
		System.out.println(f.bfs(m));
	}
	
	/*public int unionFind(int[][] m){
		int[] id=new int[m.length];
		for(int i=0;i<id.length;i++)
			id[i]=i;
		for(int i=0;i<m.length;i++){
			for(int j=i+1;j<m[0].length;j++){
				if(m[i][j]==1)
					id[j]=i;
			}
		}
		
		for(int i=0;i<id.length;i++){
			for(int j=0;j<id.length;j++){
				if(id[j]!=j){
					id[j]=id[id[j]];
				}
			}
		}
		
		HashSet<Integer> set=new HashSet<>();	
		for(int i=0;i<id.length;i++){
			set.add(id[i]);
		}
		return set.size();
	}*/
	
	class UnionFind {
		private int[] id;
		public UnionFind(int num) {
			id = new int[num];
			for(int i=0;i<num;i++)
				id[i]=i;
		}
		
		public int root(int i){
			while(i!=id[i] )
				i=id[i];
			return i;
		}
		
		public boolean isConnected(int i, int j){
			return root(i)==root(j);
		}
		
		public void union(int p,int q){
			int i=root(p);
			int j=root(q);
			id[j]=i;
		} 
		
		public int count(){
			HashSet<Integer> set=new HashSet<>();
			for(int i : id)
				set.add(i);
			return set.size();
		}
	}
	
	public int findCircleNumII(int[][] m) {
		UnionFind uf=new UnionFind(m.length);
		for(int i=0;i<m.length;i++){
			for(int j=i+1;j<m.length;j++)
				uf.union(i, j);
		}
		return uf.count();
	}
}
