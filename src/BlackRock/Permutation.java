package BlackRock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
	
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list=new ArrayList<>();
		List<Integer> curr=new ArrayList<>();
		
		helper(nums,0,nums.length-1,list);
		
		return list;
	}

	private void helper(int[] nums, int l, int r, List<List<Integer>> list) {
		if(l==r){
			List<Integer> temp=new ArrayList();
			for(int i : nums)
				temp.add(i);
			list.add(temp);
			//return;
		}else{
			for(int i=l;i<=r;i++){
				swap(nums,l,i);
				helper(nums, l+1, r, list);
				swap(nums,l,i);
			}
		}
	
	}

	private void swap(int[] nums, int l, int i) {
		int temp=nums[l];
		nums[l]=nums[i];
		nums[i]=temp;
	}
	
	 public List<List<Integer>> subsets(int[] nums) {
		 List<List<Integer>> list=new ArrayList<>();
		 subsetHelper(nums, 0,nums.length,list);
		 
			return list;
		}

	private void subsetHelper(int[] nums, int l, int r, List<List<Integer>> list) {
		if(l==r){
			
		}
	}
	
	

}
