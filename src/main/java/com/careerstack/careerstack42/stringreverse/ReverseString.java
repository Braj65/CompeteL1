package com.trgr.careerstack42.stringreverse;

public class ReverseString {
	public static void main(String[] args){
		revWithLen("Jammy");
		String s="Poochi";
		
	}
	
	public static void revWithLen(String str){
		int len=str.length();
		String s="";
		for(int i=len-1;i>=0;i--){
			char a=str.charAt(i);
			s=s+a;			
		}
		System.out.println(s);
	}
	
	public static void revWithoutLen(String str){
		
	}

}
