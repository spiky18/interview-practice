import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class NeuralAnalysisQ3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		NeuralAnalysisQ3 sln = new NeuralAnalysisQ3();
		System.out.println(sln.solution(s));

	}

	public int solution(String S) {
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		// ArrayDeque<Integ>
		String[] sArr = S.split(" ");
		/*
		 * if(sArr[0]=="DUP" || sArr[0].equals("POP") || sArr[0].equals("+") ||
		 * sArr[0].equals("-")) return -1;
		 */
		for (String s : sArr) {
			switch (s) {
			case "DUP": {
				if (stack.size() >= 1) {
					stack.push(stack.peek());
				} else
					return -1;
				break;
			}
			case "POP": {
				if (stack.size() >= 1) {
					stack.pop();
				} else {
					return -1;
				}
				break;
			}
			case "+": {
				if (stack.size() >= 2) {
					int num = stack.pop() + stack.pop();
					if (!validate(num)) {
						return -1;
					}
					stack.push(num);
				} else {
					return -1;
				}
				break;
			}
			case "-": {
				if (stack.size() >= 2) {
					int num = stack.pop() - stack.pop();
					if (!validate(num)) {
						return -1;
					}
					stack.push(num);
				} else {
					return -1;
				}
				break;
			}
			default:
				int num = Integer.parseInt(s);
				if (!validate(num)) {
					return -1;
				}
				stack.push(num);
				break;
			}
		}
		if (stack.isEmpty()) {
			return -1;
		}
		return stack.peek();
	}

	public boolean validate(int num) {
		int max = (int) Math.pow(2, 20) - 1;
		if (num > max || num < 0)
			return false;
		return true;
	}
}
