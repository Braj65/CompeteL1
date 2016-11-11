package com.codeChefMedium.Recurse_DP.Knapsack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class KnapsackEdiSol {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int len = Integer.parseInt(st.nextToken());
		int tots = 0;
		ArrayList<Integer> one = new ArrayList<Integer>();
		ArrayList<Integer> two = new ArrayList<Integer>();
		for (int i = 0; i < len; i++) {
			st = new StringTokenizer(br.readLine());
			if (Integer.parseInt(st.nextToken()) == 1) {
				one.add(Integer.parseInt(st.nextToken()));
				tots = tots + 1;
			} else {
				two.add(Integer.parseInt(st.nextToken()));
				tots = tots + 2;
			}

		}
		Collections.sort(one);
		Collections.sort(two);
		Integer[] ones = one.toArray(new Integer[one.size()]);
		Integer[] twos = two.toArray(new Integer[two.size()]);
		int[] ans = new int[tots + 1];

		int twoPointer = twos.length - 1;
		int onePointer = ones.length - 1;
		int prev = 0;

		for (int i = 2; i <= tots; i += 2) {
			if (twoPointer < 0) {
				if (onePointer >= 1)
					ans[i] = prev + ones[onePointer] + ones[onePointer - 1];
				else
					ans[i] = prev + ones[onePointer];
				prev = ans[i];
				onePointer = onePointer - 2;
			} else if (onePointer <= 0) {
				ans[i] = prev + twos[twoPointer];
				prev = ans[i];
				--twoPointer;
			} else {
				if (twos[twoPointer] >= ones[onePointer] + ones[onePointer - 1]) {
					ans[i] = prev + twos[twoPointer];
					prev = ans[i];
					--twoPointer;
				} else {
					if (onePointer >= 1)
						ans[i] = prev + ones[onePointer] + ones[onePointer - 1];
					else
						ans[i] = prev + ones[onePointer];
					prev = ans[i];
					onePointer = onePointer - 2;
				}
			}
		}

		twoPointer = twos.length - 1;
		onePointer = ones.length - 2;
		if (!(onePointer < -1)) {
			ans[1] = ones[ones.length - 1];
			prev = ans[1];
			for (int i = 3; i <= tots; i += 2) {
				if (twoPointer < 0) {
					if (onePointer >= 1)
						ans[i] = prev + ones[onePointer] + ones[onePointer - 1];
					else
						ans[i] = prev + ones[onePointer];
					prev = ans[i];
					onePointer = onePointer - 2;
				} else if (onePointer <= 0) {
					ans[i] = prev + twos[twoPointer];
					prev = ans[i];
					--twoPointer;
				} else {
					if (twos[twoPointer] >= ones[onePointer] + ones[onePointer - 1]) {
						ans[i] = prev + twos[twoPointer];
						prev = ans[i];
						--twoPointer;
					} else {
						if (onePointer >= 1)
							ans[i] = prev + ones[onePointer] + ones[onePointer - 1];
						else
							ans[i] = prev + ones[onePointer];
						prev = ans[i];
						onePointer = onePointer - 2;
					}
				}
			}
		}

		for (int i = 1; i < ans.length; i++) {
			if (ans[i] != 0) {
				if (ans[i - 1] > ans[i])
					ans[i] = ans[i - 1];
				pw.print(ans[i] + " ");
			} else {
				ans[i] = ans[i - 1];
				pw.print(ans[i] + " ");
			}

		}
		pw.flush();
	}

	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

}

/*5
1 12
2 1
1 2
1 2
1 3
12 15 17 19 19 20 

5
2 1 
2 2 
2 3 
2 4 
2 5
0
 5
 5
 9
 9
 12
 12
 14
 14
 15

5
1 1
1 2
1 3
1 4
1 5
 5
 9
 12
 14
 15

5
1 34
2 4
1 2
2 0
2 22
 34
 36
 56
 58
 60
 62
 62
 62

4
1 4
2 4
1 5
2 5
5 9 10 14 14 18


5
1 4
1 4
1 4
2 5
2 5
4 8 12 13 17 18 22 

5
1 5
1 5
1 5
2 4
2 4
5 10 15 15 19 19 23
\\\\
5
1 6
1 6
1 6
2 6
2 6
6 12 18 18 24 24 30 
\\\\\
7
1 6
1 7
1 9
1 12
2 2
2 4
2 5
12 21 28 34 34 39 39 43 43 45

\\\\\
6
1 6
1 4
1 2
2 12
2 9
2 7
6 12 18 22 27 31 34 38 40
\\\\\
5
1 8
2 4
2 0
2 5
2 3
8 8 13 13 17 17 20 20 20  

5
1 5
1 6
1 7
2 10
2 12
7 13 19 25 30 35 40

5
1 12
2 6
2 7
2 8
2 9
12 12 21 21 29 29 36 36 42

5
2 12
1 6
1 7
1 8
1 9
9 17 24 30 36 42*/
