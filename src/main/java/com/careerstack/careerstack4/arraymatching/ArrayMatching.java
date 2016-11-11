package com.trgr.careerstack4.arraymatching;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class ArrayMatching {
	
	int[] arr1={2, 9, 4, 6, 8, 24, 55, 33, 12, 9, 12, 33, 4};
	int[] arr2={2, 9, 4, 6, 8, 24, 55, 33, 12, 9, 12, 33, 8};
	
	public static void main(String[] args){
		ArrayMatching obj1=new ArrayMatching();
		System.out.println(obj1.sol1SumProduct());
		System.out.println(obj1.sol2Hash());
	}
	
	public boolean sol1SumProduct(){
		int mulRes1=1, mulRes2=1;
		int sumRes1=0, sumRes2=0;
		for(int x: arr1){
			mulRes1=mulRes1*x;
			sumRes1=sumRes1+x;
		}
		for(int y: arr2){
			mulRes2=mulRes2*y;
			sumRes2=sumRes2+y;
		}
		
		if(mulRes1==mulRes2 && sumRes1==sumRes2)
			return true;
		
		return false;
	}
	
	public boolean sol2Hash(){
		Map<Integer, Integer> hash1=new HashMap<Integer, Integer>();
		int count=0;
		int gcount=0;
		for(int x: arr1){
			if(hash1.get(x)!=null)
				count=hash1.get(x);
			hash1.put(x, ++count);
			count=0;
			++gcount;
		}
		
		for(int y: arr2){
			if((count=hash1.get(y))>0){
				hash1.put(y, --count);
				--gcount;
			}				
		}
		
		Collection<Integer> re=hash1.values();
		for(int x: re){
			if(x>0)
				return false;
		}
		return true;
	}

}
