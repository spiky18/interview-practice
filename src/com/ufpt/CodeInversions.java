package com.ufpt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class CodeInversions {
	public int codeInversons(int[] nums) {
		int cnt = 0;
		int[] arr = new int[nums.length];
		mergeSort(nums, 0, nums.length, arr);
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i] + ",");
		return cnt;
	}

	public void mergeSort(int[] nums, int l, int r, int[] dummy) {
		if (l < r) {
			int mid = (l + r) / 2;
			mergeSort(nums, l, mid, dummy);
			mergeSort(nums, mid + 1, r, dummy);
			merge(nums, l, mid, r, dummy);
		}
	}

	private void merge(int[] nums, int l, int mid, int r, int[] dummy) {
		int i = l, j = mid + 1, k = l;
		while (k <= r) {
			if (i <= mid && (nums[i] <= nums[j])) {
				dummy[k] = nums[i];
				i++;
			} else {
				dummy[k] = nums[j];
				j++;
			}
			k++;
		}

	}

	public int[] sortByFreq(int[] nums) {
		LinkedHashMap<Integer, Integer> map1 = new LinkedHashMap<>();
		for (int i : nums) {
			int val = 1;
			if (map1.containsKey(i))
				val += map1.get(i);
			map1.put(i, val);
		}
		TreeMap<Integer, List<Integer>> map2 = new TreeMap<>(myMap);
		for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
			List<Integer> list = new ArrayList();
			if (map2.containsKey(entry.getValue()))
				list = map2.get(entry.getValue());
			list.add(entry.getKey());
			map2.put(entry.getValue(), list);
		}

		int i = 0;
		for (int k : map2.keySet()) {
			for (int n : map2.get(k)) {
				int tmp = 0;
				while (tmp < k) {
					nums[i] = n;
					i++;
					tmp++;
				}
			}
		}

		return nums;
	}

	SortedMap<Integer, List<Integer>> myMap = new TreeMap<Integer, List<Integer>>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2.intValue() - o1.intValue();
		}
	});

	public static void main(String[] args) {
		int[] n = { 2, 5, 2, 8, 5, 6, 8, 8 };
		CodeInversions obj = new CodeInversions();
		n = obj.sortByFreq(n);
		for (int i : n)
			System.out.println(i + ",");
	}

}
