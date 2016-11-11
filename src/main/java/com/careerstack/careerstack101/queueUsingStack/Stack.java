package com.careerstack.careerstack101.queueUsingStack;

public class Stack {
	
	Object[] data=new Object[20];
	int i=-1;
	
	public void push(Object d){
		data[++i]=d;
	}
	
	public Object pop(){
		if(!this.isEmpty())
			return data[i--];
		else
			return new StringBuffer("Is empty");
		
	}
	
	public Object peek(){
		if(!this.isEmpty())
			return data[data.length-1];
		else
			return new StringBuffer("Is empty");
		
	}
	
	public boolean isEmpty(){
		return i<0;
	}

}
