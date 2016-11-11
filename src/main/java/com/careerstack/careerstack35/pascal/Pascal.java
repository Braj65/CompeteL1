package com.trgr.careerstack35.pascal;

import java.util.ArrayList;
import java.util.List;

public class Pascal {
	
	public static void main(String[] args){
		jammer(9);
	}
	
	public static void jammer(int n){
		int j;
		List<Integer> x=new ArrayList<Integer>();
		List<Integer> y=new ArrayList<Integer>();
		x.add(1);
		int temp1;
		int temp2;
		for(int i=0;i<n;i++){
			
			j=i;
			while(n-j-1!=0){
				System.out.print("X");
				++j;
			}
			
			y.add(x.get(0));			
			for(int k=1;k<i;k++){
				y.add(k, x.get(k-1)+x.get(k));
			}
			if(i>=1)
				y.add(x.get(x.size()-1));
				
			
			x.clear();
			x.addAll(y);
			int h=x.size();
			for(Integer d:y)
				System.out.print(d);
			y.clear();
			j=i;
			while(n-j-1!=0){
				System.out.print("X");
				++j;
			}
			System.out.println();
		}
	}
	
	public static void poochi(int n){
		if(n==0){
			
		}
		else{
			for(int i=0;i<n-1;i++){
				System.out.print(" ");
			}
			for(int j=n;j<n;j--){
				
			}
			
			for(int i=0;i<n-1;i++){
				System.out.print(" ");
			}
		}
	}
}

