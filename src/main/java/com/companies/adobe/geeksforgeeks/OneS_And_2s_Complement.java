package com.trgr.adobe.geeksforgeeks;

public class OneS_And_2s_Complement {
	
	public static void main(String[] args){
		int x=12;
		int m=1;
		int y=x^m;
		int z=y^m;
		int a=z^m;
		
		System.out.println(y);
		m=m<<1;
		System.out.println(y^m);
		m=m<<2;
		System.out.println(x&m);
		
		int b=15;
		System.out.println(b&(b-1));
		
		System.out.println("X before one complemented "+x);
		String oneComp=oneComplementor(Integer.toBinaryString(x));
		System.out.println("One complemented "+oneComp);
		System.out.println("Two complemented "+twoComplementor(oneComp));
	}
	
	public static String oneComplementor(String x){
		char[] c=x.toCharArray();
		StringBuffer sb=new StringBuffer();
		for(char w: c){
			sb.append(flipper(w));
		}
		
		return sb.toString();
	}
	
	public static char flipper(char c){
		return c=='0'?'1':'0';
	}
	
	public static int twoComplementor(String x){
		int oneComplementedNum=binStringToint(x);
		
		int m=1;
		while((oneComplementedNum & m)==1){
			oneComplementedNum=oneComplementedNum^m;
			m<<=1;
		}
		int twoComplementedNum=oneComplementedNum;
		return twoComplementedNum;
	}
	
	public static int binStringToint(String x){
		char[] c=x.toCharArray();
		int res=0;		
		for(int i=c.length-1;i>=0;i--){
			res+=Integer.valueOf(Character.toString(c[i]))*Math.pow(2, c.length-1-i);
		}		
		return res;
	}

}
