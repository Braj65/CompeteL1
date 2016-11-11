package com.trgr.careerstack57.powMinmulti;

public class MinMultiplyRecurse {
	
	public static void main(String[] args){
		multi(5, 10);
	}
	
	public static int multi(int num, int pow){
		if(pow==0)
			return 1;
		int y=multi(num, pow/2);
		
		if(pow%2==0)
			return y*y;
		else{
			if(pow>0)
				return num*y*y;
			else
				return (y*y)/pow;
		}
		
	}

}
