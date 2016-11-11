package com.codeChefMedium.Sieve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class NumberOfFactorsSieve {
	 public static void main(String args[]) throws Exception
	 {
		 int i,j,k;
		 boolean prime[] = new boolean[1000001];
		 for(i=2;i*i<=1000000;i++)//http://stackoverflow.com/questions/5811151/why-do-we-check-upto-the-square-root-of-a-prime-number-to-determine-if-it-is-pri
		 {
			 if(prime[i]==false)
			 {
				 k=0;
				 j=i*i;
				 while(j<=1000000)
				 {
					 prime[j]=true;
					 j=i*i+k*i;
					 k++;
				 }
			 }
		 }
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int A,t = Integer.parseInt(br.readLine());
		 while(t--!=0)
		 {
			 int N = Integer.parseInt(br.readLine());
			 HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			 String s[] = br.readLine().split(" ");
	 /*for(j=2;j<10;j++)
	 System.out.println(j+ " " + prime[j]+" ");
	 System.out.println();*/
			 int count;
			 for(i=0;i<N;i++)
			 {
				 // System.out.println();
				 A = Integer.parseInt(s[i]);
				 //System.out.println(" A " + A);
				 for(j=2;j<=A;j++)
				 {
					 if(prime[j]==false)
					 {
						 if(A%j==0)
						 {
							 count=0;
							 while(A%j==0)
							 {
								 A/=j;
								 count++;
							 }
							 if(map.get(j)!=null)
							 {
								 map.put(j,map.get(j)+count);
								 //System.out.println("m1 j " +j+" " + map.get(j));
							 }
							 else
							 {
								 map.put(j,count);
								 //System.out.println("m2 j " +j+" " + map.get(j));
							 }
						 }
					 }
				 }
			 }
			 long ans=1;
			 for(int key : map.keySet())
			 {
				 ans*=((int)map.get(key)+1);
			 }
			 System.out.println(ans);
		 }
	 	}
	 


/*A simple modification of Sieve of Erastothenes will also prove to be helpful. The following is what I used.

f[i] == 0 if i is prime, and if i is prime, then f[i] will have the smallest prime that will divide it.

for (int i = 2; i <= N; i++) if (!f[i]) for (int j = i+i; j <= N; j += i) if (!f[j]) f[j] = i;

f[i] will help a lot to find all the prime divisors of a number.

f[42]=2  increment map[2]by 1
42/2=21
f[21]=3		increment map[3] by 1
21/3=7
f[7]=0		increment map[7] by1*/
	 
/*old way to check if a number is prime
 * 	for (int a = 2; a * a <= n; a++) {
if (n % a == 0) {
return false;
}
}
 */


}
