package com.codeChefMedium.Maths.Subsets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class ANUMLA {
	
	 private static List<Integer> solve(int[] b, int n) {
		 ArrayList<Integer> ret = new ArrayList<>();
		 // ArrayList<Integer> source = new ArrayList<>();
		 //PriorityQueue<Integer> source = new PriorityQueue<>();
		 TreeMap<Integer, Integer> map = new TreeMap<>();
		 for(int i=0;i<b.length;i++){
		 //source.add(b[i]);
		 if(!map.containsKey(b[i])) {
		 map.put(b[i], 1);
		 }else{
		 map.put(b[i], map.get(b[i])+1);
		 }
		 }
		 ArrayList<ArrayList<Integer>> tunnel = new ArrayList<>();
		 while(map.size() > 0){
			 //get smallest
			 int t = map.firstKey();
			 if(map.get(t) == 1){
			 map.remove((Integer)t);
			 }else{
			 map.put(t, map.get(t)-1);
			 }
			 if(t == 0) continue;
			 //System.out.println("smallest "+t);
			 //int i=0;
			 //int tmp = t;
			 ArrayList<Integer> buffer = new ArrayList<>();
			 buffer.add(t);
			 for(int i=0;i<tunnel.size();i++){
				 ArrayList<Integer> dnt = new ArrayList<>();
				 //remove t + tuunel.get(i) and save to buffer
				 for(int j=0;j<tunnel.get(i).size();j++){
					 int y = tunnel.get(i).get(j);
					 int d = t + y;
					 dnt.add(d);
					 if(map.get(d) == 1){
					 map.remove((Integer)d);
					 }else{
					 map.put(d, map.get(d)-1);
					 }
				 }
				 //copy buffer to i
				 for(int j=0;j<buffer.size();j++){
					 tunnel.get(i).add(buffer.get(j));
				 }
				 //copy dnt to buffer
				 buffer = (ArrayList<Integer>)dnt.clone();
			}
			 tunnel.add(buffer);
		 }
		 for(Integer t : tunnel.get(0)){
		 ret.add(t);
		 }
		 return ret;
		 }
		 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
		 int T = Integer.parseInt(br.readLine());
		 while(T-->0){
		 int n = Integer.parseInt(br.readLine());
		 String[] in = br.readLine().split(" ");
		 int[] b = new int[in.length];
		 for(int i=0;i<b.length;i++){
		 b[i] = Integer.parseInt(in[i]);
		 }
		 Arrays.sort(b);
		 List<Integer> ans = solve(b, n);
		 Collections.sort(ans);
		 for(Integer t : ans){
		 bw.append(t+" ");
		 }
		 bw.append("\n");
		 }
		 bw.close();
		 }
		  
		 //tmp = String.format("%.6f %.6f", mm, 0.0);
		  

}
