package com.trgr.careerstack61.loopInList;

public class Client {
	
	public static void main(String[] args){
		SingleList x=new SingleList(20);
		x.insert(30);
		x.insert(40);
		x.insert(50);
		x.insert(60);
		x.insert(70);
		x.insert(80);
		x.insert(90);
		x.insert(100);
		x.loopIt();
		
		findLoop(x);
		
	}
	
	public static void findLoop(SingleList x){
		SingleList y=x;
		while(x.next!=null){
			y=y.next.next;
			x=x.next;
			System.out.println(y);
			System.out.println(x);
			if(y==x){
				break;
			}
		}
		System.out.println(y.data+" "+x.data);
	}

}

