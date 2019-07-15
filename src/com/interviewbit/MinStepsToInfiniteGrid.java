package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class MinStepsToInfiniteGrid {
	 public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
	 if(X.size()<=1)
		 return 0;
	 int startx=X.get(0),starty=Y.get(0),steps=0;;
	 for(int i=1;i<X.size();i++){
		 int x=Math.abs(startx-X.get(i));
		 int y=Math.abs(starty-Y.get(i));
		 steps+=Math.max(x, y);
		 startx=X.get(i);
		 starty=Y.get(i);
	 }
	 return steps;
	 }
}
