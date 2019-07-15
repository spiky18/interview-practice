package BlackRock;

import java.util.LinkedList;
import java.util.List;

public class LC218 {

public List<int[]> getSkyline(int[][] buildings) {
	 List<int[]> list=new LinkedList<int[]>();
	 
	 
	 /*int leftX=0,rightX=1,height=2;
	 
	 int[] last=buildings[0];
	 list.add(new int[]{last[leftX],last[height]});
	 for(int i=1;i<buildings.length;i++){
		 if(last[rightX]>=buildings[i][leftX]){
			 //overlap
			 if(last[height]!=buildings[i][height])
				 list.add(new int[]{last[leftX],Math.max(last[height], buildings[i][height])});
			 
		 }else{
			 //no overlap
			 list.add(new int[]{buildings[i][leftX],buildings[i][height]});
			 last=buildings[i];
		 }
		 
		
	 }*/
	 return list;
    }
}

class building implements Comparable<building>{
	int x,y;
	boolean isStart;
	
	public building(int x,int h,boolean start ) {
		// TODO Auto-generated constructor stub
		this.x=x;
		this.y=h;
		isStart=start;
	}
	
	@Override
	public int compareTo(building o) {
		if(this.x!=o.x)
			return this.x-o.x;
		if(this.isStart && o.isStart)
			return o.y-this.y;
		if(!this.isStart && !o.isStart)
			return o.y-this.y;
		return 0;
	}
	
	
	
}
