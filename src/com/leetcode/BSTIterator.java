package com.leetcode;

import java.util.PriorityQueue;
import java.util.Stack;

public class BSTIterator {

	public PriorityQueue<Integer> minHeap;

	public BSTIterator(TreeNode root) {
		minHeap = new PriorityQueue<>();
		Stack<TreeNode> stack = new Stack<>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
		while(stack.size()>0){
			TreeNode node=stack.pop();
			minHeap.add(node.val);
			if(node.right!=null){
				node=node.right;
			while(node!=null)
			{
				stack.push(node);
				node=node.left;
			}
		}
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !minHeap.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		return minHeap.poll();
	}
}
