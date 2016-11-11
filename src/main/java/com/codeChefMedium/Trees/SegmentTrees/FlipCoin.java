package com.codeChefMedium.Trees.SegmentTrees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FlipCoin {
	//following segment tree algo
	public static void main(String[] args) throws Exception {
		FlipCoin t = new FlipCoin();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
		String[] input = br.readLine().split(" ");
		int[] in = new int[Integer.valueOf(input[0])];
		Integer[] segArr = new Integer[t.checkLen(in)];

		t.constructTree(in, segArr, 0, in.length - 1, 0);
		int nooftests = Integer.parseInt(input[1]);
		while (nooftests-- > 0) {
			String[] offsets = br.readLine().split(" ");
			int rangeStart = Integer.parseInt(offsets[1]);
			int rangeEnd = Integer.parseInt(offsets[2]);
			
			if (Integer.parseInt(offsets[0]) == 0) {
				t.writeVals(segArr, rangeStart, rangeEnd, 0, in.length - 1, 0);
				
			} else {
				System.out.println(t.readCoins(segArr, rangeStart, rangeEnd, 0, in.length-1, 0));
			}
		}
		
		/*int rangeToFindStart = 1;
		int rangeToFindEnd = 3;
		System.out.println(t.rangeMinQuery(segArr, rangeToFindStart,
				rangeToFindEnd, 0, in.length - 1, 0));*/
	}

	public void constructTree(int[] inArr, Integer[] segArr, int start,
			int end, int pos) {
		if (start == end) {
			segArr[pos] = inArr[start];
			return;
		}
		int mid = (start + end) / 2;
		constructTree(inArr, segArr, start, mid, 2 * pos + 1);
		constructTree(inArr, segArr, mid + 1, end, 2 * pos + 2);
		segArr[pos] = segArr[2 * pos + 1] + segArr[2 * pos + 2];

	}

	public void writeVals(Integer[] segArr, int qstart, int qend, int start,
			int end, int pos) {
		Integer x=0;
		Integer y=0;
		int mid=(start+end)/2;
		
		String overlap=checkOverlap(qstart, qend, start, end);
		if(start==end){
			if("total".equals(overlap)){
				segArr[pos]=segArr[pos]^1;
				int parent=(pos-1)/2;
				while(parent!=0){
					segArr[parent]=segArr[2*parent+1]+segArr[2*parent+2];
					parent=(parent-1)/2;
				}
				segArr[parent]=segArr[2*parent+1]+segArr[2*parent+2];
			}
			return;
			
		}
		else{
			writeVals(segArr, qstart, qend, start, mid, 2*pos+1);
			writeVals(segArr, qstart, qend, mid+1, end, 2*pos+2);
		}
		
	}

	public Integer readCoins(Integer[] segArr, int qstart, int qend, int start,
			int end, int pos) {
		Integer x = 0;
		Integer y = 0;
		int mid = (start + end) / 2;
		String overlap = checkOverlap(qstart, qend, start, end);
		if ("no".equals(overlap)) {
			return 0;
		} else if ("total".equals(overlap)) {
			x = segArr[pos];
			return x;
		} else {
			x = readCoins(segArr, qstart, qend, start, mid, 2 * pos + 1);
			y = readCoins(segArr, qstart, qend, mid + 1, end, 2 * pos + 2);
		}
		return x + y;
	}

	/*public ArrayList<Integer> findLeafNodes(Integer[] segArr, int pos,
			ArrayList<Integer> leafPos) {
		if (2 * pos + 1 > segArr.length - 1 || 2 * pos + 2 > segArr.length - 1
				|| segArr[2 * pos + 1] == null || segArr[2 * pos + 1] == null) {
			leafPos.add(pos);
			return leafPos;
		}

		findLeafNodes(segArr, 2 * pos + 1, leafPos);
		findLeafNodes(segArr, 2 * pos + 2, leafPos);

		return leafPos;
	}*/

	public String checkOverlap(int qstart, int qend, int start, int end) {
		if (qstart <= start && qend >= end) {
			return "total";
		} else if (qend < start || end < qstart) {
			return "no";
		} else
			return "partial";
	}

	public int checkLen(int[] arr) {
		int len = arr.length;

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
