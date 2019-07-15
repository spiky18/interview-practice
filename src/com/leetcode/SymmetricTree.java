package com.leetcode;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if(root==null)
			return true;
		return isMirror(root.left, root.right);
	}
	
	public boolean isMirror(TreeNode root1,TreeNode root2){
		if(root1==null && root2==null)
			return true;
		if((root1!=null && root2==null) || root2!=null && root1==null)
			return false;
		if(root1.val!=root2.val)
			return false;
		
		return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
	}
}
