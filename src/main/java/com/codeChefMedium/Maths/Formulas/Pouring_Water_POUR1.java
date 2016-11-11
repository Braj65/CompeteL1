package com.codeChefMedium.Maths.Formulas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Pouring_Water_POUR1 {
	
//
//1) int fill1=0, fill2=0, capa1=9, capa2=4, int target=6
//2) if(capa1>target) fill1=capa1 else fill2=capa2
//2) while(fill1!=target){
//               if(fill1!=0)
//                              fill2=0;
//               else
//                              fill1=capa1;
//               if(fill1>capa2)
//                              fill1=fill1-(capa2-fill2);     fill2=capa2;
//               else
//                              fill2=fill1;             fill1=0;
	
	 static int gcd(int a, int b){
		 if(b==0) return a;
		 	return gcd(b, a%b);
		 }
		 static int solve(int a, int b, int c){
			 int x = 0;
			 int y = 0;
			 int s = 0;
			 while(x!=c && y!=c){
				 if(x==0){
					 x=a;
					 s+=1;
				 }
				 else if(y==b){
					 y=0;
					 s+=1;
				 }
				 else if(x != 0){
		 // if( x < b-y){
		 // y+=x;
		 // x=0;
		 // }else{
		 // x -= (b-y);
		 // y=b;
		 // }
					 int tmp = x;
					 x = Math.max(0, x+y-b);
					 y = Math.min(b, y+tmp);
					 s+=1;
				 }
			 }
			 return s;
		 }
		 public static void main(String[] args) throws IOException {
			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
		 //System.out.println((1L*1<<31));
			 int T = Integer.parseInt(br.readLine());
			 while(T-->0){
		 //String[] in = br.readLine().split(" ");
				 int a = Integer.parseInt(br.readLine());
				 int b = Integer.parseInt(br.readLine());
				 int c = Integer.parseInt(br.readLine());
				 if( (c>a && c>b) || (c%gcd(a,b)!=0) ) {
					 bw.append(-1+"\n");
				 }
				 else{
					 int d = Math.min(solve(a,b,c), solve(b,a,c));
					 if(a==c || b==c) d=1;
					 bw.append(d+"\n");
				 }
			 }
			 bw.close();
		 }
		  
		 //tmp = String.format("%.6f %.6f", mm, 0.0);


}
