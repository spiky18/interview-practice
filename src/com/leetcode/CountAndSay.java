package com.leetcode;

public class CountAndSay {
	public String countAndSay(int n) {
		if(n<=1)
			return "1";
		int cnt=1;
		StringBuilder sb=new StringBuilder("1");
		while(cnt<n){
			StringBuilder tmp=new StringBuilder("1");
		}
		//while()
		return "";
	}
	
	public boolean checkInclusion(String s1, String s2) {
        int[] map=new int[26];
        int[] bkmap=new int[26];
        for(int i=0;i<s1.length();i++){
            map[s1.charAt(i)-'a']++;
            bkmap[s1.charAt(i)-'a']++;
        }
        int left=0,right=0,len=0;
        while(left<s2.length()){
            
            if(map[s2.charAt(right)-'a']>0){
            	map[s2.charAt(right)-'a']--;
            	right++;
                len++;
                if(len==s1.length())
                return true;
            }else{
                while(left<right)
                {
                    if(bkmap[s2.charAt(left)-'a']>0)
                        map[s2.charAt(left)-'a']++;
                    left++;
                    
                }
                left++;
                right++;
                len=0;
            }
                
        }
        return len==s1.length();
    }
	
	public static void main(String[] args) {
		CountAndSay obj=new CountAndSay();
		System.out.println(obj.checkInclusion("ab", "eidboaoo"));
	}
}
