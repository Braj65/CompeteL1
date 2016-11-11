package com.trgr.careerstack44.octatodeci;

import java.util.ArrayList;
import java.util.List;

public class OctatoDeci {
	
	public static void main(String[] args){
		int i=56;
		deciToOcta(i);
		System.out.println();
		octaToDeci(70);		
	}
	
	public static void deciToOcta(int i){
		List<Integer> x=new ArrayList<Integer>();
		while(i/8!=0){
			x.add(0, i%8);
			i=i/8;
		}
		x.add(0, i);
		for(Integer u: x){
			System.out.print(u);
		}
	}
	
	public static void octaToDeci(int i){
		int p;
		int sum=0;
		int k=0;
		while(i>0){
			p=i%10;
			sum=sum+p*(int)Math.pow(8, k);
			i=(i-p)/10;
			++k;
		}
		System.out.println(sum);
	}

}
