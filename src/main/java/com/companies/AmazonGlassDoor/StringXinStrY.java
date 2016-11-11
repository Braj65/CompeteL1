package com.companies.AmazonGlassDoor;

public class StringXinStrY {
	public static void main(String[] args){
		String s1="Jammy isn't a";
		String s2="Jammy is a tool";
		
		char[] arr=s2.toCharArray();
		
		for(char c:arr){
			int index=s1.indexOf(c);
			if(index!=-1){
				s1=s1.substring(0, index)+s1.substring(index+1, s1.length());
			}
		}
		System.out.println(s1.isEmpty());
	}

}
