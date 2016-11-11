package com.codeChefMedium;

public class PrimePerm_PPERM {
	
	public static void main(String[] agrs){
		int[] prime=new int[101];
		int j=0;
		int k=0;
		for(int i=2;i*i<=100;i++){			
			if(prime[i]==0){
				k=0;
				j=i*i;
				while(j<=100){
					prime[j]=i;
					j=i*i+k*i;
					++k;					
				}
			}			
		}
		System.out.println(" ");
		System.out.println();
	}

}
