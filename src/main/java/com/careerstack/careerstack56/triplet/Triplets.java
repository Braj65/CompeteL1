package com.trgr.careerstack56.triplet;

import java.util.ArrayList;
import java.util.List;

import com.trgr.careerstack15.quickSort.QuickSort;

public class Triplets {
	
	public static void main(String[] args){
		int[] arr={5, 12, 18, 13, 7, 3, 1, 2, 16, 4};
		QuickSort.quicker(arr, 0, arr.length-1);
		Triplets obj=new Triplets();
		obj.checker(arr, obj.juggler(arr));
		
	}
	
	public List<Double> juggler(int[] arr){
		List<Double> doubleSum=new ArrayList<Double>();
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				doubleSum.add(Math.pow(arr[i], 2)+Math.pow(arr[j], 2));
			}
		}
		return doubleSum;
	}
	
	public void checker(int[] arr, List<Double> jug){
		Double x;
		for(int i=0;i<arr.length;i++){
			x=Math.pow(arr[i], 2);
			if(jug.contains(x)){
				System.out.println(arr[i]);
			}
		}
	}

}
