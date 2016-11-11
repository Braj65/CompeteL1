package com.codeChefMedium.Palindrome;

public class NextPalindrome_PALIN {
	
	public static void main(String[] args){
		int i=19992;
		Integer x=new Integer(i);
		String strIn=x.toString();
		System.out.println(1%8);
		
		char[] chrIn=strIn.toCharArray();
		
		int len=chrIn.length;
		if(len%2!=0){
			chrIn=exchanger(chrIn, (len/2)+1);
		}
		else{
			chrIn=exchanger(chrIn, (len/2));
		}
		
		String n=new String(chrIn);
		int res=Integer.valueOf(n);
		while(res<=i){
			chrIn=increaser(chrIn, len/2);
			n=new String(chrIn);
			res=Integer.valueOf(n);
		}		
		System.out.println(res);
		
	}
	
	public static char[] exchanger(char[] arr, int start){
		int len=arr.length;
		int i=0;
		if(len%2!=0){
			i=2;
			while(start!=len){
				arr[start]=arr[start-i];
				++start;
				i+=2;
			}
		}
		else{
			i=1;
			while(start!=len){
				arr[start]=arr[start-i];
				++start;
				i+=2;
			}
		}
		
		return arr;
	}
	
	public static char[] increaser(char[] arr, int start){
		int len=arr.length;
		String s=null;
		if(len%2!=0){
			s=String.valueOf(arr[start]);
			int i=Integer.valueOf(s);
			i=i+1;
			s=Integer.toString(i);
			arr[start]=s.toCharArray()[0];
		}
		else{
			s=String.valueOf(arr[start]);
			int i=Integer.valueOf(s);
			i=i+1;
			s=Integer.toString(i);
			arr[start]=s.toCharArray()[0];
			arr[start-1]=s.toCharArray()[0];
		}
		
		return arr;
	}

}
