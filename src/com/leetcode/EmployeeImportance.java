package com.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class EmployeeImportance {
	public int getImportance(List<Employee> employees, int id) {
		Map<Integer,Employee> map=new HashMap<>();
		for(Employee e : employees)
			map.put(e.id, e);
		Employee start=map.get(id);
		Queue<Employee> queue=new LinkedList<>();
		queue.add(start);
		int total=0;
		while(!queue.isEmpty()){
			Employee e=queue.poll();
			total+=e.importance;
			for(int i : e.subordinates){
				queue.add(map.get(i));
			}
		}
		return total;
	}
	class Employee{
		public int id,importance;
		public List<Integer> subordinates;
		
	}

	
	public static void main(String[] args) {
		
	}
}
