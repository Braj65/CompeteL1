package com.codeChefMedium.Greedy.IntervalScheduling;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class SportStadium_STADIUMRec {
	static Integer[] endArr = null;

	public static void main(String[] args) throws Exception {
		SportStadium_STADIUMRec x = new SportStadium_STADIUMRec();
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
		Arrays.sort(startOrder, new Valcompare());
		int temp = 0;
		for (int k = 0; k < n; k++) {
			startOrder[k] = startArr[startOrder[k]];
		}
		// System.out.println();
		Arrays.sort(endArr);
		System.out.println(x.execute(startOrder, endArr, 0, 1, endArr[0]));
	}

	public int execute(Integer[] startOrder, Integer[] endArr, int pos, int count, Integer end) {
		if (pos == startOrder.length-1) {
			if(endArr[pos]!=end){
				if(end<startOrder[pos])
					return ++count;
				else
					return count;
			}else
				return count;
		}
		if (end >= startOrder[pos + 1]) {
			return execute(startOrder, endArr, pos + 1, count, end);
		} else {
			return max(execute(startOrder, endArr, pos + 1, ++count, endArr[pos + 1]),
					execute(startOrder, endArr, pos + 1, count-1, end));
		}
	}

	public static int max(int a, int b) {
		return a > b ? a : b;
	}
	
	static class Valcompare implements Comparator<Integer>{		
		public int compare(Integer a, Integer b){
			return endArr[a].compareTo(endArr[b]);
		}
	}

}
