package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
	
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int oldColor=image[sr][sc];
        boolean[][] visited=new boolean[image.length][image[0].length];
		Queue<Point> queue=new LinkedList<>();
		Point startPoint=new Point(sr, sc);
        visited[sr][sc]=true;
		queue.add(startPoint);
		while(!queue.isEmpty()){
			Point head=queue.poll();
			int i=head.x;
			int j=head.y;
			image[i][j]=newColor;
			if(i-1>=0 && image[i-1][j]==oldColor && !visited[i-1][j]){
                Point p=new Point(i-1,j);
                visited[i-1][j]=true;
				queue.add(p);
            }
			if(i+1<image.length && image[i+1][j]==oldColor && !visited[i+1][j]){
                Point p=new Point(i+1,j);
                visited[i+1][j]=true;
				queue.add(p);
            }
			if(j-1>=0 && image[i][j-1]==oldColor && !visited[i][j-1]){
                Point p=new Point(i,j-1);
				queue.add(p);
                visited[i][j-1]=true;
            }
			if((j+1)<image[0].length && image[i][j+1]==oldColor && !visited[i][j+1]){
                queue.add(new Point(i,j+1));
                visited[i][j+1]=true;
            }
		}
		
     return image;   
    }
	
	class Point{
		public int x,y;
		public Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	
	public int[][] floodFillDFS(int[][] image, int sr, int sc, int newColor) {
		boolean[][] visited=new boolean[image.length][image[0].length];
		int oldColor=image[sr][sc];
		dfs(image, sr, sc, newColor, oldColor, visited);
		return image;
	}
	
	public void dfs(int[][] matrix,int i,int j,int newColor,int oldColor,boolean[][] visited){
		matrix[i][j]=newColor;
		visited[i][j]=true;
		if(i-1>=0 && !visited[i-1][j] && matrix[i-1][j]==oldColor ){
			visited[i-1][j]=true;
			dfs(matrix, i-1, j, newColor, oldColor, visited);
		}
		if(i+1<matrix.length && !visited[i+1][j] && matrix[i+1][j]==oldColor ){
			visited[i+1][j]=true;
			dfs(matrix, i+1, j, newColor, oldColor, visited);
		}
		if(j-1>=0 && !visited[i][j-1] && matrix[i][j-1]==oldColor ){
			visited[i][j-1]=true;
			dfs(matrix, i, j-1, newColor, oldColor, visited);
		}
		if(j+1<matrix[0].length && !visited[i][j+1] && matrix[i][j+1]==oldColor ){
			visited[i][j+1]=true;
			dfs(matrix, i, j+1, newColor, oldColor, visited);
		}	
	}

}
