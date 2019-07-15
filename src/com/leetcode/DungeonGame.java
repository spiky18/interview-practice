package com.leetcode;

public class DungeonGame {
public int calculateMinimumHP(int[][] dungeon) {
	
	point[][] result=new point[dungeon.length][dungeon[0].length];
	for(int i=0;i<dungeon.length;i++){
		for(int j=0;j<dungeon[0].length;j++){
			if(i==0 && j==0)
				result[i][j]=new point(dungeon[i][j],dungeon[i][j]);
			else if(i==0){
				if(dungeon[i][j]>0)
					result[i][j]=new point(result[i][j-1].minHealth,result[i][j-1].pathSum+dungeon[i][j]);
				else
					result[i][j]=new point(result[i][j-1].minHealth+dungeon[i][j],result[i][j-1].pathSum+dungeon[i][j]);
				}
			else if(j==0){
				if(dungeon[i][j]>0)
					result[i][j]=new point(result[i-1][j].minHealth,result[i-1][j].pathSum+dungeon[i][j]);
				else
					result[i][j]=new point(result[i-1][j].minHealth+dungeon[i][j],result[i-1][j].pathSum+dungeon[i][j]);
				}
			else{
				result[i][j]=new point(0, 0);
				if(result[i-1][j].minHealth>result[i][j-1].minHealth)
					result[i][j]=new point(result[i-1][j].minHealth, result[i-1][j].pathSum+dungeon[i][j]);
				else
					result[i][j]=new point(result[i][j-1].minHealth, result[i][j-1].pathSum+dungeon[i][j]);
				if(dungeon[i][j]<0)
					result[i][j].minHealth+=dungeon[i][j];
			}
		}
	}
	if(result[dungeon.length-1][dungeon[0].length-1].minHealth>0)
		return 1;
	if(result[dungeon.length-1][dungeon[0].length-1].pathSum>0)
		return 1-result[dungeon.length-1][dungeon[0].length-1].minHealth;	
     return 1-result[dungeon.length-1][dungeon[0].length-1].pathSum;   
    }

	class point{
		public int minHealth;
		public int pathSum;
		public point(int m,int p){
			minHealth=m;
			pathSum=p;
		}
	}
}
