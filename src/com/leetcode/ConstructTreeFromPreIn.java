package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPreIn {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		Map<Integer,Integer> inMap=createMap(inorder);
		if(inorder.length==0 || preorder.length==0 || preorder.length!=inorder.length)
			return null;
		return constructHelper(preorder, 0,0, preorder.length-1, inMap);

	}
	
	public Map<Integer,Integer> createMap(int[] arr){
		Map<Integer,Integer> arrMap=new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++)
			arrMap.put(arr[i], i);
		return arrMap;
	}
	
	public TreeNode constructHelper(int[] preOrder,int preIndex,int start,int end,Map<Integer,Integer> inMap){
		if(start==end)
			return new TreeNode(preOrder[start]);
		else if(start>end)
			return null;
		else
		{
			TreeNode root=new TreeNode(preOrder[start]);
			int temp=inMap.get(preOrder[start]);
			int leftsize=temp-start;
			root.left=constructHelper(preOrder, preIndex+1,start+1, temp-1, inMap);
			root.right=constructHelper(preOrder,preIndex+leftsize+1
					,temp+1, end,inMap);		
			return root;
		}
	}
	
	
	
	public static void main(String[] args) {
		int[] pre={1,2,3};
		int[] in={2,3,1};
		ConstructTreeFromPreIn obj=new ConstructTreeFromPreIn();
		TreeNode root=obj.buildTree(pre, in);
		System.out.println(root.val);
	}
}
