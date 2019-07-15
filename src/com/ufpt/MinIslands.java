package com.ufpt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MinIslands {
	
	public static class Point{
		int x,y; //row column
		/*public Point(int x,int y){
			this.x=x;
			this.y=y;
		}*/

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int r=in.nextInt();
		int c=in.nextInt();
		in.nextLine();
		char[][] image=new char[r][c];
		boolean [][] vis=new boolean[r][c];
		for(int i=0;i<r;i++){
			String row=in.nextLine();
			for(int j=0;j<c;j++)
				image[i][j]=row.charAt(j);
		}
		System.out.println("original map");
		printMap(image);
		int noOfislands=0;
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++)
			{
				if(image[i][j]=='L' && !vis[i][j] ){
					
					Point start= new Point(i, j);
					Queue<Point> queue=new LinkedList<>();
					vis[i][j]=true;
					queue.add(start);
					while(!queue.isEmpty()){
						Point toProcess=queue.poll();
						int currRowPos=toProcess.x;
						int currColPos=toProcess.y;
						//check west Neighbor
						if(currColPos-1>=0 && !vis[currRowPos][currColPos-1] && (image[currRowPos][currColPos-1]=='L' || image[currRowPos][currColPos-1]=='C')){
							vis[currRowPos][currColPos-1]=true;
							image[currRowPos][currColPos-1]='l';
							queue.add(new Point(currRowPos, currColPos-1));
						}
						//check east neighbour
						if(currColPos+1<c && !vis[currRowPos][currColPos+1] && (image[currRowPos][currColPos+1]=='L' || image[currRowPos][currColPos+1]=='C')){
							vis[currRowPos][currColPos+1]=true;
							image[currRowPos][currColPos+1]='l';
							queue.add(new Point(currRowPos, currColPos+1));
						}
						//check north neighbor
						if(currRowPos-1>=0 && !vis[currRowPos-1][currColPos] && (image[currRowPos-1][currColPos]=='L' || image[currRowPos-1][currColPos]=='C')){
							vis[currRowPos-1][currColPos]=true;
							image[currRowPos-1][currColPos]='l';
							queue.add(new Point(currRowPos-1, currColPos));
						}
						//check south neighbor
						if(currRowPos+1<r && !vis[currRowPos+1][currColPos] && (image[currRowPos+1][currColPos]=='L' || image[currRowPos+1][currColPos]=='C')){
							vis[currRowPos+1][currColPos]=true;
							image[currRowPos+1][currColPos]='l';
							queue.add(new Point(currRowPos+1, currColPos));
						}
					}
					noOfislands++;
				}
			}
		}
		System.out.println(noOfislands);
		printMap(image);
	}

	public static void printMap(char[][] map){
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[0].length;j++)
				System.out.print(map[i][j]);
			System.out.println();
		}
	}
	

}
