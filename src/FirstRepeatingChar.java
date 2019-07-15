import java.util.Scanner;

public class FirstRepeatingChar {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String s=in.nextLine();
		FirstRepeatingChar obj=new FirstRepeatingChar();
		System.out.println(obj.firstRepChar(s));
		
	}
	
	public char firstRepChar(String s){
		char[] freqMap=new char[26];
		for(char ch : s.toCharArray()){
			freqMap[ch-'a']++;
			if(freqMap[ch-'a']==2)
				return ch;
		}
		return '0';
	}

}
