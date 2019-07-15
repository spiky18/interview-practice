package com.leetcode;

import java.util.ArrayList;

public class MinAbsDifference {
	public ArrayList<Integer> sortedArr=new ArrayList<Integer>();
	public int getMinimumDifference(TreeNode root) {
		int min=Integer.MAX_VALUE,i=0;
		inOrder(root);
		while(i<sortedArr.size()-1){
			int diff=Math.abs(sortedArr.get(i+1)-sortedArr.get(i));
			if(diff<min)
				min=diff;
			if(diff==0)
				return diff;
		}
		return min;
	}
	
	public void inOrder(TreeNode root){
		if(root!=null){
			inOrder(root.left);
			sortedArr.add(root.val);
			inOrder(root.right);
		}
	}
}
