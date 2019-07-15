package BlackRock;

public class LC647 {

	public int countSubstrings(String s) {
		int count = 0;
		for(int i=0;i<s.length();i++){
			int left=i,right=i;
			while(right>=0 && left<s.length() && s.charAt(left)==s.charAt(right)){
				count++;
				left++;
				right--;
			}
		}

		return count;

	}

	
	
	public int countSubstringsBruteForce(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if (isPalindrome(s, i, j))
					count++;
			}
		}

		return count;
	}

	public boolean isPalindrome(String s, int left, int right) {

		while (right > left) {
			if (s.charAt(left) == s.charAt(right)) {
				left++;
				right--;
			} else
				return false;

		}
		return true;
	}

}
