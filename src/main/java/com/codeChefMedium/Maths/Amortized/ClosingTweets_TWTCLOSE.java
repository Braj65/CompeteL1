package com.codeChefMedium.Maths.Amortized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ClosingTweets_TWTCLOSE {

	public static void main(String[] args) throws Throwable {
		ClassLoader classLoader = Thread.currentThread().getClass().getClassLoader();
		InputStreamReader in = new InputStreamReader(
				classLoader.getSystemResourceAsStream("com/codeChefMedium/TWTCLOSE.txt"));
		BufferedReader br=new BufferedReader(in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int[] tweets = new int[t + 1];
		int[] clicks = new int[Integer.parseInt(st.nextToken()) + 1];
		for (int i = 1; i < clicks.length; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if ("CLICK".equals(s))
				clicks[i] = Integer.parseInt(st.nextToken());
			else
				clicks[i] = 0;
		}
		int count = 0;
		int last = 0;
		for (int j = 1; j < clicks.length; j++) {
			int cur = clicks[j];
			if (cur != 0) {
				if (tweets[cur] == 0) {
					tweets[cur] = j;
					++count;
				} else {
					if (tweets[cur] > last) {
						tweets[cur] = 0;
						--count;
					} else {
						tweets[cur] = j;
						++count;
					}
				}
			} else {
				count = 0;
				last = j;
			}
			System.out.println(count);
		}
		
	}
}
