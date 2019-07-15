package com.leetcode;

public class BSTDelete {
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)
			return root;
		if (root.val > key)
			root.left = deleteNode(root.left, key);
		else if (root.val < key)
			root.right = deleteNode(root.right, key);
		else {
			if(root.left==null)
				return root.right;
			if(root.right==null)
				return root.left;
			root.val=getMax(root.left);
			root.left=deleteNode(root.left, root.val);
		}

		return root;
	}

	private int getMax(TreeNode root) {
		// TODO Auto-generated method stub
		while(root.right!=null)
			root=root.right;
		return root.val;
	}

}
