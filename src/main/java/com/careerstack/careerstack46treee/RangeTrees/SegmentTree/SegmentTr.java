package com.careerstack.careerstack46treee.RangeTrees.SegmentTree;

import java.util.ArrayList;

public class SegmentTr {

	public static void main(String[] args) {
		SegmentTr t = new SegmentTr();
		Integer[] in = { -1, 2, 4, 0, 5, 6, 7};
		Integer[] segArr = new Integer[t.checkLen(in)];

		t.constructTree(in, segArr, 0, in.length - 1, 0);
		ArrayList<Integer> x = new ArrayList<Integer>();
		x = t.findLeafNodes(segArr, 0, x);
		int rangeToFindStart = 1;
		int rangeToFindEnd = 3;
		System.out.println(t.rangeMinQuery(segArr, rangeToFindStart,
				rangeToFindEnd, 0, in.length - 1, 0));
	}

	public void constructTree(Integer[] inArr, Integer[] segArr, int start,
			int end, int pos) {
		if (start == end) {
			segArr[pos] = inArr[start];
			return;
		}
		int mid = (start + end) / 2;
		constructTree(inArr, segArr, start, mid, 2 * pos + 1);
		constructTree(inArr, segArr, mid + 1, end, 2 * pos + 2);
		segArr[pos] = Math.min(segArr[2 * pos + 1], segArr[2 * pos + 2]);

	}

	public Integer rangeMinQuery(Integer[] segArr, int qstart, int qend,
			int start, int end, int pos) {
		Integer x = 0;
		Integer y = 0;
		int mid = (start + end) / 2;
		String overLap = checkOverlap(qstart, qend, start, end);
		if ("no".equals(overLap)) {
			y = Integer.MAX_VALUE;
			return y;
		} else if ("total".equals(overLap)) {
			x = segArr[pos];
			return x;
		} else {
			x = rangeMinQuery(segArr, qstart, qend, start, mid, 2 * pos + 1);
			y = rangeMinQuery(segArr, qstart, qend, mid + 1, end, 2 * pos + 2);
		}
		return Math.min(x, y);
	}

	public String checkOverlap(int qstart, int qend, int start, int end) {
		if (qstart <= start && qend >= end) {
			return "total";
		} else if (qend < start || end < qstart) {
			return "no";
		} else
			return "partial";
	}

	public int checkLen(Integer[] arr) {
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

	public ArrayList<Integer> findLeafNodes(Integer[] segArr, int pos,
			ArrayList<Integer> leafPos) {
		if (2 * pos + 1 > segArr.length - 1 || 2 * pos + 2 > segArr.length - 1
				|| segArr[2 * pos + 1] == null || segArr[2 * pos + 1] == null) {
			
				leafPos.add(pos);
				return leafPos;
		}

		findLeafNodes(segArr, 2 * pos + 1, leafPos);
		findLeafNodes(segArr, 2 * pos + 2, leafPos);

		return leafPos;
	}

}
