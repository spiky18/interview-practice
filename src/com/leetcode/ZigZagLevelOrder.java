package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrder {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list= new ArrayList<>();
        if(root==null)
            return list;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean useStack=false;
        ArrayList<Integer> container=new ArrayList<>();
        while(!queue.isEmpty()){
        	TreeNode temp=queue.poll();
        	if(temp!=null){
        		container.add(temp.val);
        		if(temp.left!=null)
        			queue.add(temp.left);
        		if(temp.right!=null)
        			queue.add(temp.right);
        	}
        	else{
        		ArrayList<Integer> adder=new ArrayList<>(container);
        		container=new ArrayList<>();
        		if(useStack)
        			Collections.reverse(adder);
        		list.add(adder);
        		useStack=!useStack;
        		if(!queue.isEmpty())
        			queue.add(null);
        	}
        }
        return list;
    }
}
