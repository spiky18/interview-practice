package com.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RandomizedSet {
	Map<Integer,Integer> map;
	List<Integer> list;
	 /** Initialize your data structure here. */
    public RandomizedSet() {
    	map=new HashMap<>();
    	list=new LinkedList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
        	return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
        	return false;
        //list.rem
        //list.set(, element)
        list.remove(map.get(val).intValue());//to remove index use int value	
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int rand=(int)(Math.random()*map.size());
        return list.get(rand);
    }
    
    /*class Node{
    	int val,index;
    	Node next;
    	Node(int value,int indx){
    		val=value;
    		index=indx;
    		next=null;
    	}
    }*/ 
}
