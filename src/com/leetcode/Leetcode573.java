package com.leetcode;

import java.util.Scanner;

public class Leetcode573 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int h=5;
		int w=5;
		int[] treePos={3,2};
		//treePos[0]=in.nextInt();
		//treePos[1]=in.nextInt();
		int[] squirrel={0,1};
		//squirrel[0]=in.nextInt();
		//squirrel[1]=in.nextInt();
		int[][] nuts={{2,0},{4,1},{0,4},{1,3},{1,0},{3,4},{3,0},{2,3},{0,2},{0,0},{2,2},{4,2},{3,3},{4,4},{4,0},{4,3},{3,1},{2,1},{1,4},{2,4}};
		/*nuts[0][0]=3;
		nuts[0][1]=0;
		nuts[1][0]=2;
		nuts[1][1]=5;*/
		
		System.out.println(minDistance(h, w, treePos, squirrel, nuts));
	}

	public static int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
		int min=Integer.MAX_VALUE;
		int maxDistance=0;
		int minNutIndex=0;
		for(int i=0;i<nuts.length;i++){
			int dbwNS=Math.abs(nuts[i][0]-squirrel[0])+Math.abs(nuts[i][1]-squirrel[1]);
			if(dbwNS==min){
				if((Math.abs(nuts[i][0]-tree[0])+Math.abs(nuts[i][1]-tree[1]))>(Math.abs(nuts[minNutIndex][0]-tree[0])+Math.abs(nuts[minNutIndex][1]-tree[1]))){
					minNutIndex=i;
				}
			}
			if(dbwNS<min){
				min=dbwNS;
				minNutIndex=i;
				}
			maxDistance+=Math.abs(nuts[i][0]-tree[0])+Math.abs(nuts[i][1]-tree[1]);
		}
		return 2*maxDistance+min-(Math.abs(nuts[minNutIndex][0]-tree[0])+Math.abs(nuts[minNutIndex][1]-tree[1]));
	}
}
