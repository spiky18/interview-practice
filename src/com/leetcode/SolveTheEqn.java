package com.leetcode;

public class SolveTheEqn {
	 public String solveEquation(String equation) {
			String[] arr=equation.split("=");
			eqn lhs=oneSide(arr[0]);
			eqn rhs=oneSide(arr[1]);
			
			lhs=lhs.sum(-1*rhs.xCoeff, -1*rhs.num);
			if(lhs.xCoeff==0 && lhs.num!=0)
				return "No solution";
			if(lhs.xCoeff==0 && lhs.num==0)
				return "Infinite solutions";
			
			return "x="+(-1*lhs.num/lhs.xCoeff);
		}

		public eqn oneSide(String s) {
			int xCoeff = 0, num = 0;
			StringBuilder numString = new StringBuilder();
			StringBuilder sign = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'x') {
					if (numString.length() == 0) {
						if (sign.length() == 0 || sign.charAt(0)=='+')
							xCoeff++;
						else
							xCoeff--;
					} else {
						if (sign.length() == 0 || sign.charAt(0)=='+') {
							xCoeff += Integer.parseInt(numString.toString());
						} else
							xCoeff -= Integer.parseInt(numString.toString());
					}
					numString = new StringBuilder();
					sign = new StringBuilder();
				} else if (Character.isDigit(s.charAt(i)))
					numString.append(s.charAt(i));
				else {
					if (numString.length() != 0)
						if (sign.length() == 0 || sign.charAt(0)=='+') {
							num += Integer.parseInt(numString.toString());
						} else
							num -= Integer.parseInt(numString.toString());
					numString = new StringBuilder();
					sign = new StringBuilder();
					sign.append(s.charAt(i));
				}

			}
	        if(numString.length()!=0)
	        {
	            if (sign.length() == 0 || sign.charAt(0)=='+') {
							num += Integer.parseInt(numString.toString());
						} else
							num -= Integer.parseInt(numString.toString());
	        }
	            System.out.println(xCoeff+" "+num);
			return new eqn(xCoeff, num);
		}

		public class eqn {
			public int xCoeff;
			public int num;

			public eqn(int xMul, int n) {
				this.xCoeff = xMul;
				this.num = n;
			}

			public eqn sum(int xMul, int n) {
				this.xCoeff += xMul;
				this.num += n;
				return this;
			}
		}
}
