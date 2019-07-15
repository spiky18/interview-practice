package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeIterativePostOrder {
	public List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		List<Integer> res = new ArrayList<>();
		if (root != null)
			s1.push(root);
		while (!s1.isEmpty()) {
			TreeNode temp = s1.pop();
			s2.push(temp);
			if (temp.left != null)
				s1.push(temp.left);
			if (temp.right != null)
				s1.push(temp.right);
		}
		while (!s2.isEmpty())
			res.add(s2.pop().val);
		return res;
	}
}
