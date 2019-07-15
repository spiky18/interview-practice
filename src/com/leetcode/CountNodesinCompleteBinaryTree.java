package com.leetcode;

public class CountNodesinCompleteBinaryTree {
	int bottomNodes = 0;
	boolean stop = false;

	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		int h = 0;
		TreeNode node = root;
		while (node != null) {
			h++;
			node = node.left;
		}
		postOrder(root, 0, h);
		return (1 << (h - 1)) + bottomNodes - 1;
	}

	public void postOrder(TreeNode root, int currH, int h) {
		if (root != null && !stop) {
			currH++;
			if (root.left != null)
				postOrder(root.left, currH, h);
			if (root.right != null)
				postOrder(root.right, currH, h);

			if (currH == h)
				bottomNodes++;
			if (currH == h - 1 && root.right == null) {
				stop = true;
				return;
			}
			currH--;
		}
	}
	
		public int countNodesII(TreeNode root){
			int leftHeight=lefttHeight(root);
			int righHeight=rightHeight(root);
			if(leftHeight==righHeight)
				return 1<<leftHeight;
			return 1+countNodesII(root.left)+countNodesII(root.right);
		}
		
		public int rightHeight(TreeNode root){
			int h=0;
			while(root!=null)
			{
				h++;
				root=root.right;
			}
			return h;
		}
		
		public int lefttHeight(TreeNode root){
			int h=0;
			while(root!=null)
			{
				h++;
				root=root.left;
			}
			return h;
		}
}
