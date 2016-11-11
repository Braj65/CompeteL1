package com.codeChefMedium.Greedy.IntervalScheduling;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SportStadium_STADIUMVishvesh {

	public static class Node implements Comparable<Node> {
		int start, end;

		public int compareTo(Node n) {
			if (n.end > end)
				return -1;
			else
				return 1;
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Node[] n = new Node[N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			String[] h = line.split(" ");
			Node nn = new Node();
			nn.start = Integer.parseInt(h[0]);
			nn.end = nn.start + Integer.parseInt(h[1]);
			n[i] = nn;
		}
		Arrays.sort(n);
		int count = 1;
		int end = n[0].end;
		for (int i = 1; i < N; i++) {
			if (n[i].start > end) {
				count++;
				end = n[i].end;
			}
		}
		System.out.println(count);
	}

}
