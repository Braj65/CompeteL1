package com.codeChefMedium;

public class BytelandGoldCoins {
	
	public static void main(String[] args){
		BytelandGoldCoins q=new BytelandGoldCoins();
		int i=2;
		int a=(int)q.divider2(i);
		int b=(int)q.divider3(i);
		int c=(int)q.divider4(i);
		
		if(a+b+c>=i){
			System.out.println(a+b+c);
		}
		else{
			System.out.println(i);
		}
		
		
	}
	
	public double divider2(int x){
		return Math.floor(x/2);
	}
	
	public double divider3(int x){
		return Math.floor(x/3);
	}
	
	public double divider4(int x){
		return Math.floor(x/4);
	}


}
