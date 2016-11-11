package com.trgr.careerstack95.DistinctArray;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class NonRepeatArrayEle {
	
	public static void main(String[] args){
		int[] arr={3, 4, 1, 3, 1, 7, 2, 2, 4};
		jam(arr);
	}
	
	public static void jam(int[] arr){
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		int count=0;
		for(int s:arr){
			if(map.get(s)!=null)
				count=map.get(s);			
			map.put(s, ++count);
			count=0;
		}
		
		Collection<Integer> ci=map.values();
		for(Integer x:ci){
			System.out.println(x);
		}
	}

}
