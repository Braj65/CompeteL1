package com.trgr.careerstack39.numberSigns;

public class NumberSign {
	
	public static void main(String[] args){
		int i=-20;
		int j=20;
		/*To get the two's complement negative notation of an integer, 
		you write out the number in binary. You then invert the digits, and add one to the result.*/
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toBinaryString(j));
		if(i*j>0)
			System.out.println("False");
		else
			System.out.println("true");
		
		System.out.println(oppo(i, j));		
	}
	
	public static boolean oppo(int x, int y){
		int z=x^y;
		System.out.println(Integer.toBinaryString(z));
		
		return ((x^y)<0);
	}

}
