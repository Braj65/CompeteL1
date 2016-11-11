package com.codeChefMedium.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MikeTask_MIKE2 {
	public static void main(String[] args) throws Exception {
		ClassLoader cls = Thread.currentThread().getClass().getClassLoader();
		InputStreamReader in = new InputStreamReader(cls.getSystemResourceAsStream("com/codeChefMedium/MIKE2.txt"));
		BufferedReader br = new BufferedReader(in);
		// BufferedReader br=new BufferedReader(new
		// InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(str.nextToken());
		int tots = Integer.parseInt(str.nextToken());
		int[] inputs = new int[size];
		str = new StringTokenizer(br.readLine());
		int cumSum = 0;
		for (int i = 0; i < size; i++) {
			inputs[i] = Integer.parseInt(str.nextToken());
			cumSum = cumSum + inputs[i];
		}
		Arrays.sort(inputs);
		int succ = 0;
		int fail = 0;
		int skip = 0;

		/*
		 * int[] success=new int[size]; int[] neutral=new int[size]; int[]
		 * failed=new int[size];
		 */
		int ans = 0;
		if (cumSum > tots) {
			cumSum = cumSum - tots;
			for (int i = 0; i < size; i++) {
				if (cumSum >= inputs[i]) {

				} else {
					if (Math.ceil(inputs[i] / 2.0) >= cumSum) {

					} else {

					}
				}
			}
			System.out.println(failed[ans] + " " + success[ans]);
		} else {
			succ = size;
			System.out.println(0 + " " + succ);
		}

	}

}
