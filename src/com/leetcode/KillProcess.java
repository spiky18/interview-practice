package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KillProcess {
	
	public static void main(String[] args) {
		List<Integer> pid=new ArrayList<Integer>();
		List<Integer> ppid=new ArrayList<Integer>();
	}
	
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> list=new ArrayList<Integer>();
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(kill);
        while(!queue.isEmpty()){
        int temp=queue.poll();
        list.add(temp);
        for(int i=0;i<ppid.size();i++){
        	if(ppid.get(i)==temp)
        		queue.add(pid.get(i));
        }
        }
        return list;
    }

}
