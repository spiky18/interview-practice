package com.leetcode;

public class ComplexNumberMultiplication {
	public String complexNumberMultiply(String a, String b) {
		String[] aArr=a.split("+");
		String[] bArr=b.split("+");
		int r1=Integer.parseInt(aArr[0]);
		int i1=Integer.parseInt(aArr[1].substring(0, aArr[1].length()-2));
		int r2=Integer.parseInt(bArr[0]);
		int i2=Integer.parseInt(bArr[1].substring(0, bArr[1].length()-2));
		int r=r1*r2-i1*i2;
		int c=r1*i2+i2*r2;
		StringBuilder sb=new StringBuilder();
		sb.append(r);
		sb.append('+');
		sb.append(c);
		sb.append('i');
		return sb.toString();
	}
}
