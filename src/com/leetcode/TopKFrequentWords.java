package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
	public List<String> topKFrequent(String[] words, int k) {
		List<String> list=new ArrayList<>();
		Map<String, Integer> freqMap=new HashMap<>();
		for(String w : words){
			int frq=1;
			if(freqMap.containsKey(w)){
				frq+=freqMap.get(w);
			}
			freqMap.put(w,frq);
		}
		PriorityQueue<String> pq=new PriorityQueue<>(
				(w1,w2)->freqMap.get(w1)!=freqMap.get(w2)?
						(freqMap.get(w2)-freqMap.get(w1)):w2.compareTo(w1)
				);
		PriorityQueue<StringCount> queue=new PriorityQueue<>();
		for(String w : freqMap.keySet() ){
			queue.add(new StringCount(freqMap.get(w), w));
		}
		while(k-->0){
			list.add(queue.poll().str);
		}
		return list;
	}
	
	class StringCount implements Comparable<StringCount>{
		int cnt;
		String str;
		
		public StringCount(int c,String s){
			cnt=c;
			str=s;
		}

		@Override
		public int compareTo(StringCount o) {
			// TODO Auto-generated method stub
			return o.cnt-cnt;
		}
	}

}
