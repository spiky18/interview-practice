package BlackRock;

import java.util.Random;

public class DecimalToBinary {

	public String decimatToBinary(int num){
		StringBuilder sb=new StringBuilder();
		
		if(num==0)
			return sb.append(0).toString();
		while(num>0){
			sb.append(num%2);
			num/=2;
			
		}
		
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		DecimalToBinary obj=new DecimalToBinary();
		System.out.println(obj.decimatToBinary(Integer.MIN_VALUE));
		System.out.println(obj.hashCode());
		
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		Random m=new Random();
		return m.nextInt(1000);
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}


