package com.codeChefMedium.Recurse_DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ConnectingSoldiersSmallSol {
	static int arr[] = new int[31];

	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i, j, n, m, r, max;
		arr[1] = 2;
		for (n = 2; n <= 30; n++)
			arr[n] = min(n, 0, n + 1);
		int t = Integer.parseInt(br.readLine());
		for (i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			max = ((n * n + 3 * n) / 2);
			if (m > max)
				r = m - max;
			else if (m < arr[n])
				r = -1;
			else
				r = 0;
			System.out.println(r);
		}
	}

	public static int min(int num, int l, int u) {
		if (num > 0) {
			int m = (l + u) / 2;
			if (arr[num] != 0)
				return (arr[num]);
			else
				return ((num + 1) + min(m - l - 1, l, m - 1) + min(u - m - 1, m + 1, u));
		}
		return (0);
	}

}
