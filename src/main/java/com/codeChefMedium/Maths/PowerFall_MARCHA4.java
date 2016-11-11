package com.codeChefMedium.Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class PowerFall_MARCHA4 {

	public static void main(String[] args) throws Exception {
		ClassLoader classloader = Thread.currentThread().getClass().getClassLoader();
		InputStreamReader input = new InputStreamReader(
				classloader.getSystemResourceAsStream("com/codeChefMedium/MARCHA4.txt"));
		BufferedReader br=new BufferedReader(input);
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int t=Integer.parseInt(st.nextToken());
		while(t-->0){
			st=new StringTokenizer(br.readLine());
			Long nCop=Long.parseLong(st.nextToken());
			Long temp=nCop;
			BigInteger n=BigInteger.valueOf(nCop);
			int k=Integer.parseInt(st.nextToken());
			int cnt=0;
			while(nCop!=1){
				if(nCop%2!=0)
					++cnt;
				n=n.pow(2);
				nCop=nCop/2;				
			}
			n=n.multiply(BigInteger.valueOf((long)Math.pow(temp, cnt)));
			String[] str=n.toString().split("");
			for(int i=0;i<k;i++){
				System.out.print(str[i]);
			}
			System.out.print(" ");
			for(int i=str.length-1;i>=str.length-k;i--){
				System.out.print(str[i]);
			}
			System.out.println();
			
			/*BigInteger nCopy=n;		
			int len=(int) Math.log10(n.doubleValue());
			
			len=len+1;
			len=len-k;
			System.out.print(n.divide(BigInteger.valueOf((long) Math.pow(10, len)))+" ");
			
			Long d=(long) Math.pow(10, k);
			System.out.print(nCopy.mod(BigInteger.valueOf(d)));
			System.out.println();*/
			
			
		}
	}

}
