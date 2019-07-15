package lumity;

import java.util.LinkedList;

public class DunkirkRescue {

	public static int solution(int[] arr, int n) {
		LinkedList<Integer> list = new LinkedList<>();
		for (int i : arr)
			list.add(i);
		int i = list.size() - 1, days = 0;
		while (list.size() > 0) {
			boolean isBoarded = false;
			
			while (i > 0) {
				if (list.get(i) > list.get(i - 1)) {
					list.remove(i);
					isBoarded = true;
				}
				i--;
			}
			if(!isBoarded)
				break;
			days++;
			i =list.size() - 1 ;
		}

		return days;
	}
	 public static void main(String[] args) {
		int[] arr={5,9,4,10,12,8,6,11,7};
		int[] arr2={6,5,8,4,7,10,9};
		System.out.println(solution(arr, 0));
		System.out.println(solution(arr2, 0));
		
	}
}
