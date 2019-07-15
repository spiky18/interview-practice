package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderIterative {
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> inOrder=new ArrayList<Integer>(); 
		Stack<TreeNode> stack=new Stack<>();
		while(root!=null){
			stack.push(root);
			root=root.left;
		}
		while(stack.size()>0){
			TreeNode node=stack.pop();
			inOrder.add(node.val);
			if(node.right!=null){
				node=node.right;
			while(node!=null)
			{
				stack.push(node);
				node=node.left;
			}
			}
		}
		
		return inOrder;
	}
}
