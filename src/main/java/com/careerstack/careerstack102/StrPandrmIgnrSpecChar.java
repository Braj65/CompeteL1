package com.trgr.careerstack102;

public class StrPandrmIgnrSpecChar {
	
	public static void main(String[] args){
		
		System.out.println((int)'Z');
		System.out.println((char)91);
		
		System.out.println(reverser("L******ir&il"));
	}
	
	public static String reverser(String txt){
		if(txt.length()==0){
			return "";
		}
		else{
			int x=(int)txt.charAt(0);
			if(x>=97 && x<=122 || x>=65 && x<=90){
				return reverser(txt.substring(1, txt.length()))+txt.charAt(0);
			}
			else{
				return reverser(txt.substring(1, txt.length()));
			}
			
		}
	}

}
