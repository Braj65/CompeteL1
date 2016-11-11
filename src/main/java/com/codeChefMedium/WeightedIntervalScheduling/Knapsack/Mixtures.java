package com.codeChefMedium.WeightedIntervalScheduling.Knapsack;

public class Mixtures {
	
	public static void main(String[] args){
		int[] input={5, 7, 4, 8, 2};
		
		int a=10-input[0];
		int smallestPos=a-input[1];
		int smallest=1;
		for(int i=2;i<input.length;i++){
			if((a-input[i])<smallest){
				smallest=a-input[i];
				smallestPos=i;
			}			
		}
		
		
	}

}
