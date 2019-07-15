package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Excel {
	cell[][] sheet;
    public Excel(int H, char W) {
        sheet=new cell[H][W-'A'+1];
        for(int i=0;i<H;i++){
            for(int j=0;j<(W-'A'+1);j++)
                {
            		//System.out.println();
                    sheet[i][j]=new cell(i,(char)('A'+j));
                }
        }
    }
    
    public void set(int r, char c, int v) {
    	int row=r-1;
        int col=c-'A';
        cell temp=sheet[row][col];
        temp.setVal( v);
        temp.remove();
    }
    
    public int get(int r, char c) {
        return sheet[r-1][c-'A'].val;
    }
    
    public int sum(int r, char c, String[] strs) {
        int row=r-1;
        int col=c-'A';
        cell temp=sheet[row][col];
        int sum=0;
        for(String s : strs)
        	sum+=sumRectangle(s, temp);
        temp.setVal(sum);
        return sum;
    }
    
    public int sumRectangle(String str,cell c){
    	int sum=0;
    	if(!str.contains(":"))
    	{
    		int row=Integer.parseInt(str.substring(1))-1;
    		int col=str.charAt(0)-'A';
    		sum=sheet[row][col].val;
    		sheet[row][col].usedIn.add(c);
    		c.usedBy.add(sheet[row][col]);
    		//System.out.println("sum "+sum);
    		return sum;
    	}
        int startcol=str.charAt(0)-'A';
        int i= str.indexOf(':');
        //System.out.println("substr "+str.substring(1, i));
        int startrow=Integer.parseInt(str.substring(1, i))-1;
        int endcol=str.charAt(i+1)-'A';
        int endrow=Integer.parseInt(str.substring(i+2))-1;
        //System.out.println(startrow+" "+startcol+" "+endrow+" "+endcol);
        for(i=startrow;i<=endrow;i++){
        	for(int j=startcol;j<=endcol;j++){
        		sum+=sheet[i][j].val;
        		sheet[i][j].usedIn.add(c);
        		c.usedBy.add(sheet[i][j]);
        	}
        }
        c.setVal(sum);
        return sum;
    }
    
    class cell{
        public int r, val;
        public char c;
        public List<cell> usedIn;
        public List<cell> usedBy;
        public cell(int row,char col){
            this.r=row;
            this.c=col;
            this.val=0;
            usedIn=new LinkedList<cell>();
            usedBy=new LinkedList<cell>();
        }
        
        public void setVal(int newVal){
        	for(cell obj : this.usedIn){
        		obj.setVal(obj.val-this.val+newVal);        		
        	}
        	this.val=newVal;
        }
        
        public void remove(){
        	
        	for(cell temp : this.usedBy)
        		temp.usedIn.remove(this);
        	
        	this.usedBy=new LinkedList<cell>();
        }
    }
     public static void main(String[] args) {
		Excel exc=new Excel(5, 'E');
		exc.set(1, 'A', 5);
		exc.set(1, 'B', 3);
		exc.set(1, 'C', 2);
		String[] s1={"A1","A1:B1"};
		System.out.println(exc.sum(1, 'C', s1));
		System.out.println(exc.get(1, 'C'));
		exc.set(1, 'B', 5);
		System.out.println(exc.get(1, 'C'));
		String[] strs={"A1:A5"};
		System.out.println(exc.sum(1, 'B', strs));
		exc.set(5, 'A', 10	);
		System.out.println(exc.get(1, 'B'));
		System.out.println(exc.get(1, 'C'));
		
	}
}
