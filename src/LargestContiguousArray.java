import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LargestContiguousArray {
	public int[] solution(int a[], int k){
        int result[] = new int[k];
        
        //HashMap<Integer,Integer> posMap=new HashMap<>();
        int[] copyArray =new int[a.length];
        PriorityQueue<tempClass> queue=new PriorityQueue<>();
        for(int i=0;i<a.length;i++){
        	//posMap.put(a[i],i);
        	copyArray[i]=a[i];
        	queue.add(new tempClass(i, a[i]));
        	}
        Arrays.sort(copyArray);
        
        
        for(int i=a.length - 1; i >= 0; i--){
            int index = queue.poll().index;

            if(a.length - index >= k){
                System.arraycopy(a, index, result, 0, k);
                break;
            }
        }
        return result;
    }

	class tempClass implements Comparable<tempClass>{
		int index;
		int val;
		public tempClass(int i,int value) {
			this.index=i;
			this.val=value;
		}
		@Override
		public int compareTo(tempClass o) {
			// TODO Auto-generated method stub
			return o.val-this.val;
		}
		
	}
    /*private int findIndex(int[] array, int value) {
        for (int i=0 ;i < array.length; i++){
            if(array[i] == value){
                return i;
            }
        }
        return -1;
    }*/
}
