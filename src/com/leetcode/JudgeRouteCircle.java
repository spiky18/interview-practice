package com.leetcode;

public class JudgeRouteCircle {
	public boolean judgeCircle(String moves) {
        int l=0,u=0,d=0,r=0;
        for(char ch : moves.toCharArray()){
            switch(ch){
                case 'L': l++;
                    break;
                case 'R': r++;
                    break;
                case 'D': d++;
                    break;
                case 'U': u++;
                    break;
            }
        }
        return l==r && u==d;
    }
}
