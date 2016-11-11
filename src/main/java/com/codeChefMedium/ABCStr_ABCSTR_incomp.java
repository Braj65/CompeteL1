package com.codeChefMedium;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ABCStr_ABCSTR_incomp {

	public static void main(String[] args) throws Exception {

		BufferedReader inBuf = new BufferedReader(new InputStreamReader(
				System.in));
		String in = inBuf.readLine();
		char[] inArr = in.toCharArray();
		HashMap<Integer, Integer> outer = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> inner = new HashMap<Integer, Integer>();

		for (int i = 0; i < inArr.length; i++) {
			if (outer.get((int) inArr[i]) != null) {
				outer.put((int) inArr[i],
						outer.get((int) inArr[i]) + 1);
			} else {
				outer.put((int) inArr[i], 1);
			}

			for (int j = 0; j <= i; j++) {
				if (inner.get((int) inArr[j]) != null) {
					inner.put((int) inArr[j],
							inner.get((int) inArr[j]) + 1);
				} else {
					inner.put((int) inArr[j], 1);
				}
				if(inner.get(65)!=null && inner.get(66)!=null && inner.get(67)!=null){
					
					if (inner.get(65) - inner.get(66) == outer.get(65)
							- outer.get(66)
							&& inner.get(65) - inner.get(67) == outer.get(65)
									- outer.get(67)) {
						System.out.print("A-"+inner.get(65));
						System.out.print("B-"+inner.get(66));
						System.out.print("C-"+inner.get(67));
						System.out.println("j to i"+j+" "+i);
					}
				}				
			}
			inner.clear();
		}

	}
}
