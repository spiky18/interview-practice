package com.microsoft.challenge;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem4 {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> input = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			if (s.equals("")) {
				break;
			}
			ArrayList<Integer> list = new ArrayList<>();
			
			for(char ch : s.toCharArray()) {
				list.add(ch-'0');
			}
			input.add(list);
		}
		int[][] m=new int[input.size()][input.size()];
		int r=0,c=0;
		for(ArrayList<Integer> row : input){
			for(int i : row){
				m[r][c]=i;
				c++;
			}
			r++;
			c=0;
		}
		int n=input.size();
		for(int i=0;i<input.size();i++){
			for(int j=0;j<input.size();j++){
				dfs(m,i,j);
			}}
		
		
		
		for(int i=0;i<input.size();i++){
			for(int j=0;j<input.size();j++){
				System.out.print(m[i][j]);
			}
			if(i!=n-1)
			System.out.println();
		}
		
	}
	
	public static void dfs(int[][] m,int i,int j){
		int n=m.length;
		if(i<0||i>=n ||j<0||j>=n)
			return;
		if(m[i][j]==1)
			return;
		if(m[i][j]==0){
			int noOfinfectedNeighbors=0;
			if(i-1>=0 && m[i-1][j]==1)
				noOfinfectedNeighbors++;
			if(i+1<n && m[i+1][j]==1)
				noOfinfectedNeighbors++;
			if(j-1>=0 && m[i][j-1]==1)
				noOfinfectedNeighbors++;
			if(j+1<n && m[i][j+1]==1)
				noOfinfectedNeighbors++;
			if(noOfinfectedNeighbors>=2)
				m[i][j]=1;
			if(m[i][j]==1){
			dfs(m,i+1,j);
			dfs(m,i-1,j);
			dfs(m,i,j+1);
			dfs(m,i,j-1);
			}
		}
	}

}
