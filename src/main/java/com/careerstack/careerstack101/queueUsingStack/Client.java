package com.trgr.careerstack101.queueUsingStack;

public class Client {
	
	public static void main(String[] args){
		ModedQueue mq=new ModedQueue();
		mq.push(20);
		mq.push(30);
		mq.push(40);
		mq.push(50);
		mq.push(60);
		System.out.println(mq.pop());
		System.out.println(mq.pop());
		mq.push(70);
		mq.push(80);
		mq.push(90);
		System.out.println(mq.pop());
		System.out.println(mq.pop());
		System.out.println(mq.pop());
		System.out.println(mq.pop());
		System.out.println(mq.pop());
		System.out.println(mq.pop());
		System.out.println(mq.pop());
		
		
	}

}
