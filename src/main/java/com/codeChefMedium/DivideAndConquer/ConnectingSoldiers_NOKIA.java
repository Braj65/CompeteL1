package com.codeChefMedium.DivideAndConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/*To find the minimum length of wire start from centre to outwards i.e if soldiers are
12345 then first measure for 3 then 2 and 4 then 1 and 5. The solution for minimum length comes
to be n+(n-1)+(n-1)+(n-2)
For maximum length start from out and go inside. The generalised solution is
(n+1)+n+(n-1)+(n-2)....2*/
public class ConnectingSoldiers_NOKIA {
	
	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
		 ArrayList<ArrayList<Integer>> dp = new ArrayList<>(31);
		 dp.add(new ArrayList<Integer>());
		 
		 dp.add(new ArrayList<Integer>());
		 dp.get(1).add(2);//base case
		 //this method finds all the possible sum of length of ropes when the no. of soldeirs
		 //is 1 ,2 ,3, 4...30. for 1-2, 2- 5, 3-8,9, 4-.....
		 for(int i=2;i<=30;i++){
			 dp.add(new ArrayList<Integer>());
		  
			 int stop = i%2==0 ? i/2 : (i+1)/2;
			 int must = i+1;
			 for(int j=1;j<=stop;j++){
		  
				 ArrayList<Integer> f = new ArrayList<>();
				 ArrayList<Integer> s = new ArrayList<>();
				 if(j-1 > 0){
					 f = (ArrayList<Integer>)dp.get(j-1).clone();
				 }
				 if(i-j > 0){
					 s = (ArrayList<Integer>)dp.get(i-j).clone();
				 }
				 if(j-1 == 0) f.add(0);
				 for(int k=0;k<f.size();k++){
					 for(int t=0;t<s.size();t++){
						 int tmp = must + f.get(k) + s.get(t);
					 // System.out.println(i+" "+tmp);
						 if(!dp.get(i).contains(tmp)) dp.get(i).add(tmp);
					 }
				 }
		 	 }
		 }
		 int T = Integer.parseInt(br.readLine());
		 while(T-->0){
			 String[] in = br.readLine().split(" ");
			 int n = Integer.parseInt(in[0]);
			 int m = Integer.parseInt(in[1]);
			 if(n==1 && m < 2){
				 bw.append(-1+"\n");
				 continue;
			 }
			 else if(n==1){
				 bw.append(m-2+"\n");
				 continue;
			 }
			 int val = -1;
			 for(Integer t : dp.get(n)){
				 if(t > m) continue;
				 else{
					 if(val == -1) val = t;
					 else{
						 if(t > val) val = t;
					 }
				 }
			 }
			 if(val == -1) bw.append(-1+"\n");
			 else{
				 bw.append(m-val+"\n");
			 }
		 	}
		 	bw.close();
		 }  
		 //tmp = String.format("%.6f %.6f", mm, 0.0);

}
