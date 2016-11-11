package com.codeChefMedium.BitWise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class PairwiseANDSum {
	
	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
		 //System.out.println((1L*1<<31));
		 int n = Integer.parseInt(br.readLine());
		 String[] in = br.readLine().split(" ");
		 int[] a = new int[n];
		 for(int i=0;i<n;i++){
			 a[i] = Integer.parseInt(in[i]);
		 }
		 long ans = 0;
		 HashMap<Integer, Integer> map = new HashMap<>();
		 for(int i=0;i<32;i++){
			 for(int j=0;j<n;j++){
				 if( (a[j]&(1L*1<<i)) > 0) {
					 if(!map.containsKey(i)){
						 map.put(i, 1);
					 }else{
						 map.put(i,1+map.get(i));
					 }
				 }
			 }
		 }
		 for(Map.Entry<Integer, Integer> item : map.entrySet()){
			 long con = (1L*1<<item.getKey())*(1L*(item.getValue())*(item.getValue()-1))/2;
			 ans+=con;
		 }
		 	bw.append(ans+"\n");
		 	bw.close();
		 }
		  
		 //tmp = String.format("%.6f %.6f", mm, 0.0);

}
