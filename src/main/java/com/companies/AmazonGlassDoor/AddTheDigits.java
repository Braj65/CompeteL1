package com.trgr.AmazonGlassDoor;

public class AddTheDigits {
	
	public static void main(String[] args){
		System.out.println(adder(adder(999999999)));
	}
	
	public static int adder(int x){
		if(x==0)
			return 0;
		else{
			int i=x%10;
			x=(x-x%10)/10;
			return i+adder((x));
		}
	}

}
