package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Keyboard_Row {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String[] findWords(String[] words) {
        Set<Character> row1=new HashSet<Character>();
        Set<Character> row2=new HashSet<Character>();
        Set<Character> row3=new HashSet<Character>();
        row1.add('q');
        row1.add('w');
        row1.add('e');
        row1.add('r');
        row1.add('t');
        row1.add('y');
        row1.add('y');
        row1.add('u');
        row1.add('i');
        row1.add('o');
        row1.add('p');
        row2.add('a');
        row2.add('s');
        row2.add('d');
        row2.add('f');
        row2.add('g');
        row2.add('h');
        row2.add('j');
        row2.add('k');
        row2.add('l');
        row3.add('z');
        row3.add('x');
        row3.add('c');
        row3.add('v');
        row3.add('b');
        row3.add('n');
        row3.add('m');
        ArrayList<String> wrd=new ArrayList<>();
        for(String s : words){
        	boolean r1=isSameRow(row1, s);
        	boolean r2=false;
        	boolean r3=false;
        	if(!r1)
        	{
        		r2=isSameRow(row2, s);
        		if(!r2)
        			r3=isSameRow(row3, s);
        	}
        	if(r1 || r2 || r3)
        		wrd.add(s);
        }
        return (String[]) wrd.toArray(new String[wrd.size()]);
    }
	
	public boolean isSameRow(Set row,String s){
		for(char ch : s.toCharArray()){
			if(!row.contains(ch))
				return false;
		}
		return true;
	}
}
