package BlackRock;

public class LC209 {

	public int minSubArrayLen(int s, int[] nums) {
		int left = 0, right = 0, min = Integer.MAX_VALUE, currSum = 0;
		while (right < nums.length) {
			if (currSum < s) {
				currSum += nums[right];
				right++;
			} else if (currSum == s) {
				min = Math.min(min, right - left);
				left++;
			} else {
				currSum -= nums[left];
				left++;
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		
	}
}
