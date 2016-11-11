package com.trgr.careerstack65.strRevRecurse;

public class StrReverseRecurse {
	
	public static void main(String[] args){
		rev("Jammy", 5);
		/*Integer[] arr={1, 3, 4, 7};
		int i=0;
		while(arr[i]!=null){
			System.out.println(arr[i++]);
		}*/
		int x=0;
		int y=x-1;
		System.out.println(Integer.toBinaryString(y));
		System.out.println(x&y);
	}
	
	public static char rev(String x, int len){
		if(len==0)
			return ' ';
		else{
			System.out.print(x.charAt(len-1));
		return rev(x, len-1);
		}
	}

}
