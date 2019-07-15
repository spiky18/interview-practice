package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderIterative {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> preOrder = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		if (root != null)
			stack.push(root);
		while (stack.size() > 0) {
			TreeNode node = stack.pop();
			preOrder.add(node.val);
			if (node.right != null)
				stack.push(node.right);
			if (node.left != null)
				stack.push(node.left);
		}
		return preOrder;
	}
	
	
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> postOrder = new ArrayList<>();
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		if (root != null)
			stack1.push(root);
		while (!stack1.isEmpty()) {
			TreeNode node=stack1.pop();
			stack2.add(node.val);
			if(node.left!=null){
				stack1.push(node.left);
			}
			if(node.right!=null){
				stack1.push(node.right);
			}
			
			
		}
		
		while(!stack2.isEmpty()){
			
			postOrder.add(stack2.pop());
			
		}
		
		return postOrder;
	}
	
}
