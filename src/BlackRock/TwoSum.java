package BlackRock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {
	// ask questions about 1. duplicates 2. order of result
	
	public static void main(String[] args) {
		int[] arr={5,5,5};
		
		twoSum(arr, 10);

	}
	
	public static List<int[]> twoSum(int[] nums,int target){
		List<int[]> pairs=new ArrayList<int[]>();
		HashMap<Integer,Integer> map=new HashMap<>();
		
		for(int i : nums){
			if(map.containsKey(i)){
				pairs.add(new int[] {map.get(i),i});
			}else{
				map.put(target-i, i);
			}
			
		}
		pairs.forEach(i->System.out.println(Arrays.toString(i)));
		return pairs;
		
	}

}
