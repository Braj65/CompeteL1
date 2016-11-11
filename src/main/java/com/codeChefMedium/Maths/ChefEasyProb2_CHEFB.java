package com.codeChefMedium.Maths;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class ChefEasyProb2_CHEFB {
	static Integer[] ai=null;
	public static void main(String[] args) throws Exception {
		int[] primeFact=new int[1000000];
		int j, k, l;
		for(int i=2;i*i<1000000;i++){
			
			if(primeFact[i]==0){
				k=0;
				j=i*i;
				while(j<1000000){
					primeFact[j]=i;
					j=i*i+k*i;
					++k;
				}
			}
		}
		
		ClassLoader classloader = Thread.currentThread().getClass().getClassLoader();
		InputStreamReader input = new InputStreamReader(
				classloader.getSystemResourceAsStream("com/codeChefMedium/CHEFB.txt"));
		BufferedReader br=new BufferedReader(input);
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int t=Integer.parseInt(st.nextToken());
		
		
		while (t-- > 0) {
			st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			ai=new Integer[n];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++)
				ai[i]=Integer.parseInt(st.nextToken());
			
			//this sol won't scale because when we are finding the lcm below then we are 
			//getting  large no. as lcm. If suppose the no.s is 900001, 900011, 11 then
			//the lcm will be multiplication of three. The result lcm will be larger than
			//capacity of int and runtime error will come.
			//The alternate sol is scalable. For each given no. we are finding its factors.
			//Then keeping those factors and count of the factors in a childmap. Then
			//transfering the key vals from child to parent map only if the count of each 
			//factor in child map is larger than in parent map. now the factors and their
			//counts in the parent map is the lcm. And the sum of count of each factor
			//is the answer. For ex- 18=3*3*2. So 3->2 and 2->1 times in child map.

			Arrays.sort(ai, new valCompare());
			int lcm = ai[0];
			int gcd = 0;
			for (int q = 1; q < n; q++) {
				gcd = gcd(ai[q], lcm);
				lcm=lcm*(ai[q]/gcd);
			}
			int count=0;
			if(lcm!=1)
				count=1;			
			
			while(primeFact[lcm]!=0){
				++count;
				lcm=lcm/primeFact[lcm];
			}
			System.out.println(count);
		}	
		
	}
	
	public static int gcd(int a, int b){
		if(b==0)
			return a;
		else{
			return gcd(b, a%b);
		}
	}
	
	static class valCompare implements Comparator<Integer>{
		public int compare(Integer a, Integer b){
			return b.compareTo(a);
		}
	}
	

}
