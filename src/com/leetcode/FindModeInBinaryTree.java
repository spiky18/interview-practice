package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindModeInBinaryTree {
	public Map<Integer,Integer> map=new HashMap<>();
	int max=0;
	public int[] findMode(TreeNode root) {
       inOrder(root);
       List<Integer> list =new ArrayList<Integer>();
       for(int i : map.keySet()){
    	   if(map.get(i)==max)
    		   list.add(i);
       }
       int[] arr=new int[list.size()];
       int i=0;
       while(i<list.size()){
    	   arr[i]=list.get(i);
    	   i++;
       }
       return arr;
       
    }
	
	public void inOrder(TreeNode root){
		if(root!=null){
			inOrder(root.left);
			if(map.containsKey(root.val)){
				int temp=map.get(root.val)+1;
				map.put(root.val, temp);
				max=Math.max(max, temp);
			}
			else{
				map.put(root.val, 1);
				max=Math.max(max, 1);
				}
			inOrder(root.right);
		}
		
	}
}
