package BlackRock;

public class MeetingPlanner {
	static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
		int i=0,j=0;
		while(i<slotsA.length && j<slotsB.length){
			int start=Math.max(slotsA[i][0], slotsB[j][0]);
			int end=Math.min(slotsA[i][1], slotsB[j][1]);
			if(end-start>=dur)
				return new int[]{start,start+dur};
			
			if(slotsA[i][1]>slotsB[j][1])
				j++;
			else
				i++;
		}
		return new int[0];
	}
	
}
