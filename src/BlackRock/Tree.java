package BlackRock;

import java.util.HashMap;
import java.util.Map;

public class Tree {
	public int x;
	public Tree l;
	public Tree r;

	
	int maxDistinct = 0;

	public int solution(Tree T) {
		Map<Integer, Integer> map = new HashMap<>();
		preorder(T, map);
		return maxDistinct;
	}

	public void preorder(Tree root, Map<Integer, Integer> map) {
		if (root == null)
			return;
		int freq = 0;
		if (map.containsKey(root.x))
			freq = map.get(root.x);
		map.put(root.x, freq + 1);
		maxDistinct = Math.max(maxDistinct, map.size());
		preorder(root.l, map);
		preorder(root.r, map);
		// decrement frequency from map
		freq = map.get(root.x) - 1;
		if (freq == 0)
			map.remove(root.x);
		else
			map.put(root.x, freq);
	}
	
	
	
}
