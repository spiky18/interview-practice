package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree {
	public TreeNode addOneRow(TreeNode root, int v, int d) {
		if (d == 1) {
			TreeNode node = new TreeNode(v);
			node.left = root;
			return node;
		}
		int currLevel = 1;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {
			TreeNode curr = q.poll();
			if (curr != null) {
				if (currLevel != d - 1) {
					if (curr.left != null)
						q.add(curr.left);
					if (curr.right != null)
						q.add(curr.right);
				} else {
					TreeNode nodel = new TreeNode(v);
					TreeNode noder = new TreeNode(v);
					TreeNode left = curr.left;
					TreeNode right = curr.right;
					curr.left = nodel;
					curr.right = noder;
					nodel.left = left;
					noder.right = right;
				}
			} else {
				currLevel++;
				if (currLevel == d)
					break;
				if (!q.isEmpty())
					q.add(null);
			}

		}

		return root;
	}
}
