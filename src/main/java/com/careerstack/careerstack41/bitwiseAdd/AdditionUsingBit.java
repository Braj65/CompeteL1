package com.trgr.careerstack41.bitwiseAdd;

public class AdditionUsingBit {
	
	public static void main(String[] args){
		System.out.println(Add(12, 4));
	}
	
	public static int Add(int x, int y)
	{
		int a,b;
	    do{
	        a=x&y;
	        b=x^y;
	        x=a<<1;
	        y=b;
	    }while(a!=0);
	    return b;
	}

}
