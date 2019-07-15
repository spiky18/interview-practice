package com.leetcode.topinterviewquestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCombinations {

	public List<String> letterCombinations(String digits) {
		HashMap<Integer, List<StringBuilder>> map = new HashMap<>();
		String letters = "abcdefghijklmnopqrstuvwxyz";
		int j = 0;
		for (int i = 2; i < 10; i++) {
			List<StringBuilder> list = new ArrayList<>();
			list.add(new StringBuilder(letters.substring(j, j + 1)));
			j++;
			list.add(new StringBuilder(letters.substring(j, j + 1)));
			j++;
			list.add(new StringBuilder(letters.substring(j, j + 1)));
			j++;
			if (i == 7 || i == 9) {
				list.add(new StringBuilder(letters.substring(j, j + 1)));
				j++;
			}
			map.put(i, list);
		}
		Queue<StringBuilder> queue=new LinkedList<>(map.get(digits.charAt(0)-'0'));
		for(int i=1;i<digits.length();i++){
			List<StringBuilder> list=map.get(digits.charAt(i)-'0');
			j=queue.size();
			//for(StringBuilder sb : queue){
			while(j-->0){
				StringBuilder temp=queue.poll();
				for(StringBuilder b: list){
					queue.add( new StringBuilder(temp).append(b));
				}
			}
		}
		List<String> result=new ArrayList<>();
		for(StringBuilder sb : queue){
			result.add(sb.toString());
			}
		return result;
	}

	public static void main(String[] args) {
		LetterCombinations obj = new LetterCombinations();
		obj.letterCombinations("");
	}
}
