package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class KdiffPairs {
	public int findPairs(int[] nums, int k) {
		int cnt=0;
		if(k!=0){
		Set<Integer> set=new HashSet<>();
		
		for(int i : nums)
			set.add(i);
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()){
			int i=it.next();
			if(set.contains(i+k))
				cnt++;
			if(set.contains(i-k))
				cnt++;
			it.remove();
		}
		}
		else
		{
			Map<Integer,Integer> map=new HashMap<>();
			for(int i : nums)
				{	int freq=1;
					if(map.containsKey(i)){
						freq+=map.get(i);
					}
					map.put(i, freq);
				}
			for(Map.Entry<Integer, Integer> entrySet : map.entrySet()){
				if(entrySet.getValue()>1)
					cnt++;
			}
		}
		
		return cnt;
	}
	
}
