package com.trgr.AmazonGlassDoor;

public class RomanToIntegerToBack {
	
	public static void main(String[] args){
		RomeToArab("I");
		RomeToArab("II");
		RomeToArab("III");
		RomeToArab("IV");
		RomeToArab("V");
		RomeToArab("VI");
		RomeToArab("VII");
		RomeToArab("VIII");
		RomeToArab("IX");
		RomeToArab("X");
		RomeToArab("XI");
		RomeToArab("XII");
		RomeToArab("XIII");
		RomeToArab("XIV");
		RomeToArab("XV");
		RomeToArab("XVI");
		RomeToArab("XVII");
		RomeToArab("XVIII");
		RomeToArab("XIX");
		RomeToArab("XXXX");
	}
	
	public static void RomeToArab(String x){
		int i=0;
		int sum=0;
		int temp=0;
		while(x.length()!=0){
			if(x.charAt(x.length()-1)=='I')
				i=1;
			else if(x.charAt(x.length()-1)=='V')
				i=5;
			else if(x.charAt(x.length()-1)=='X')
				i=10;
			x=x.substring(0, x.length()-1);
			if(i<temp){
				sum=sum-i;
			}else{
				sum=sum+i;
			}
			temp=i;
						
		}
		
		System.out.println(sum);		
	}

}
