package com.codeChefMedium.Maths.Subsets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ANUMLASmallSol {
	 public static void main(String ar[])throws Exception {
		 BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		 PrintWriter out=new PrintWriter(System.out);
		 int t=Integer.parseInt(in.readLine());
		 while(t-->0){
		 int n=Integer.parseInt(in.readLine());
		 //doing 2^n to create an empty array for the subset values
		 int m=1<<n;
		 String s[]=in.readLine().split(" ");
		 int ing[]=new int[s.length];
		 for (int i=0;i<ing.length;i++)ing[i]=Integer.parseInt(s[i]);
		 Arrays.sort(ing);
		 //creating empty valueset array with size of n
		 int ans[]=new int[n];
		 //creating empty subset array with size of 2^n
		 int c[]=new int[m];
		 int f=0,pp=0;//pp=0 makes sure that first element from sorted input array is saved as 
		 				//first valueset element
		 PriorityQueue<Integer> m1=new PriorityQueue<>();
		 //looping till 2^n
		 for(int i=1;i<m;i++){
		 int x=-1;
		 //m1 is the queue saving all the subset values which are addition of the new valueset number
		 //with exisitng values in subset array c[pp]
		 if(!m1.isEmpty())x=m1.peek();
		 if(ing[i]==x){//if input array next val is equal to val from the m1 queue then 
		 m1.remove();//remove it from queue and don't execute the else loop which finds for new valueset numbers
		 }else{
		 //in else block saving the number from input to valueset array. If above if block is not
		 //executed
		 ans[f]=ing[i];//saving the values from the input[] in the valueset[]
		 int d=pp;
		 for(int j=0;j<d;j++){//loop to add the new ans[f] with existing values in sumset. And store it in new position starting from pp 
		 c[pp]=c[j]+ans[f];
		 m1.add(c[pp]);//add the new added subset numbers to queue to check if it matcehs with 
		 pp++;	//input array vals in the first if loop inide the grandpa for loop
		 } 
		 c[pp++]=ans[f];//copying the new obtained value from valueset[] to subset[] and increasing pp to point to next position in subset[]
		 f++;
		 }
		 }
		 for(int i=0;i<n;i++)System.out.print(ans[i]+" ");
		 System.out.println();
		 }
		 }

}
