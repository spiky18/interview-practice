package com.ufpt;

public class PrintMatrix {
	public static void main(String[] args) {
		int[][] m=new int[13][13];
		for(int i=0;i<13;i++){
			for(int j=0;j<13;j++){
				if(i==0|| j==0)
					m[i][j]=0;
				else if(i==1 || j==1)
				{
					if(i==1)
						m[i][j]=j;
					if(j==1)
						m[i][j]=i;
				}
				else
				{
					m[i][j]=i*j;
					m[j][i]=i*j;
				}
			}
		}
		
		for(int i=0;i<13;i++){
			for(int j=0;j<13;j++){
				System.out.print(m[i][j]+"	");
			}
			System.out.println();
		}
	}
}
