package BlackRock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeInterval{
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> list = new ArrayList<Interval>();
		intervals.sort((o1,o2)->Integer.compare(o1.start,o2.start));

		for(Interval i : intervals){
			if(list.isEmpty()|| list.get(list.size()-1).end<i.start)
				list.add(i);
			else{
				list.get(list.size()-1).end=Math.max(list.get(list.size()-1).end, i.end);
			}
				
		}
		
		return list;

	}
	
	public static void main(String[] args) {
		byte b=8;
		long l=Byte.toUnsignedLong(b);
		String s1="JAVA";
		String s2=s1;
		s1="C++";
		Integer i1=5;
		Integer i2=i1;
		i1=7;
		System.out.println(s1+" "+s2);
		System.out.println(i1+" "+i2);
		System.out.println("JVM Bit size: " + System.getProperty("sun.arch.data.model"));
		
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
	
}