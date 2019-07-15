import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.leetcode.TreeNode;

public class LC273 {
	public String numberToWords(int num) {
		StringBuilder sb=new StringBuilder();
		helper(num, sb);
		return sb.toString().trim();
	}

	public void helper(int num,StringBuilder sb){
		if(num==0){
			sb.toString().trim();
			return;
		}
			
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");
		map.put(6, "Six");
		map.put(7, "Seven");
		map.put(8, "Eight");
		map.put(9, "Nine");
		map.put(10, "Ten");
		map.put(11, "Eleven");
		map.put(12, "Twelve");
		map.put(13, "Thirteen");
		map.put(14, "Fourteen");
		map.put(15, "Fifteen");
		map.put(16, "Sixteen");
		map.put(17, "Seventeen");
		map.put(18, "Eighteen");
		map.put(19, "Nineteen");
		map.put(20, "Twenty");
		map.put(30, "Thirty");
		map.put(40, "Forty");
		map.put(50, "Fifty");
		map.put(60, "Sixty");
		map.put(70, "Seventy");
		map.put(80, "Eighty");
		map.put(90, "Ninety");
		map.put(100, "Hundred");
		map.put(1000, "Thousand");
		map.put(1000000, "Million");
		map.put(1000000000, "Billion");
		if(num<=20) 
			sb.append(map.get(num));
		else if(num<100){
			sb.append(map.get((num/10)*10));
			sb.append(" ");
			helper(num%10, sb);
		}else if(num<1000){
			helper(num/100, sb);
			sb.append(" ");
			sb.append(map.get(100));
			sb.append(" ");
			helper(num%100, sb);
		}else if(num<1000000){
			helper(num/1000, sb);
			sb.append(" ");
			sb.append(map.get(1000));
			sb.append(" ");
			helper(num%1000, sb);
		}else if(num<1000000000){
			helper(num/1000000, sb);
			sb.append(" ");
			sb.append(map.get(1000000));
			sb.append(" ");
			helper(num%1000000, sb);
		}else{
			helper(num/1000000000, sb);
			sb.append(" ");
			sb.append(map.get(1000000000));
			sb.append(" ");
			helper(num%1000000000, sb);
		}
		
		
	}
	
	public static void main(String[] args) {
		LC273 obj=new LC273();
		System.out.println(obj.numberToWords(1234567));
		
	}
	
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> list=new ArrayList<>();
		Map<Integer,List<Integer>> map=new TreeMap<>();
		help(root,map,0);
		for(int l : map.keySet()){
			list.add(map.get(l));
		}
			
		return list;
	}

	public void help(TreeNode root,Map<Integer,List<Integer>> map,int level){
		if(root==null)
			return;
		List<Integer> list=map.getOrDefault(level, new ArrayList<>());
		list.add(root.val);
		map.put(level, list);
		help(root.left,map,level-1);
		help(root.right,map,level+1);
	}
	
}
