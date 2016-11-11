package com.trgr.careerstack3.doubleFlowersAndTemple;

public class DoubledFlowersandTemples {
	public int i=4;
	public static void main(String[] args){
		DoubledFlowersandTemples obj=new DoubledFlowersandTemples();
		//counter(x, y);s
	}
	
	public void counter(int x, int y){
		if(i==0){
			
		}
		else{
			x=2*x;
			--i;
		}
		
		counter(x-y, y);
	}

}
