package com.imc;

import java.util.HashSet;

public class ImcOA {
	public String validSubstring(String s){
		int startIndx=-1,maxlen=0;
		s=s+"$";
		boolean isCaps=false;
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<s.length();i++){
			if(Character.isAlphabetic(s.charAt(i))){
				if(startIndx==-1)
					startIndx=i;
				if(Character.isUpperCase(s.charAt(i))){
					isCaps=true;
				}
			}else{
				if(isCaps){
					maxlen=Math.max(maxlen, i-startIndx);
					sb=new StringBuilder(s.substring(startIndx, i));
					}
				startIndx=-1;
				isCaps=false;
			}
		}
		
		return sb.toString();
	}
	
	public int validSubstringlength(String s){
		int startIndx=-1,maxlen=-1;
		s=s+"$";
		boolean isCaps=false;
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<s.length();i++){
			if(Character.isAlphabetic(s.charAt(i))){
				if(startIndx==-1)
					startIndx=i;
				if(Character.isUpperCase(s.charAt(i))){
					isCaps=true;
				}
			}else{
				if(isCaps){
					maxlen=Math.max(maxlen, i-startIndx);
					sb=new StringBuilder(s.substring(startIndx, i));
					}
				startIndx=-1;
				isCaps=false;
			}
		}
		
		return maxlen;
	}
	
	public int elevator(int[] A,int[] B,int X,int Y){
		int count=0;
		int currWeight=0,currNoOfPeople=0;
		HashSet<Integer> stops=new HashSet<>();
		int i=0;
		while(i<A.length){
			if(A[i]+currWeight<=Y && currNoOfPeople+1<=X){
				currWeight+=A[i];
				currNoOfPeople++;
				stops.add(B[i]);
			}else{
				count+=stops.size()+1;
				currNoOfPeople=1;
				currWeight=A[i];
				stops.clear();
				stops.add(B[i]);
			}
			i++;
			
		}
		
		return count+stops.size()+1;
	}
	
	public int numberOfCountries(int[][] m){
		boolean[][] visited=new boolean[m.length][m[0].length];
		int count=0;
		for(int i=0;i<m.length;i++){
			for(int j=0;j<m[0].length;j++){
				if(!visited[i][j]){
					dfs(m, i, j, visited, m[i][j]);
					count++;
				}
			}
		}
		return count;
	}
	
	public void dfs(int[][] m,int i,int j,boolean[][] visited,int val ){
		if(i>=m.length || j>=m[0].length || i<0 || j<0)
			return;
		if(visited[i][j])
			return;
		if(m[i][j]!=val)
			return;
		visited[i][j]=true;
		dfs(m, i-1, j, visited, val);
		dfs(m, i+1, j, visited, val);
		dfs(m, i, j-1, visited, val);
		dfs(m, i, j+1, visited, val);
	}
	
	
	
	public static void main(String[] args) {
		ImcOA obj=new ImcOA();
		System.out.println(obj.validSubstringlength(""));
		System.out.println(obj.validSubstringlength("a"));
		System.out.println(obj.validSubstring("a99Abbc3"));
		System.out.println(obj.validSubstring("Abb9ABBcc"));
		System.out.println(obj.validSubstring("Abc"));
		
		int[][] m={{1,1,1,1,0},{1,1,0,1,0},{2,2,3,3,3},{0,0,0,0,0}};
		//System.out.println(obj.numberOfCountries(m));
		
		int[] A={40,40,100,80,20};
		int[] B={3,3,2,2,3};
		System.out.println(obj.elevator(A, B, 5, 200));
	}
}
