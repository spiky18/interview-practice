import java.util.TreeSet;

public class GoogleFlower {

	    public int solution(int[] flowers, int K) {
	        // write your code in Java SE 8
	        TreeSet<Integer> set=new TreeSet<>();
	        int result=-1;
	        for(int f : flowers){
	            set.add(f);
	            int prev=f-K-1,next=f+K+1;
	            if(set.contains(prev)){
	                Integer nextprev=set.ceiling(prev+1);
	                if(nextprev!=null && nextprev==f)
	                    result=set.size();
	            }
	            if(set.contains(next)){
	                Integer nextnext=set.floor(next-1);
	                if(nextnext!=null && nextnext==f)
	                    result=set.size();
	            }
	            if(result!=-1){
	                int p=result-K-1,n=result+K+1;
	                if(set.contains(p)){
	                    Integer nextp=set.ceiling(p+1);
	                    if(nextp!=null && nextp==result)
	                        result=set.size();
	                }
	                if(set.contains(n)){
	                    Integer nextn=set.floor(n-1);
	                    if(nextn!=null && nextn==f)
	                        result=set.size();
	                }
	            }
	        }
	        return result;
	    }
}
