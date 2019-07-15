package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result=new ArrayList<>();
		List<Integer> prev=new LinkedList<>();
		prev.add(1);
		result.add(prev);
		//prev=new LinkedList<>(prev);
		//prev.add(1);
		int i=2;
		//result.add(prev);
		while(i<=numRows){
			List<Integer> temp=new LinkedList<>();
			temp.add(1);
			int j=0,k=1;
			while(k<prev.size()){
				temp.add(prev.get(j)+prev.get(k));
				j++;
				k++;
			}
			temp.add(1);
			result.add(temp);
			i++;
			prev=temp;
		}
		return result;
	}
	
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list=new LinkedList<>();
        list.add(1);
        int i=0;
        while(i<rowIndex){
           int j=0,k=1;
            while(k<list.size()){
                list.set(j,(list.get(j)+list.get(k)));
                j++;
                k++;
            }
            list.add(0,1);
            i++;
        }
        
        return list;
    }
    
    public static void main(String[] args) {
	PascalTriangle obj=new PascalTriangle();
	obj.getRow(2);
	}
}
