package com.leetcode;

import java.util.Stack;

public class SerializationDeserialization {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		preorder(root, sb);
		System.out.println(sb.toString());
		return "";
	}

	void preorder(TreeNode root, StringBuilder sb) {
		sb.append("(");
		if (root != null) {
			sb.append(root.val);
			preorder(root.left, sb);
			preorder(root.right, sb);
		} else {
			sb.append("n");
		}
		sb.append(")");
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		Stack<TreeNode> stack = new Stack<>();
		// stack.push(arg0)
		StringBuilder curr = new StringBuilder();
		for (int i = 0; i < data.length(); i++) {
			if (data.charAt(i) == '(') {
				if(curr.length()==0)
					continue;
				TreeNode node = null;
				if (!curr.toString().equals("n")) {
					node = new TreeNode(Integer.parseInt(curr.toString()));
				}
				stack.push(node);
				curr = new StringBuilder();
			} else if (data.charAt(i) == ')') {
				TreeNode node = null;
				stack.push(node);
				curr = new StringBuilder();
			} else {
				if (data.charAt(i) == 'n') {

					curr.append("n");
				} else {
					curr.append(data.charAt(i));
				}

			}
		}
		return null;
	}
}
