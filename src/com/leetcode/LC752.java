package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC752 {

		public int openLock(String[] deadends, String target) {
			Set<String> deadEndSet = new HashSet<String>(Arrays.asList(deadends));
			Queue<String> queue = new LinkedList<>();
			queue.add("0000");
			Set<String> visited = new HashSet<>();
			visited.add("0000");
			if(target.equals("0000") && !deadEndSet.contains("0000"))
				return 0;
	        if(deadEndSet.contains(target) || deadEndSet.contains("0000"))
	            return -1;
			int dist=0,poppededNode=0,nodesInNextLevel=0,currLevel=1;
			while (!queue.isEmpty()) {
				String s = queue.poll();
				poppededNode++;
				for (int i = 0; i < 4; i++) {
					StringBuilder sb = new StringBuilder(s);
					int nextCh = ((s.charAt(i) - '0') + 1) % 10;
					sb.replace(i, i + 1, "" + nextCh);
					if(sb.toString().equals(target))
						return dist+1;
					if (!visited.contains(sb.toString()) && !deadEndSet.contains(sb.toString())) {
						queue.add(sb.toString());
						visited.add(sb.toString());
						nodesInNextLevel++;
					}
					nextCh = ((s.charAt(i) - '0') +9) % 10;
						
					sb.replace(i, i + 1, "" + nextCh);
					if(sb.toString().equals(target))
						return dist+1;
					if (!visited.contains(sb.toString()) && !deadEndSet.contains(sb.toString())) {
						queue.add(sb.toString());
						visited.add(sb.toString());
						nodesInNextLevel++;
					}
				}
				if(poppededNode==currLevel){
					dist++;
					currLevel=nodesInNextLevel;
					nodesInNextLevel=0;
					poppededNode=0;
				}
			}
			return -1;
		}
		
		public static void main(String[] args) {
			String[] deadends={"8887","8889","8878","8898","8788","8988","7888","9888"};
			LC752 obj=new LC752();
			System.out.println(obj.openLock(deadends, "8888"));
			
		}

}
