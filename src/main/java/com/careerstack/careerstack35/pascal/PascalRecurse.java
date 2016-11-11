package com.trgr.careerstack35.pascal;

public class PascalRecurse {
	
	public static void main(String[] args){
		for(int row=0;row<5;row++){
			for(int col=0;col<=row;col++){
				System.out.print(pascal(col, row)+" ");
			}
			System.out.println();
		}
	}
	
	public static int pascal(int col, int row){
		if(col==0 || row==col)
			return 1;
		else
			return pascal(col, row-1)+ pascal(col-1, row-1);
	}

}
