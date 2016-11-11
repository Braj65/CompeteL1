package com.trgr.careerstack13.removeStringSpaces;

public class CompactString {
	
	public static void main(String[] args){
		compacter("Jammy THe   jammer has   a lamb");
	}
	
	public static void compacter(String s1){
		char[] y=s1.toCharArray();
		String[] x=s1.split("");
		int i=0;
		int ptr=0;
		int flag=0;
		/*do{
			while(y[ptr+flag]==' ')
				++flag;
			y[ptr]=y[ptr+flag];
			++ptr;
		}while(y[ptr+flag]!=null)*/
		for(String c: x){
			if(c.equals(" ")){
				c="";
				++i;
			}
			else{
				if(i>=1){
					c=" "+c;
				}
				i=0;
			}
			System.out.print(c);
		}
		
	}

}
