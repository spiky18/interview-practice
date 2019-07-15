package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOp {

	public List<String> addOperators(String num, int target) {
		List<String> result = new ArrayList<String>();
		helper(result,num,target,"",0,0,0);
		return result;
	}

	private void helper(List<String> result, String num, int target, String path, int pos, long value, long prev) {
		if(pos==num.length()){
			if(value==target)
				result.add(path);
			return;
		}
		for (int i = pos; i < num.length(); i++) {
			if(i>pos && num.charAt(pos)=='0'){
				break;
			}
			
			long curr=Long.parseLong(num.substring(pos, i+1));
			if(pos==0){
				helper(result, num, target, path+curr, i+1, value+curr, curr);
				
			}else{
				helper(result, num, target, path+"+"+curr, i+1, value+curr, curr);
				
				helper(result, num, target, path+"-"+curr, i+1, value-curr, -curr);
				
				helper(result, num, target, path+"*"+curr, i+1, value-prev+prev*curr, prev*curr);
				
			}
			
			
		}
		
		
	}

}
