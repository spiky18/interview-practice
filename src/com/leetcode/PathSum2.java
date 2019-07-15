package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
	List<List<Integer>> finalList;

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		finalList=new ArrayList<>();
		List<Integer> list=new ArrayList<>();
		preOrder(root, sum, list);
		return finalList;
	}

	public void preOrder(TreeNode root, int sum, List<Integer> list) {
		if(root!=null){
		if (root.left == null && root.right == null && root.val != sum)
			return;
		if (root.left == null && root.right == null && root.val == sum)
			finalList.add(list);
			list.add(root.val);
			List<Integer> listr=new ArrayList<>(list);
			preOrder(root.left, sum - root.val, list);
			preOrder(root.right, sum - root.val, listr);
		}

	}
}
