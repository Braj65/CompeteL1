package com.trgr.careerstack57.powMinmulti;

public class MinMultiply {
	
	public static void main(String[] args){
		int pow=10;
		int num=8;
		int q=0;
		int stat=1;
		int rem=0;
		while((pow=(pow/2))!=1){
			++q;
		}
		pow=10;
		System.out.println(q+3);
		int[] res=new int[q+3];
		res[0]=num;
		for(int i=1;i<res.length;i++){
			
			stat=stat*2;
			if(stat>pow){
				stat=stat/2;
				rem=pow-stat;
				res[i]=res[i-1]*res[rem-1];
			}
			else{
				res[i]=res[i-1]*res[i-1];
			}
		}
		System.out.println(res[res.length-1]);
	}

}
