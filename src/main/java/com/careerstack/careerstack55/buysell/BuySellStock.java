package com.trgr.careerstack55.buysell;

public class BuySellStock {
	
	
	
	
	public static void main(String[] args){
		int[] stocks={10, 20, 30, 5, 40, 50};
		BuySellStock obj=new BuySellStock();
		obj.getBestTime(stocks, stocks.length);
	}
	
	void getBestTime(int stocks[], int sz) 
	{
	    int min = 0;
	    int maxDiff = 0;
	    int buy=0;
	    int sell = 0;
	    for (int i = 0; i < sz; i++) 
	    {
	        if (stocks[i] < stocks[min])
	            min = i;
	        int diff = stocks[i] - stocks[min];
	        if (diff > maxDiff) 
	        {
	            buy = min;
	            sell = i;
	            maxDiff = diff;
	        }
	    }
	}

}
