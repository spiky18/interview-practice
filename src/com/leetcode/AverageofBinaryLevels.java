package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofBinaryLevels {
	 public List<Double> averageOfLevels(TreeNode root) {
	        List<Double> list=new ArrayList<>();
	        if(root==null)
	            return list;
	        Queue<TreeNode> queue=new LinkedList<>();
	        queue.add(root);
	        queue.add(null);
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
	        		long sum=0l;
	        		for(int i : container)
	        			sum+=i;
	        		double avg=sum/container.size();
	        		
	        		container=new ArrayList<>();

	        		list.add(avg);
	        		if(!queue.isEmpty())
	        			queue.add(null);
	        	}
	        }
	        
	        
	        return list;
	    }
}
