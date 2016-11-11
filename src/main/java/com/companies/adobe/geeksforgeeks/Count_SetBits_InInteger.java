package com.trgr.adobe.geeksforgeeks;

public class Count_SetBits_InInteger {
	
	public static void main(String[] args){
		int i=9;
		int count=0;
		
		while(i>0){
			count+=i&1;
			i>>=1;
		}
		
		System.out.println(count);
	}

}
