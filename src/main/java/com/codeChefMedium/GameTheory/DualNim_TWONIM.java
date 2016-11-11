package com.codeChefMedium.GameTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DualNim_TWONIM {
	public static void main(String[] args) throws Exception {
		ClassLoader classloader = Thread.currentThread().getClass().getClassLoader();
		InputStreamReader input = new InputStreamReader(
				classloader.getSystemResourceAsStream("com/codeChefMedium/TWONIM.txt"));
		BufferedReader br = new BufferedReader(input);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int[] inArr = new int[Integer.parseInt(st.nextToken())];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < inArr.length; i++) {
				inArr[i] = Integer.parseInt(st.nextToken());
			}

			int[] xorRes = new int[inArr.length];

			xorRes[xorRes.length - 1] = inArr[inArr.length - 1];
			for (int j = xorRes.length - 2; j >= 0; j--) {
				xorRes[j] = xorRes[j + 1] ^ inArr[j];
			}
			// System.out.println();
			if (xorRes[0] == 0) {
				System.out.println("First");
			} else {
				if (inArr.length % 2 == 0)
					System.out.println("First");
				else
					System.out.println("Second");
			}

		}

	}

}
