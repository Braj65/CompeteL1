package com.trgr.AmazonGlassDoor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DigitRepeatation {
	
	public static void main(String[] args){
		int x=2256;
		int count=0;
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		
		
		while(x-x/10!=0){
			
			if(map.get(x%10)!=null){
				count=map.get(x%10);
				map.put(x%10, ++count);
			}
			else{
				map.put(x%10, ++count);
			}
			count=0;
			x-=x%10;
			x=x/10;
		}
		
		Set<Integer> z=map.keySet();
		Iterator<Integer> w=z.iterator();
		int i=0;
		while(w.hasNext()){
			i=w.next();
			System.out.println(i+" = "+map.get(i));
			
		}
	}

}
