package com.leetcode;

import java.util.HashSet;

public class UnionFindCLRS {
	public int[] rank;
	public int[] parent;
	
	public UnionFindCLRS(int n) {
		rank=new int[n];
		parent=new int[n];
		for(int i=0;i<n;i++)
			parent[i]=i;
	}
	
	public int findSet(int x){
		if(x!=parent[x])
			parent[x]=findSet(parent[x]);
		return parent[x];
	}
	
	public void union(int x,int y){
		link(findSet(x),findSet(y));
	}

	private void link(int x, int y) {
		//if(x!=y){
		if(rank[x]>rank[y])
			parent[y]=x;
		else{
			parent[x]=y;
			if(rank[x]==rank[y])
				rank[y]+=1;
		}
		//}
	}
	
	public int count(){
		HashSet<Integer> set=new HashSet<>();
		for(int i : parent)
			set.add(i);
		return set.size();
	}
	
	public static int findCircleNum(int[][] m) {
	    UnionFindCLRS uf=new UnionFindCLRS(m.length);
			for(int i=0;i<m.length;i++){
				for(int j=i+1;j<m.length;j++)
					if(m[i][j]==1)uf.union(i, j);
			}
			for(int i=0;i<m.length;i++){
			    uf.findSet(i);
			}
			//uf.printParent();
			return uf.count();
		}
	
	public void printParent(){
		for(int i=0;i<parent.length;i++)
			System.out.print(parent[i]+" ");
		System.out.println();
	}
	public static void main(String[] args) {
		int [][] m={{1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},{1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},{0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},{0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},{0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},{1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},{0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},{0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},{0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},{0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}};
		
		System.out.println(findCircleNum(m));
	}
}
