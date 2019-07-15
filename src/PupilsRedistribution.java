import java.util.Scanner;

public class PupilsRedistribution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		//int a[]=new int[n];
		int aCount[]=new int[5];
		for(int i=0;i<n;i++){
			aCount[in.nextInt()-1]++;
			}
		
		for(int i=0;i<n;i++){
			aCount[in.nextInt()-1]--;
		}
		boolean possible=true;
		int exchanges=0;
		for(int i=0;i<5;i++){
			if(Math.abs(aCount[i])%2!=0)
				possible=false;
		}
		
		if(possible){
			for(int i=0;i<5;i++)
				exchanges+=Math.abs(aCount[i])/2;
			exchanges/=2;
			System.out.println(exchanges);
		}
		if(!possible)
			System.out.println(-1);
	}
	
	

}
