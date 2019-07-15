package com.ufpt;

import java.util.Scanner;

public class FlipGame {
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] arr=new int[n];
		int cnt=0;
		for(int i=0;i<arr.length;i++){
			arr[i]=in.nextInt();
			cnt+=arr[i];
		}
		int[][] matrix=new int[n][n];
		int max=cnt;
		for(int i=0;i<arr.length;i++){
			matrix[i][i]=cnt+(arr[i]==0?1:-1);
			max=Math.max(matrix[i][i], max);
		}
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				matrix[i][j]=matrix[i][j-1]+(arr[j]==0?1:-1);
				max=Math.max(matrix[i][j], max);
			}
		}
		System.out.println(max);
	}

}
