package com.facebook.hackercup;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class ProgressPie {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] lineArr = new String[n];
		int i = 0;
		in.nextLine();
		PrintWriter writer = new PrintWriter("ProgressPie_output.txt", "UTF-8");
		while (n > 0) {
			lineArr[i] = in.nextLine();
			i++;
			n--;
		}
		ProgressPie p = new ProgressPie();
		for (int j = 0; j < i; j++) {
			String[] s = lineArr[j].split(" ");
			/*writer.println("Case #" + (j + 1) + ": "
					+ p.color(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2])));*/
			System.out.println("Case #"+(j+1)+": "+p.color(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2])));
		}
	}

	public String color(int p, int x, int y) {
		int inCircle = (x - 50) * (x - 50) + (y - 50) * (y - 50);
		if (inCircle > 2500)
			return "white";
		double degrees = p * 3.6;
		int check = quardrant(degrees, x, y);
		if (check < 0)
			return "white";
		if (check > 0)
			return "black";
		if (degrees <= 180)
			degrees = 90 - degrees;
		/*
		 * else degrees-=180;
		 */
		// System.out.println(degrees);
		degrees %= 90;
		double radians = Math.toRadians(degrees);

		double slope = Math.tan(radians);
		double d = (y - 50) - slope * (x - 50);
		if (d >= 0)
			return "black";

		return "white";

	}

	public int quardrant(double degrees, int x, int y) {
		double q = Math.ceil(degrees / 90);
		int s = 0;
		if (x >= 50 && y >= 50)
			s = 1;
		else if (x >= 50 && y <= 50)
			s = 2;
		else if (x <= 50 && y <= 50)
			s = 3;
		else if (x <= 50 && y >= 50)
			s = 4;
		if (q - s < 0)
			return -1;
		// System.out.println(q-s);
		else if (q - s > 0)
			return 1;
		return 0;
	}
}
