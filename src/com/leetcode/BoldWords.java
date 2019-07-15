package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoldWords {
	public String boldWords(String[] words, String S) {
		List<Interval> intervals = new ArrayList<>();
		for (String w : words) {
			index(w, S, intervals);
		}
		intervals=merge(intervals);
		StringBuilder sb = new StringBuilder(S);
		int changes=0;
		for(Interval i : intervals){
			sb.insert(i.start+changes,"<b>");
			sb.insert(i.end+changes+3,"</b>");
			changes+=7;
		}
		return sb.toString();
	}

	public void index(String w, String s, List<Interval> intervals) {
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			int temp = i;
			while (i<s.length() && j < w.length()) {
				if (s.charAt(i) == w.charAt(j)) {
					i++;
					j++;
				} else
					break;
			}
			if (j == w.length()) {
				intervals.add(new Interval(i-j, i));
			}
			i=temp;
			j=0;
		}
	}

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> mergedIntervals = new ArrayList<Interval>();
		if (intervals.isEmpty())
			return mergedIntervals;
		Collections.sort(intervals);
		mergedIntervals.add(intervals.get(0));
		int j = 0;
		// Iterator<Interval> itr=intervals.iterator();
		for (int i = 1; i < intervals.size(); i++) {
			Interval temp = mergedIntervals.get(j);
			Interval temp2 = intervals.get(i);
			if (temp.start == temp2.start) {
				temp.end = Math.max(temp.end, temp2.end);
			} else if (temp.end >= temp2.start)
				temp.end = Math.max(temp.end, temp2.end);
			else {
				mergedIntervals.add(temp2);
				j++;
			}
		}
		return mergedIntervals;

	}

	class Interval implements Comparable<Interval> {
		int start, end;

		public Interval(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public int compareTo(Interval o) {
			// TODO Auto-generated method stub
			return start - o.start;
		}

	}
	
	public static void main(String[] args) {
		BoldWords bw = new BoldWords();
		String[]  words = {"ab", "bc"};
		String S = "aabcd";
		System.out.println(bw.boldWords(words, S));
	}
}
