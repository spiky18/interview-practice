package com.hr.cc;

import java.util.HashMap;
import java.util.Scanner;

public class HappyLadyBugs {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int Q = in.nextInt();
		int[] nArr = new int[Q];
		String[] res=new String[Q];
		String[] bArr = new String[Q];
		for (int a0 = 0; a0 < Q; a0++) {
			nArr[a0] = in.nextInt();
			bArr[a0] = in.next();
			res[a0]=checkHappy(bArr[a0]);
		}
		for (int a0 = 0; a0 < Q; a0++) {
			System.out.println(res[a0]);
		}

	}

	public static String checkHappy(String str){
		String res="";
		if (happy(str)) {
			if (str.contains("_"))
				res="YES";
			else {
				if(checkOrder(str))
					res="YES";
				else
					res="NO";

			}

		} else {
			res="NO";
		}		
		return res;
	}
	public static boolean happy(String str) {
		boolean happy = true;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c != '_') {
				Integer val = map.get(new Character(c));
				if (val != null) {
					map.put(c, new Integer(val + 1));
				} else {
					map.put(c, 1);
				}
			}
		}
		for (int key : map.values()) {
			if (key == 1) {
				happy = false;
				break;
			}
		}
		return happy;

	}

	public static boolean checkOrder(String str) {
		char[] x = str.toCharArray();
		char prev = x[0];
		int count = 0;
		for (int i = 0; i < str.length() - 1; i++) {
			String s = str.substring(i + 1);
			if (prev != x[i])
				count = 0;
			System.out.println(s);
			int j = s.indexOf(x[i]);
			if (j >= 0) {
				count++;
			}
			prev = x[i];
		}
		if(count>0)
			return true;
		return false;
	}
}
