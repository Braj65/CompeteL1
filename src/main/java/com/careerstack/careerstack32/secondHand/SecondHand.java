package com.trgr.careerstack32.secondHand;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SecondHand {
	
	public static void main(String[] args){
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
		System.out.println(sdf.format(d));
		Calendar cal=Calendar.getInstance();
		Date da=cal.getTime();
		System.out.println(sdf.format(da));
		int sec=cal.get(Calendar.SECOND);
		int min=cal.get(Calendar.MINUTE);
		int hr=cal.get(Calendar.HOUR);
		
		float S=sec;
		float M=min;
		float H=hr*5+min/12;
		if(Math.abs(H-M)==0.5)
			System.out.println("Special");
		
		System.out.println("H M S"+H+" "+M+" "+S);
		if(H>M){
			if(S<M && S>H){
				System.out.println("Larger");
			}else{
				System.out.println("SMaller");
			}
		}
		else{
			if(S>M && S<H){
				System.out.println("Larger");
			}else{
				System.out.println("SMaller");
			}
		}
		
		
		/*if(H>M){
			if((H-M)>0.5){
				if(S>H || S<M)
					System.out.println("Small");
				if(S<H && S>M)
					System.out.println("Large");
			}
			else{
				if(S>H || S<M)
					System.out.println("Large");
				if(S<H && S>M)
					System.out.println("SMall");
			}
		}
		else{
			if((M-H)>0.5){
				if(S>M || S<H)
					System.out.println("Small");
				if(S<M && S>H)
					System.out.println("Large");
			}
			else{
				if(S>M || S<H)
					System.out.println("Large");
				if(S<M && S>H)
					System.out.println("SMall");
			}
		}*/
		
		
	}

}
