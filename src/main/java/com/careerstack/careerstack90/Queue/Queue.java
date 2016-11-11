package com.trgr.careerstack90.Queue;

public class Queue {
	
	Object[] queuer=null;
	Integer top=0;
	Integer bottom=0;
	Integer min=0;
	public Queue(Integer len){
		queuer=new Object[len];
	}
	
	public void enqueue(Integer x){
		queuer[top++]=x;
		keepMin(x);
	}
	
	public Object dequeue(){
		return queuer[bottom++];
	}
	
	public void keepMin(Integer x){
		if(min==0){
			min=x;
		}
		else if(x<min){
			min=x;
		}
	}
	public Integer getMin(){
		return min;
	}
	
	

}
