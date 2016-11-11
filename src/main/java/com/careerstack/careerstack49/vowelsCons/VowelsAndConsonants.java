package com.trgr.careerstack49.vowelsCons;

import java.util.ArrayList;
import java.util.List;

public class VowelsAndConsonants {
	
	public static void main(String[] args){
		VowelsAndConsonants obj=new VowelsAndConsonants();
		obj.getSeq("JAMMYEOO");
	}
	
	public void getSeq(String input){
		String[] arr=input.split("");
		int flag=-1;
		List<String> hold=new ArrayList<String>();
		
		for(int i=0;i<arr.length;i++){
			hold.add(arr[i]);
			if(isVowel(arr[i]) && (flag==-1 || flag==1)){
				flag=0;
				//hold.add(flag);
				
				System.out.print("V");
			}
			else if(isVowel(arr[i]) && flag==0){
				
			}
			else if(flag==-1 || flag==0){
				flag=1;
				//hold.add(flag);
				
				System.out.print("C");
			}
		}
		/*int temp=hold.get(0);
		if(temp==1)
			System.out.print("C");
		else
			System.out.print("V");
		for(int j=1;j<hold.size();j++){
			if(hold.get(j)!=temp){
				temp=hold.get(j);
				if(temp==1)
					System.out.print("C");
				else
					System.out.print("V");
			}
			temp=hold.get(j);
		}*/
	}
	
	public boolean isVowel(String x){
		if(x.equals("A") || x.equals("E") || 
					x.equals("I") || x.equals("O") 
					|| x.equals("U")){
			return true;
		}
		else
			return false;
	}

}
