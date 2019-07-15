package com.leetcode;

public class SumRootToLeafNumbers {
	int sum = 0;

	public int sumNumbers(TreeNode root) {
		StringBuilder sb=new StringBuilder();
		preOrder(root, sb);
		return sum;
	}

	public void preOrder(TreeNode root,StringBuilder sb){
		if(root!=null){
		if(root.left==null && root.right==null)
			sum+=Integer.parseInt(sb.toString());
		sb.append(root.val);
		preOrder(root.left, sb);
		preOrder(root.right, sb);
	}
	}
}
