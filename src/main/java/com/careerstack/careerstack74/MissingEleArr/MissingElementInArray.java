package com.trgr.careerstack74.MissingEleArr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class MissingElementInArray {
	
	public static void main(String[] args){
		Integer[] arr1={1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//		List<Integer> arr1=new ArrayList<Integer>();
		List<Integer> x=Arrays.asList(arr1);
		List<Integer> y=new LinkedList<Integer>(x);
		Integer sum=0;
		Integer mult=1;
		for(Integer q:x){
			sum=sum+q;
			mult=mult*q;
		}
		System.out.println(Math.random()*9);
		Double d=Math.random()*9;
		y.remove(d.intValue());
		
		Integer s=0;
		Integer m=1;
		for(Integer r:y){
			s=s+r;
			m=m*r;
		}
		int n=sum-s;
		System.out.println(n);
	}

}
