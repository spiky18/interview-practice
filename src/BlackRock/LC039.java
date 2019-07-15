package BlackRock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC039 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<>();
		helper(candidates, target, 0, 0, new ArrayList<>(), list);
		return list;
	}

	public void helper(int[] candidates, int target, int currSum, int currIndx, List<Integer> currList,
			List<List<Integer>> list) {
		if (currSum >= target) {
			if (currSum == target)
				list.add(new ArrayList<>(currList));
			return;
		}
		for (int i = currIndx; i < candidates.length; i++) {
			currList.add(candidates[i]);
			helper(candidates, target, currSum + candidates[i], i, currList, list);

			currList.remove(currList.size() - 1);

		}
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		permuteHelper(nums, 0, nums.length - 1, list);
		return list;
	}

	public void permuteHelper(int[] nums, int l, int r, List<List<Integer>> list) {
		if (l == r) {
			List<Integer> currList = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				currList.add(nums[i]);
			}
			list.add(currList);
			return;
		}
		for (int i = l; i <= r; i++) {
			swap(nums, i, l);
			// currList.add(nums[i]);
			permuteHelper(nums, i, r, list);
			// currList.remove(index)
			swap(nums, i, l);
		}

	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(candidates);
		helper2(candidates, target, 0, 0, new ArrayList<>(), list);
		return list;
	}

	public void helper2(int[] candidates, int target, int currSum, int currIndx, List<Integer> currList,
			List<List<Integer>> list) {
		if (currSum >= target) {
			if (currSum == target)
				list.add(new ArrayList<>(currList));
			return;
		}
		for (int i = currIndx; i < candidates.length; i++) {
			if (i > currIndx && candidates[i] == candidates[i - 1])
				continue;
			currList.add(candidates[i]);
			helper2(candidates, target, currSum + candidates[i], i + 1, currList, list);

			currList.remove(currList.size() - 1);

		}
	}
}
