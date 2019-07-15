package com.leetcode;

import java.awt.HeadlessException;
import java.util.Arrays;
import java.util.Stack;

public class LC085 {

	public int maximalRectangle(char[][] matrix) {
		int m=matrix.length,n=matrix[0].length,max=0;
		int[][] height=new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(i==0){
					height[i][j]=matrix[i][j]-'0';
				}else{
					height[i][j]=height[i-1][j]+(matrix[i][j]-'0');
				}
			}
		}
		
		for(int[] hist : height){
			System.out.println(Arrays.toString(hist));
			max=Math.max(max, maxAreaInHistogram(hist));
		}
		return max;
	}
	
	public int maxAreaInHistogram(int[] histogram){
		int max=0,i=0;
		Stack<Integer> stack=new Stack<>();
		while(i<histogram.length || !stack.isEmpty()){
			if(stack.isEmpty() || i<histogram.length && histogram[i]>=histogram[stack.peek()]){
				stack.push(i);
				i++;
			}else{
				int j=stack.pop();
				int width=stack.isEmpty()?i:i-stack.peek()-1;
				max=Math.max(max, width*histogram[j]);
				
			}
			
		}
		
		
		
		return max;
		
	}

}
