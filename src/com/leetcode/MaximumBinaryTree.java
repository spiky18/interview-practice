package com.leetcode;

/**
 * Q 654 leetcode
 * 
 * @author Himanshu
 *
 */
public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        boolean[] visited=new boolean[nums.length];
        return help(nums,visited,0,nums.length-1);
    }
    
    public TreeNode help(int[] nums,boolean[] visited,int l,int r){
		if(l>r)
			return null;
		int max=Integer.MIN_VALUE;
		int maxi=-1;
		for(int i=l;i<=r;i++){
			if(nums[i]>max){
				max=nums[i];
				maxi=i;}
		}
		if(visited[maxi])
			return null;
		TreeNode curr=new TreeNode(max);
		visited[maxi]=true;
		curr.left=help(nums, visited, l, maxi-1);
		curr.right=help(nums, visited, maxi+1, r);	
		return curr;		
	} 
}
