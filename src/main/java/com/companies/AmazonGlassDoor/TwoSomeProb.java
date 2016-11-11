package com.trgr.AmazonGlassDoor;

import java.util.HashMap;
import java.util.Map;

public class TwoSomeProb {
	
	public static void main(String[] args){
		int[] arr={14, 4, 2, 1, 12, 14, 18};
		adder(arr, 14);
	}
	
	public static void adder(int[] arr, int target){
		Map<Integer, Integer> m=new HashMap<Integer, Integer>();
		for(int i=0;i<arr.length;i++){
			if(m.get(arr[i])!=null){
				System.out.println(i);
				System.out.println(m.get(arr[i]));
			}else{
				m.put(target-arr[i], i);
			}
		}
	}

}
