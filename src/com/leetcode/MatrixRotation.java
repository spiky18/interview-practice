package com.leetcode;

public class MatrixRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a =new int[3][3];
		int count=1;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
			  a[i][j]=count;
			  count++;
			}
		}
		for(int i=0;i<3;i++){
			System.out.print("[");
			for(int j=0;j<3;j++){
			  System.out.print(a[i][j]+" ");
			}
			System.out.print("]");
			System.out.println();
		}
		a=matrixRotation(a, 3, 3, 'c');
		System.out.println("Clockwise Rotation performed");
		for(int i=0;i<3;i++){
			System.out.print("[");
			for(int j=0;j<3;j++){
			  System.out.print(a[i][j]+" ");
			}
			System.out.print("]");
			System.out.println();
		}

	}
	
	public static int[][] matrixRotation(int[][] a,int n, int m, char c){
		if(c=='c'){
		for(int i=0;i<m/2;i++){
			for(int j=0;j<n;j++){
			  int temp=a[i][j];
			  a[i][j]=a[j][i];
			  a[j][i]=temp;
			}
		}
		}
		else{
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
				  int temp=a[i][j];
				  a[i][j]=a[j][i];
				  a[j][i]=temp;
				}
			}
		}
		return a;
		
	}

}
