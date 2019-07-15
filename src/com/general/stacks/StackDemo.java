package com.general.stacks;

public class StackDemo {
	public static void main(String[] args){
		StackLinkedList stack=new StackLinkedList();
		//stack.displayStack();
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.displayStack();
		System.out.println("pop "+ stack.pop());
		stack.displayStack();
		String s;
		ValidityChecker v=new ValidityChecker();
		System.out.println("A+B "+v.isValid("A+B"));
		System.out.println("(A+B) "+v.isValid("(A+B)"));
		System.out.println("{(A+B)} "+v.isValid("{(A+B)}"));
		System.out.println("[{(A+B)}+C+D] "+v.isValid("[{(A+B)}+C+D]"));
		System.out.println("[{(A+B)}+C+D][ "+v.isValid("[{(A+B)}+C+D]["));
		System.out.println(" "+v.isValid("([)]"));
		//System.out.println("] "+v.isValid("]"));
	}
}
