package com.trgr.careerstack60.wordsInAString;

public class WordsInAString {
	
	public static void main(String[] args){
		String que="Jammy has a  little   lamb ";
		String[] x=que.split("");
		int i=0;
		boolean q=false;
		for(String k:x){
			if(!k.equals(" ") && !q){
				++i;
				q=true;
			}
			else if(k.equals(" ") && q){
				q=false;
			}
		}
		System.out.println(i);
		
	}
	
	public void recurse(String x, int len){
		if(len==0){
			return;
		}
		else{
			if(x.charAt(0)==' '){
				
			}
			
		}
	}

}
