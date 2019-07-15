package com.leetcode;

public class DiameterBinaryTree {
	int maxHeight=0;
	public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxHeight;
    }
	
	public int height(TreeNode root){
		if(root==null)
			return 0;
		int l=height(root.left);
		int r=height(root.right);
		maxHeight=maxHeight>(l+r)?maxHeight:(l+r);
		return 1+Math.max(l, r);
	}
}
