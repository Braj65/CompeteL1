package com.codeChefMedium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PlayWords_WORDS_xvetox {


	static boolean[][] edge;
	static boolean[] reached;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(in.readLine());
			int[] outDegree = new int['z' - 'a' + 1];
			int[] inDegree = new int[outDegree.length];
			edge = new boolean[outDegree.length][outDegree.length];
			for (int n = 0; n < N; n++) {
				String word = in.readLine();
				int s = word.charAt(0) - 'a';
				int e = word.charAt(word.length() - 1) - 'a';
				outDegree[s]++;
				inDegree[e]++;
				edge[s][e] = true;
			}
			int start = -1;
			boolean end = false;
			boolean ok = true;
			// check degrees
			for (int i = 0; i < outDegree.length; i++) {
				int diff = outDegree[i] - inDegree[i];
				if (diff == 1) {
					if (start != -1) {
						ok = false;
						break;
					} else {
						start = i;
					}
				} else if (diff == -1) {
					if (end) {
						ok = false;
						break;
					} else {
						end = true;
					}
				} else if (diff != 0) {
					ok = false;
					break;
				}
			}
			if (ok) {
				// check connectivity
				reached = new boolean[outDegree.length];
				if (start == -1) {
					start = 0;
				}
				reach(start);
				for (int i = 0; i < reached.length; i++) {
					if (inDegree[i] != 0 && !reached[i]) {
						ok = false;
						break;
					}
				}
			}
			out.println(ok ? "Ordering is possible."
					: "The door cannot be opened.");
		}
		out.close();
	}

	static void reach(int start) {
		if (reached[start])
			return;
		reached[start] = true;
		for (int i = 0; i < reached.length; i++) {
			if (edge[start][i]) {
				reach(i);
			}
		}
	}



}
