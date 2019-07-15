import java.util.Arrays;

public class StringWaalaQuestion {
	public int[] solution(String a, String b) {
		String[] aArr = a.split(" ");
		String[] bArr = b.split(" ");

		int result[] = new int[bArr.length];

		int[] aFreqMap = new int[aArr.length];
		for (int i = 0; i < aArr.length; i++) {
			aFreqMap[i] = smallestFreqCharInString(aArr[i]);
		}
		
		Arrays.sort(aFreqMap);

		for (int i = 0; i < bArr.length; i++) {
			int bFreq = smallestFreqCharInString(bArr[i]);
			result[i] = getCountSmallerFreq(aFreqMap, bFreq);
		}
		return result;
	}
	
	private  int getCountSmallerFreq(int[] aFreqMap, int bFreq){
		int start = 0, end = aFreqMap.length-1;
		
		while(start <= end){
			if(bFreq <= aFreqMap[start])
				return start;
			if(bFreq > aFreqMap[end])
				return end+1;
			int mid = (start+end)/2;
			if(aFreqMap[mid] <= bFreq){
				start = mid+1;
			}	else{
				end = mid-1;
			}
		}
		
		return end+1;		
	}

	private  int smallestFreqCharInString(String aString) {
		int[] charMap = new int[26];

		for (char c : aString.toCharArray()) {
			charMap[c - 'a']++;
		}
		
		for (int c : charMap) {
			if (c > 0) {
				return c;
			}
		}
		return 0;
	}
}
