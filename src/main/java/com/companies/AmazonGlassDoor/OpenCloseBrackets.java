package com.trgr.AmazonGlassDoor;

public class OpenCloseBrackets {
	
	public static void main(String[] args){
		String x="((((())(())";
		int count1=0;
		int count2=0;
		while(x.length()!=0){
			if(x.charAt(0)=='('){
				++count1;
			}else{
				++count2;
			}
			x=x.substring(1, x.length());
		}
		System.out.println(count1+" "+count2);
	}

}

