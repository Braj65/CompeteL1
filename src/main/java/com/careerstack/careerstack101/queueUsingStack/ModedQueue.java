package com.trgr.careerstack101.queueUsingStack;

public class ModedQueue {
	
	public Stack s1=new Stack();
	public Stack s2=new Stack();
	
	public void push(Object o){
		s1.push(o);
	}
	
	public Object pop(){
		if(!s2.isEmpty()){
			return s2.pop();
		}
		else{
			while(!s1.isEmpty()){
				s2.push(s1.pop());
			}
			return s2.pop();
		}
	}
	
	public boolean isEmpty(){
		return s1.isEmpty() && s2.isEmpty();
	}
	
}
