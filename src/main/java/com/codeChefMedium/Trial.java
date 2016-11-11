package com.codeChefMedium;

import java.util.Arrays;
import java.util.Comparator;

public class Trial {
	static Integer[] in={3, 2, 5, 1, 8};
	public static void main(String[] args) {
		System.out.println(42%100);
		System.out.println(1%5);
		System.out.println(1/5);
		System.out.println(4228/100);
		char x='c';
		System.out.println((int)x-97);
		System.out.println(0/2);
		System.out.println("----------------------");
		
		
		Integer[] order=new Integer[in.length];
		for(int i=0;i<order.length;i++){
			order[i]=i;
		}
		Arrays.sort(order, new valComparator());
		for(Integer r: order){
			System.out.println(r);
		}
		
		Trial t=new Trial();
		t.merge(in, 0, in.length-1);
		
		Integer[][] xArr={{2,4}, {1,5},{6,7}, {3,98}};
		Arrays.sort(xArr, new twoD());
		System.out.println(xArr.length);
		
		System.out.println("----------------");
		System.out.println(1&4&5);
		
	}
	
	public static void unsortPos(){
		int[] in={3, 2, 5, 1, 8};
		int n=in.length;
		int[] order=new int[in.length];
		int[] sortOrder=new int[in.length];
		for(int i=0;i<n;i++){
			order[i]=i;
			
		}
		
	}
	
	static class valComparator implements Comparator<Integer>{
		@Override
		public int compare(Integer a, Integer b){
			return in[a.intValue()].compareTo(in[b.intValue()]);
		}
	}
	
	static class twoD implements Comparator<Integer[]>{
		@Override
		public int compare(Integer[] a, Integer[] b){
			return a[0].compareTo(b[0]);
		}
	}
	
	public Integer merge(Integer[] arr, int begin, int end){
		if(begin>end)
			return null;
		Integer mid=(begin+end)/2;
		System.out.println(merge(arr, mid+1, end));
		System.out.println(merge(arr, begin, mid-1));
		return 1000;
	}

}


