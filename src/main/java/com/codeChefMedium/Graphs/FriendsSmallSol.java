package com.codeChefMedium.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.BitSet;

public class FriendsSmallSol {
	 public static void main(String args[]) throws IOException {
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 PrintWriter out=new PrintWriter(System.out);
		 int n=Integer.parseInt(br.readLine());
		 BitSet b[]=new BitSet[n];
		 boolean isFriend[][]=new boolean[n][n];
		  
		 for(int i=0;i<n;i++){
		 String s=br.readLine();
		 b[i]=new BitSet();
		 for(int j=0;j<n;j++){
		 if(s.charAt(j)=='1'){
		 isFriend[i][j]=true;
		 b[i].set(j);
		 }
		 }
		 }
		 int count=0;
		 for(int i=0;i<n-1;i++){
		 for(int j=i+1;j<n;j++){
		 if(!isFriend[i][j] && b[j].intersects(b[i])){
		 count+=2;
		 }
		 }
		 }
		 out.println(count);
		 out.flush();out.close();
		 }

}
