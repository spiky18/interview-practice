package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list=new ArrayList<>();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i]=i+1;
		//permutations(arr, 0, k, 0, res);
		combineHelper(arr, list, res, k, 0);
		return res;
	}
	
	public void combineHelper(int[] nums,List<Integer> list,List<List<Integer>> result,int k,int i){
		if(list.size()==k){
			result.add(new ArrayList<Integer>(list));
            //list.remove(k-1);
            //System.out.print(list.get(0));
			return;
		}
		
		for(;i<nums.length;i++){
			list.add(nums[i]);
			combineHelper(nums, list, result, k, i+1);
			list.remove(list.size()-1);
		}
		
		//for()
	}
	
	

	public void permutations(int[] arr, int l, int k, int size, List<List<Integer>> res) {
		if (size >= k || l >= arr.length) {
			if (size == k) {
				System.out.println("here");
				List<Integer> list = new ArrayList<>();
				for (int i = l; i < l + k; i++){
					System.out.print(arr[i]+" ");
					list.add(arr[i]);
					}
				res.add(list);
				System.out.println("size "+res.size());
			}
			return;
		}
		for (int i = l; i < arr.length; i++) {
			swap(arr, l, i);
			permutations(arr, l + 1, k, size + 1, res);
			swap(arr, l, i);
		}
	}

	public void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void main(String[] args) {
		Combinations obj=new Combinations();
		obj.combine(4, 2);
	}
	
	public static void main(){
		System.out.println("test");
		//return 0;
	}
}
