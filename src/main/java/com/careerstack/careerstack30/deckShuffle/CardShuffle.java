package com.trgr.careerstack30.deckShuffle;

public class CardShuffle {
	
	public static void main(String[] args){
		int[] x={1, 2, 3, 4, 5, 6};
		int t;
		for(int i=5;i>0;i--){
			System.out.println(Math.random()*10);
			int j=(int)Math.random()*10%i;
			t=x[j];
			x[j]=x[i];
			x[i]=t;
		}
		for(int h: x){
			System.out.println(h);
		}
	}
	

}
