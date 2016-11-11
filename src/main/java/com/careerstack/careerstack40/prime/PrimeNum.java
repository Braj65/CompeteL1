package com.trgr.careerstack40.prime;

public class PrimeNum {
	
	public static void main(String[] args){
		prim(10);
	}
	
	public static void prim(int n){
		int res=0;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=i;j++){
				if(i%j==0){
					res=res+(i/j);
				}
			}
			if(res==(i+1))
				System.out.println(i);
			res=0;
		}
		
	}
}
