package com.leetcode;

public class OrderOfPlusSign {
	
public int orderOfLargestPlusSign(int N, int[][] mines) {
     int max=0;   
     int[][] matrix=new int[N][N];
     int[][] result=new int[N][N];
     for(int i=0;i<N;i++){
    	 for(int j=0;j<N;j++)
    		 matrix[i][j]=1;
     }
     for(int[] m : mines){
    	 matrix[m[0]][m[1]]=0;
     }

     
     int rowstart=1,colstart=1,rowend=N-2,colend=N-2;
    while(true){
    	for(int i=colstart;i<=colend;i++){
    		if(matrix[rowstart-1][i]==1 && matrix[rowstart][i+1]==1 && matrix[rowstart+1][i]==1 && matrix[rowstart][i-1]==1 )
    			result[rowstart][i]=1+Math.min(Math.min(result[rowstart-1][i], result[rowstart+1][i]),Math.min(result[rowstart][i-1], result[rowstart][i+1]));
    		max=Math.max(max,result[rowstart][i]);
    	}
    	rowstart++;
    	if(rowstart>rowend || colstart>colend ) break;
    	for(int i=rowstart;i<=rowend;i++){
    		if(matrix[i][colend-1]==1 && matrix[i+1][colend]==1 && matrix[i][colend+1]==1 && matrix[i-1][colend]==1 )
    			result[colend][i]=1+Math.min(Math.min(result[i][colend-1], result[i][colend+1]),Math.min(result[i-1][colend], result[i+1][colend]));
    		max=Math.max(max,result[i][colend]);
    	}
    	colend--;
    	if(rowstart>rowend || colstart>colend ) break;
    	
    	for(int i=colend;i>=colstart;i--){
    		if(matrix[rowend-1][i]==1 && matrix[rowend][i+1]==1 && matrix[rowend+1][i]==1 && matrix[rowend][i-1]==1 )
    			result[rowend][i]=1+Math.min(Math.min(result[rowend-1][i], result[rowend+1][i]),Math.min(result[rowend][i-1], result[rowend][i+1]));
    		max=Math.max(max,result[rowend][i]);
    	}
    	rowend--;
    	if(rowstart>rowend || colstart>colend ) break;
    	
    	for(int i=rowend;i>=rowstart ;i--){
    		if(matrix[i][colstart-1]==1 && matrix[i+1][colstart]==1 && matrix[i][colstart+1]==1 && matrix[i-1][colstart]==1 )
    			result[colstart][i]=1+Math.min(Math.min(result[i][colstart-1], result[i][colstart+1]),Math.min(result[i-1][colstart], result[i+1][colstart]));
    		max=Math.max(max,result[i][colstart]);
    	}
    	colstart++;
    	if(rowstart>rowend || colstart>colend ) break;
    	
    }
     return max;
    }
	
}
