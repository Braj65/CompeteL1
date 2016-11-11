package com.trgr.careerstack90.Queue;

public class QueueOps {
	
	public static void main(String[] args){
		Queue x=new Queue(4);
		x.enqueue(-1);
		x.enqueue(0);
		x.enqueue(1);
		
		System.out.println(x.dequeue()+" "+x.dequeue());
		System.out.println(x.getMin());
	}
	
	
	

}

