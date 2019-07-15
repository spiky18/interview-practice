package com.bloomberg.fall16;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MinSets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		Map<Character,Set<Integer>> resultMap=new TreeMap<>();
		Set<Character> openSets=new HashSet<>();
		int n=in.nextInt();
		in.nextLine();
		for(int i=1;i<=n;i++){
			String s=in.nextLine();
			System.out.println(s);
			if(s.charAt(0)=='^'){
				openSets.add(s.charAt(1));
				Set<Integer> numSet=new TreeSet<>();
				if(resultMap.containsKey(s.charAt(1))){
					numSet=resultMap.get(s.charAt(1));
				}
				resultMap.put(s.charAt(1), numSet);
			}
			else if(s.charAt(0)=='/'){
				if(openSets.contains(s.charAt(1)))
					openSets.remove(s.charAt(1));
			}
			else{
				int num=Integer.parseInt(s);
				for(char ch : openSets){
					Set<Integer> numSet=resultMap.get(ch);
					numSet.add(num);
					resultMap.put(ch, numSet);
				}
			}
		}
		
		for(char ch : resultMap.keySet() ){
			System.out.print(ch);
			for( int i : resultMap.get(ch)){
				System.out.print(" ");
				System.out.print(i);
			}
			System.out.println();
		}
	}
	
	

}
