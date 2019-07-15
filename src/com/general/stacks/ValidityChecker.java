package com.general.stacks;

import java.util.Stack;

public class ValidityChecker {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		if(!s.contains("[") || !s.contains("{") || !s.contains("(") || !s.contains(")") || !s.contains("}") || !s.contains("]"))
			return true;
		for (char ch : s.toCharArray()) {
			if (ch == ')') {
				// System.out.println("in pop");
				char temp = stack.pop();
				// System.out.println(temp);
				while (temp != '(') {
					temp = stack.pop();
					// System.out.println(temp);
				}
			} else if (ch == '}') {
				// System.out.println("in pop");
				char temp = stack.pop();
				// System.out.println(temp);
				while (temp != '{') {
					temp = stack.pop();
					// System.out.println(temp);
				}
			} else if (ch == ']') {
				// System.out.println("in pop");
				char temp = stack.pop();
				// System.out.println(temp);
				while (temp != '[') {
					temp = stack.pop();
					// System.out.println(temp);
				}
			} else {
				stack.push(ch);
				//System.out.println(ch);
			}
		}

		if (stack.isEmpty())
			return true;
		
		return false;
	}
}
