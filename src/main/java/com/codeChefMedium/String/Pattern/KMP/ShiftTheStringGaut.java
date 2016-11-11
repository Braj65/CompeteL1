package com.codeChefMedium.String.Pattern.KMP;

import java.util.Scanner;

public class ShiftTheStringGaut {
	public static long[] c_z(String s)
	{
		long Z[]=new long[s.length()];
		long l=0,r=0;
		for(long i=1;i<s.length();i++)
		{
			if(r<i)
			{
				l=r=i;
				while(r<s.length()&&s.charAt((int)r)==s.charAt((int)(r-l)))
					r++;
				Z[(int)i]=r-l;
				r--;
			}else
			{
				if(Z[(int)(i-l)]+i<r+1)
					Z[(int)i]=Z[(int)(i-l)];
				else
				{
					l=i;
					while(r<s.length()&&s.charAt((int)r)==s.charAt((int)(r-l)))
						r++;
					Z[(int)i]=r-l;
					r--;
				}
			}
		}
		return Z;
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String a=sc.next();
		String b=sc.next();
		a+="#"+b;
		long Z[]=c_z(a);
		long max=0;
		for(int i=n+1;i<a.length();i++)
			max=Math.max(max,Z[i]);
		for(int i=n+1;i<a.length();i++)
		{
			if(Z[i]==max)
			{
				System.out.println(i-n-1);
				break;
			}
		}
}

}
