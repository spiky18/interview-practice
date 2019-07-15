package com.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.SortedMap;
import java.util.TreeMap;

public class TopKFreq {
	public List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, temp> map = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		for (int i : nums) {
			temp obj = new temp(i);
			if (map.containsKey(i))
				obj = map.get(i);
			obj.freq++;
			map.put(i, obj);
		}
		PriorityQueue<temp> heap = new PriorityQueue<>();
		for (int i : map.keySet()) {
			heap.add(map.get(i));
		}
		while (k-- > 0)
			result.add(heap.remove().val);
		return result;
	}

	class temp implements Comparable<temp> {
		public int freq, val;

		temp(int v) {
			val = v;
			freq = 0;
		}

		@Override
		public int compareTo(temp o) {
			// TODO Auto-generated method stub
			return o.freq - this.freq;
		}
	}

	public List<Integer> topKFrequentII(int[] nums, int k) {
		List<Integer> result = new ArrayList<>();
		TreeMap<Integer, Integer> freqMap = new TreeMap<Integer, Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer arg0, Integer arg1) {
				// TODO Auto-generated method stub
				return arg1 - arg0;
			}
		});
		for(int i:nums){
			int freq=1;
			if(freqMap.containsKey(i))
				freq+=freqMap.get(i);
			freqMap.put(i, freq);
		}
		while(result.size()<k){
			result.addAll((Collection<? extends Integer>) freqMap.pollFirstEntry());
		}
		return result;
	}
}
