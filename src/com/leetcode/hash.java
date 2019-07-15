package com.leetcode;

import java.util.HashMap;

public class hash {
     public static void main(String[] args) {
    	 Integer x; //object
    	 int y; //primitive data type 
		HashMap<Integer,String> map=new HashMap<>();
		map.put(1, "chandra");
		map.put(1415, "Kilmington");
		System.out.println(map.get(1));
		map.remove(1);
	}
}
