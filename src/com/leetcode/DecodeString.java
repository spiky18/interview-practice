package com.leetcode;

import java.util.Stack;

public class DecodeString {
	/*
	 * public static String decodeString(String s) { Stack<Integer> stkInt=new
	 * Stack<>(); Stack<StringBuilder> stksb=new Stack<>(); StringBuilder sb=new
	 * StringBuilder(); StringBuilder num=new StringBuilder(); StringBuilder
	 * res=new StringBuilder(); for(int i=0;i<s.length();i++){ char
	 * ch=s.charAt(i); if(Character.isDigit(ch)){ num.append(ch);
	 * if(sb.length()>0 && s.charAt(i-1)==']'){ stksb.push(sb); } else
	 * if(sb.length()>0) res.append(sb); sb=new StringBuilder(); } else
	 * if(ch=='['){ stkInt.push(Integer.parseInt(num.toString())); num=new
	 * StringBuilder(); if(sb.length()>0){ stksb.push(sb); sb=new
	 * StringBuilder(); } } else if(ch==']'|| i==s.length()-1){ if(ch!=']')
	 * sb.append(ch); int tmp=0; if(!stkInt.isEmpty()) tmp=stkInt.pop();
	 * if(sb.length()==0 && !stksb.isEmpty()) sb=stksb.pop(); String
	 * z=sb.toString(); for(int j=1;j<tmp;j++) sb=sb.append(z);
	 * if(!stksb.isEmpty()) { StringBuilder tmp2=stksb.pop(); tmp2.append(sb);
	 * stksb.push(tmp2); } else{ res.append(sb); } sb=new StringBuilder(); }
	 * else{ sb=sb.append(ch); //System.out.println(sb.toString()); //if(stk) }
	 * 
	 * } return res.toString(); }
	 */
	public static String decodeString(String s) {
		StringBuilder num = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stkInt = new Stack<>();
		Stack<StringBuilder> stkStr = new Stack<>();
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				if (num.length() == 0) {
					stkStr.push(sb);
					sb = new StringBuilder();
				}
				num = num.append(ch);
				// if(sb.length()>0){

			} else if (ch == '[') {
				stkInt.push(Integer.parseInt(num.toString()));
				num = new StringBuilder();
			} else if (ch == ']') {
				int tmp = stkInt.pop();
				String suffix = sb.toString();
				for (int j = 1; j < tmp; j++)
					sb.append(suffix);
				if (stkInt.isEmpty()) {
					res.append(sb);
					sb = new StringBuilder();
				} else {
					StringBuilder sbtmp = stkStr.pop();
					sbtmp.append(sb);
					sb = sbtmp;
				}
			} else {

				sb.append(ch);
				if (stkInt.isEmpty()) {
					res.append(sb);
					sb = new StringBuilder();
				}
			}

		}
		return res.toString();
	}

	public static void main(String[] args) {
		System.out.println(decodeString("3[a]2[bc]"));
		System.out.println(decodeString("3[a2[c]]"));
		System.out.println(decodeString("rf3[ab]"));
		System.out.println(decodeString("2[1[abc]ef3[cd]]"));
	}
}
