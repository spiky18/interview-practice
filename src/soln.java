import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class soln {

	/*
	 * public static void main(String[] args) { // TODO Auto-generated method
	 * stub try { badMethod(); System.out.println("a"); } catch(Exception e ){
	 * System.out.println("b");
	 * 
	 * }finally { // TODO: handle finally clause System.out.println("c"); }
	 * System.out.println("d");
	 * 
	 * }
	 */
	/*
	 * //
	 */

	/*
	 * public static void badMethod(){ throw new RuntimeException(); }
	 */
	public List<List<Integer>> threeSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int key = target - nums[i];
			int low = i + 1, high = nums.length - 1;
			while (low < high) {
				if (low > i + 1 && nums[low] == nums[low - 1]) {
					low++;
					continue;
				}
				int sum = nums[low] + nums[high];
				if (sum == key) {
					list.add(Arrays.asList(nums[i], nums[low], nums[high]));
				} else if (sum > key)
					high--;
				else
					low++;
			}
		}

		return list;
	}
	
	
}
