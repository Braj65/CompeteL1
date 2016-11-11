package com.trgr.careerstack62.unsignedInt;

public class BitsinUnsignedInt {
	
	public static void main(String[] args){
		int i=11;
		System.out.println(Integer.toBinaryString(i));
		String x=new String(Integer.toBinaryString(i));
		char[] y=x.toCharArray();
		int j=0;
		for(char t:y){
			if(t=='1')
				++j;
		}
		
		System.out.println(j);
		count(i);
		System.out.println(Integer.parseInt("11111111111111111111111111110101", 2));
	}
	
	public static void count(int x){
		int tot=0;
		while(x!=0){
			x=x&(x-1);
			System.out.println(x);
			++tot;
		}
		System.out.println(tot);
	}

}
