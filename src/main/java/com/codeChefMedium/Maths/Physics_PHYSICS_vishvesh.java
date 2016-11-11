package com.codeChefMedium.Maths;

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Physics_PHYSICS_vishvesh{
	public static void main(String[] args) throws java.lang.Exception {
		// your code goes
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int p = 0; p < T; p++) {
			String line = br.readLine();
			String[] h = line.split(" ");
			int N = Integer.parseInt(h[0]);
			int F = Integer.parseInt(h[1]);
			line = br.readLine();
			h = line.split(" ");
			int[] a = new int[N];
			HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(h[i]);
				m.compute(a[i], (key, val) -> {
					if (val == null)
						return 1;
					else
						return val + 1;
				});
			}
			long ans = 0;
			for (Map.Entry<Integer, Integer> me : m.entrySet()) {
				int key = me.getKey();
				int value = me.getValue();
				ans = ans + (value * (value - 1)) / 2;
				while (key % F == 0) {
					key = key / F;
					// System.out.println(key);
					if (m.containsKey(key)) {
						long temp = value * m.get(key);
						// System.out.println(temp);
						ans = ans + temp;
					}
				}
			}
			System.out.println(ans);
		}
	}
}
