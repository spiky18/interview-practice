package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryBottomLeftVal {
	public int findBottomLeftValue(TreeNode root) {
		if(root!=null){
			Queue<TreeNode> queue=new LinkedList<>();
			queue.add(root);
			queue.add(null);
			int leftmost=root.val;
			while(!queue.isEmpty()){
				TreeNode peek=queue.poll();
				if(peek!=null){
					if(peek.left!=null)
						queue.add(peek.left);
					if(peek.right!=null)
						queue.add(peek.right);
					
				}else{
					if(!queue.isEmpty())
						{
							leftmost=queue.peek().val;
							queue.add(null);
						}
					
				}
				
			}
			return leftmost;
		}
		return 0;
		
	}
}
