package com.codeChefMedium.Greedy.IntervalScheduling;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class SportStadium_STADIUMDP {
	
	static Integer[] endArr = null;

	public static void main(String[] args) throws Exception {
		SportStadium_STADIUMDP x = new SportStadium_STADIUMDP();
		ClassLoader classloader = Thread.currentThread().getClass().getClassLoader();
		InputStreamReader input = new InputStreamReader(
				classloader.getSystemResourceAsStream("com/codeChefMedium/STADIUM.txt"));
		BufferedReader br = new BufferedReader(input);
		// BufferedReader br=new BufferedReader(new
		// InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		Integer[] startArr = new Integer[n];
		endArr = new Integer[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			startArr[i] = Integer.parseInt(st.nextToken());
			endArr[i] = startArr[i] + Integer.parseInt(st.nextToken()) - 1;
		}
		Integer[] startOrder = new Integer[n];
		for (int j = 0; j < n; j++) {
			startOrder[j] = j;
		}
		Arrays.sort(startOrder, new Valcompar());
		int temp = 0;
		for (int k = 0; k < n; k++) {
			startOrder[k] = startArr[startOrder[k]];
		}
		// System.out.println();
		Arrays.sort(endArr);
		int[][] jobVsCnt=new int[n][n];
		x.execute(startOrder, endArr, jobVsCnt);
		System.out.println(jobVsCnt[n-1][n-1]);
		
	}
	
	public void execute(Integer[] startOrder, Integer[] endArr, int[][] jobVsCnt){		
		for(int k=0;k<startOrder.length;k++){
			jobVsCnt[0][k]=1;
		}
		
		for(int i=1;i<startOrder.length;i++){
			int pj=0;
			for(int j=0;j<startOrder.length;j++){
				if(startOrder[i]>endArr[j]){
					pj=jobVsCnt[j][j];
					jobVsCnt[i][j]=1+pj;
				}else{
					jobVsCnt[i][j]=Math.max(1+pj, jobVsCnt[i-1][j]);
				}
			}
		}
	}
	
	static class Valcompar implements Comparator<Integer>{		
		public int compare(Integer a, Integer b){
			return endArr[a].compareTo(endArr[b]);
		}
	}

}
