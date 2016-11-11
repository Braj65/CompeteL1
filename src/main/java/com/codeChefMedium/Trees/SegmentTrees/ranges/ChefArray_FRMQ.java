package com.codeChefMedium.Trees.SegmentTrees.ranges;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChefArray_FRMQ {

	public static void main(String[] args) throws Exception {
		ClassLoader cls = Thread.currentThread().getClass().getClassLoader();
		InputStreamReader in = new InputStreamReader(cls.getSystemResourceAsStream("com/codeChefMedium/FRMQ.txt"));
		BufferedReader br = new BufferedReader(in);
		// BufferedReader br=new BufferedReader(new
		// InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(str.nextToken());

		str = new StringTokenizer(br.readLine());
		int[] input = new int[size];
		for (int i = 0; i < size; i++) {
			input[i] = Integer.parseInt(str.nextToken());
		}

		str = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(str.nextToken());
		int x1 = Integer.parseInt(str.nextToken());
		int y1 = Integer.parseInt(str.nextToken());

		//int[] minTree = new int[checkLen(size)];
		int[] maxTree = new int[checkLen(size)];
		
		//constructTree(input, minTree, maxTree, 0, size-1, 0);
		constructTree(input, maxTree, 0, size-1, 0);
		int ans=0;
		if(y1<x1){
			ans=ans+rangeMaxQuery(maxTree, y1, x1, 0, size-1, 0);
		}else{
			ans=ans+rangeMaxQuery(maxTree, x1, y1, 0, size-1, 0);
		}
		
		for(int i=2;i<=M;i++){
			x1=(x1+7)%(size-1);
			y1=(y1+11)%size;
			if(y1<x1){
				ans=ans+rangeMaxQuery(maxTree, y1, x1, 0, size-1, 0);
			}else{
				ans=ans+rangeMaxQuery(maxTree, x1, y1, 0, size-1, 0);
			}			
		}
		System.out.println(ans);
	}

	/*public static void constructTree(int[] inArr, int[] minTree, int[] maxTree, int start, int end, int pos) {
		if (start == end) {
			minTree[pos] = inArr[start];
			maxTree[pos] = inArr[start];
			return;
		} else {
			int mid = (start + end) / 2;
			constructTree(inArr, minTree, maxTree, start, mid, 2 * pos + 1);
			constructTree(inArr, minTree, maxTree, mid + 1, end, 2 * pos + 2);
			minTree[pos]=Math.min(minTree[2 * pos + 1], minTree[2 * pos + 2]);
			maxTree[pos]=Math.max(minTree[2 * pos + 1], minTree[2 * pos + 2]);
		}
	}*/
	
	public static void constructTree(int[] inArr, int[] maxTree, int start, int end, int pos) {
		if (start == end) {
			maxTree[pos] = inArr[start];
			return;
		} else {
			int mid = (start + end) / 2;
			constructTree(inArr, maxTree, start, mid, 2 * pos + 1);
			constructTree(inArr, maxTree, mid + 1, end, 2 * pos + 2);
			maxTree[pos]=Math.max(maxTree[2 * pos + 1], maxTree[2 * pos + 2]);
		}
	}
	
	public static int rangeMinQuery(int[] minTree, int qstart, int qend,
			int start, int end, int pos) {
		int x = 0;
		int y = 0;
		int mid = (start + end) / 2;
		String overLap = checkOverlap(qstart, qend, start, end);
		if ("no".equals(overLap)) {
			y = Integer.MAX_VALUE;
			return y;
		} else if ("total".equals(overLap)) {
			x = pos;
			return x;
		} else {
			x = rangeMinQuery(minTree, qstart, qend, start, mid, 2 * pos + 1);
			y = rangeMinQuery(minTree, qstart, qend, mid + 1, end, 2 * pos + 2);
		}
		return Math.min(x, y);
	}
	
	public static int rangeMaxQuery(int[] maxTree, int qstart, int qend,
			int start, int end, int pos) {
		int x = 0;
		int y = 0;
		int mid = (start + end) / 2;
		String overLap = checkOverlap(qstart, qend, start, end);
		if ("no".equals(overLap)) {
			y = -1;
			return y;
		} else if ("total".equals(overLap)) {
			x = maxTree[pos];
			return x;
		} else {
			x = rangeMaxQuery(maxTree, qstart, qend, start, mid, 2 * pos + 1);
			y = rangeMaxQuery(maxTree, qstart, qend, mid + 1, end, 2 * pos + 2);
		}
		return Math.max(x, y);
	}
	
	public static String checkOverlap(int qstart, int qend, int start, int end) {
		if (qstart <= start && qend >= end) {
			return "total";
		} else if (qend < start || end < qstart) {
			return "no";
		} else
			return "partial";
	}

	public static int checkLen(int len) {
		if ((len & (len - 1)) == 0) {
			return len * 2 - 1;
		} else {
			int n = 1;

			while (n < len) {
				n <<= 1;
			}
			return n * 2 - 1;
		}
	}

}
