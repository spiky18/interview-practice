package com.leetcode;

public class ValidateIP {
	
	public String validIPAddress(String IP) {
	if(IP.indexOf('.')!=-1){
		String[] sArr=IP.split(".");
		if(validateIPV4(sArr))
			return "IPv4";
	}
	else{
		String[] sArr=IP.split(":");
		if(validateIPV6(sArr))
			return "IPv6";
	}
     return "Neither";   
    }

	public boolean validateIPV4(String[] sArr){
		if(sArr.length!=4)
			return false;
		for(int i=0;i<sArr.length;i++){
			if(sArr[i].length()>3)
				return false;
			if(sArr[i].charAt(0)=='0' && sArr[i].length()>1){
				return false;
			}
			int cnt=1,val=0;
			for(int j=sArr[i].length()-1;j>=0;j--){
				
				if(!Character.isDigit(sArr[i].charAt(j)))
					return false;
				int num=sArr[i].charAt(j)-'0';
				val+=cnt*num;
				cnt*=10;
			}
			if(val>255 || val<0)
				return false;
		}
		return true;
	}
	
	public boolean validateIPV6(String[] sArr){
		if(sArr.length!=8)
			return false;
		
		int maxIp=65535;
		for(int i=0;i<sArr.length;i++){
			if(sArr[i].length()>4 || sArr[i].length()<=0) 
				return false;
			int dec=hexToDec(sArr[i]);
			if(dec>maxIp||dec<0)
				return false;
		}
		return true;
	}
	
	public int hexToDec(String hexNum){
		int[] hexVals={10,11,12,13,14,15};
		int res=0,cnt=1;
		for(int i=hexNum.length()-1;i>=0;i--){
			int num=hexNum.charAt(i)-'0';
			if(Character.isUpperCase(hexNum.charAt(i)))
					num=hexVals[hexNum.charAt(i)-'A'];
			if(Character.isLowerCase(hexNum.charAt(i)))
				num=hexVals[hexNum.charAt(i)-'a'];
			res+=num*cnt;
			cnt*=16;
		}
		return res;
		
	}
}
