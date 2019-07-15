import java.util.ArrayList;
import java.util.Arrays;

public class Inte {
	public ArrayList<Integer> maxset(ArrayList<Integer> a) {
	    int maxsum=0,runningsum=0;
	    ArrayList<Integer> result=new ArrayList<>();
	    ArrayList<Integer> prev=new ArrayList<>();
	    for(int i=0;i<=a.size();i++){
	        if(i<a.size() && a.get(i)>0){
	            prev.add(a.get(i));
	            runningsum+=a.get(i);
	            System.out.println(i+" "+runningsum+" "+prev.size());
	        }
	        else
	            {
	                System.out.println("max "+runningsum+" "+maxsum);
	                if(runningsum>maxsum){
	                    maxsum=runningsum;
	                    result=new ArrayList<>(prev);
	                    //startIndex=i-prev.size()+1;
	                    System.out.println("test"+prev.get(0)+result.get(0));
	                }
	                else if(runningsum==maxsum){
	                    if(result.size()<prev.size())
	                        result=new ArrayList<>(prev);
	                }
	                prev=new ArrayList<>();
	                runningsum=0;
	            }
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		Inte obj=new Inte();
		//Integer[] arr={2, 3, 4, -1, -2, 1, 5, 6, 3};
		ArrayList<Integer> a = new ArrayList<>();
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(-1);
		a.add(-2);
		a.add(1);
		a.add(5);
		a.add(6);
		a.add(3);
		ArrayList<Integer> result=obj.maxset(a);
		System.out.print("{");
		for(int i : result){
			System.out.print(i+",");
		}
		System.out.print("}");
		
	}
	
	
	
}
