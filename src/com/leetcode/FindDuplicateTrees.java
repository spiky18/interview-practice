package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindDuplicateTrees {
	List<TreeNode> list;
	static final Comparator<TreeNode> comparator = new Comparator<TreeNode>() {
		public int compare(TreeNode e1, TreeNode e2) {
			return e1.val - e2.val + e1.left.val - e2.left.val + e1.right.val - e2.right.val;
		}
	};
	
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		list=new ArrayList<>();
		preOrder(root);
		Collections.sort(list,comparator);
		List<TreeNode> res=new ArrayList<>();
		for(int i=1;i<list.size();i++){
			TreeNode prev=list.get(i-1),curr=list.get(i);
			if(prev.val==curr.val && prev.left.val==curr.left.val && prev.right.val==curr.right.val)
				res.add(curr);
			
		}
		return res;
        
    }
	
	public void preOrder(TreeNode root){
		if(root!=null){
			list.add(root);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
}
