package com.codeChefMedium.Greedy.IntervalScheduling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SportStadium_STADIUM {
	static Integer[] endArr=null;
	public static void main(String[] args) throws Exception {
		SportStadium_STADIUM x=new SportStadium_STADIUM();
		ClassLoader classloader = Thread.currentThread().getClass().getClassLoader();
		InputStreamReader input = new InputStreamReader(
				classloader.getSystemResourceAsStream("com/codeChefMedium/STADIUM.txt"));
		BufferedReader br=new BufferedReader(input);
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		Integer[] startArr=new Integer[n];
		endArr=new Integer[n];
		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			startArr[i]=Integer.parseInt(st.nextToken());
			endArr[i]=startArr[i]+Integer.parseInt(st.nextToken());
		}
		Integer[] startOrder=new Integer[n];
		for(int j=0;j<n;j++){
			startOrder[j]=j;
		}
		Arrays.sort(startOrder, new Valcomparator());
		int temp=0;
		for(int k=0;k<n;k++){
			startOrder[k]=startArr[startOrder[k]];
		}
		Arrays.sort(endArr);
		System.out.println(x.counter(startOrder, endArr, 0, 1));
	}
	
	public int counter(Integer[] startOrder, Integer[] endArr, int start, int count){
		int end=endArr[start];
		for(int i=start+1; i<=endArr.length-1;i++){
			if(end<startOrder[i]){
				++count;
				end=endArr[i];
			}
		}
		return count;
	}
	
	static class Valcomparator implements Comparator<Integer>{		
		public int compare(Integer a, Integer b){
			return endArr[a].compareTo(endArr[b]);
		}
	}

}
