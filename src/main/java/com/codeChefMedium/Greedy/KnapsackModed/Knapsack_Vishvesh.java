package com.codeChefMedium.Greedy.KnapsackModed;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Knapsack_Vishvesh {

	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// System.out.println(br.readLine());
		int N = Integer.parseInt(br.readLine());
		// int N = sc.nextInt();
		long[] one = new long[N];
		long[] two = new long[N];
		int count = 0, countb = 0;
		long sum = 0;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			if (line.charAt(0) == '1') {
				one[count] = Long.parseLong(line.substring(2));
				count++;
				sum++;
			} else {
				two[countb] = Long.parseLong(line.substring(2));
				sum = sum + 2;
				countb++;
			}
		}
		Arrays.sort(one, 0, count);
		Arrays.sort(two, 0, countb);
		int k = (int) sum;
		long[] aans = new long[k + 1];
		aans[0] = 0;
		int c = count;
		int d = countb;
		long[] oned = Arrays.copyOf(one, c + 1);
		long[] twod = Arrays.copyOf(two, d + 1);
		long ans = 0;
		for (int i = 2; i <= sum; i = i + 2) {
			long temp = 0, temp1 = 0;
			if (count > 0)
				temp = one[count - 1];
			if (count > 1) {
				temp = one[count - 2] + temp;
			}
			if (countb > 0)
				temp1 = two[countb - 1];
			if (temp < temp1) {
				ans = ans + temp1;
				if (countb > 0) {
					countb--;
				}
			} else {
				ans = ans + temp;
				if (count > 1)
					count = count - 2;
				else if (count > 0)
					count--;
			}
			aans[i] = ans;
		}
		if (c > 0) {
			aans[1] = oned[c - 1];
			c--;
		} else {
			aans[1] = 0;
		}
		one = oned;
		two = twod;
		count = c;
		countb = d;
		ans = aans[1];
		for (int i = 3; i <= sum; i = i + 2) {
			long temp = 0, temp1 = 0;
			if (count > 0)
				temp = one[count - 1];
			if (count > 1) {
				temp = one[count - 2] + temp;
			}
			if (countb > 0)
				temp1 = two[countb - 1];
			if (temp < temp1) {
				ans = ans + temp1;
				if (countb > 0) {
					countb--;
				}
			} else {
				ans = ans + temp;
				if (count > 1)
					count = count - 2;
				else if (count > 0)
					count--;
			}
			aans[i] = ans;
		}
		for (int i = 1; i <= sum; i++) {
			System.out.print(aans[i] + " ");
		}
	}

}
