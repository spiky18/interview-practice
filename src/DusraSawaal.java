import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DusraSawaal {
	static String[] func(String s, String t){
		String[] sArray=s.split(" ");
		String[] tArray=t.split(" ");
		HashSet<String> set=new HashSet<>();
		for(int i=0;i<tArray.length;i++)
			set.add(tArray[i]);
		
		List<String> list=new ArrayList<>();
		for(int i=0;i<sArray.length;i++){
			if(!set.contains(sArray[i]))
				list.add(sArray[i]);
		}
		String[] res=new String[list.size()];
		list.toArray(res);
		return res;
	}
	
	public static void main(String[] args) {
		
	}
}
