package forUSALL;

public class Question2 {

	public static void main(String[] args) {
		Question2 q = new Question2();
		System.out.println(q.solution(new int[] { -3, -3 })); // 1
		System.out.println(q.solution(new int[] { 1, 1, 2, 3 })); // 2
		System.out.println(q.solution(new int[] { 1, 2, 3, 4 })); // 2
		System.out.println(q.solution(new int[] { 15, 12, 12, 13 }));// 3
		System.out.println(q.solution(new int[] { 1, 3 }));// 2
	}

	public int solution(int[] a) {
		if (a.length < 2) {
			return a.length;
		}
		Boolean hill = null;
		int count = 0, last = a[0];

		for (int i = 1; i < a.length; i++) {
			if (last < a[i]) {
				if (hill == null) {
					count++;
					hill = true;
				} else if (!hill) {
					count++;
					hill = !hill;
				}
			} else if (last > a[i]) {
				if (hill == null) {
					count++;
					hill = false;
				} else if (hill) {
					count++;
					hill = !hill;
				}
			} else
				continue;
			last = a[i];
		}
		return count + 1;
	}
}
