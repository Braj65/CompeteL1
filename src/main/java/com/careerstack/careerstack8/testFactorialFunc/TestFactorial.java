package com.trgr.careerstack8.testFactorialFunc;

public class TestFactorial {
	
	public static void main(String[] agrs){
		TestFactorial obj=new TestFactorial();
		System.out.println(obj.getFact(5));
	}
	
	public int getFact(int x){
		if(x==1){
			return 1;
		}
		else{
			return x*getFact(x-1);
		}
	}

}
