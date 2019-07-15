package com.leetcode;

import java.util.Stack;

public class LargestRectangleHistogram {
	//[2,1,5,6,2,3]
	public int largestRectangleArea(int[] heights) {
		int max=0;
		Stack<Integer> stack= new Stack<>();
		int i=0;
		while(i<heights.length || !stack.isEmpty()){
			if(stack.isEmpty() || (!stack.isEmpty() && i<heights.length && heights[i]>=heights[stack.peek()])){
                    stack.push(i);
				i++;
			}else{
				int area=0;
				if(!stack.isEmpty()){
					int j=stack.pop();
                    int width=stack.isEmpty()?i:i-stack.peek()-1;
					area=width*heights[j];
					max=Math.max(area, max);
				}
				
			}
			
		}
		return max;
    }

}
