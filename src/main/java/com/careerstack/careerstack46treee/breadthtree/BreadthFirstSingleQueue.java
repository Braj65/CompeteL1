package com.careerstack.careerstack46treee.breadthtree;

import java.util.ArrayList;
import java.util.List;

public class BreadthFirstSingleQueue {
	
	public static void main(String[] args){
		Node trees=new Node(5);
		trees.insert(10);
		trees.insert(9);
		trees.insert(3);
		trees.insert(14);
		trees.insert(12);
		trees.insert(22);
		trees.insert(56);
		trees.insert(12);
		trees.insert(8);
		print(trees);		
	}
	
	public static void print(Node root){
		Queue q=new Queue();
		int nodesInCurrentLevel=1;
		int nodesInnextLevel=0;
		q.push(root.k);
		int curLevel=0;
		int nextLevel=0;
		while(!q.isEmpty()){
			Link n=q.pop();
			nodesInCurrentLevel--;
			if(n!=null){
				System.out.print(n.data);
				q.push(n.aLeft);
				q.push(n.right);
				nodesInnextLevel+=2;
			}
			if(nodesInCurrentLevel==0){
				System.out.println("NEXt LEVEl");
				nodesInCurrentLevel=nodesInnextLevel;
				nodesInnextLevel=0;
			}
			
		}
	}

}

class Queue{
	List<Link> x=new ArrayList<Link>();
	int i=0;
	public void push(Link a){
		x.add(0,  a);
		++i;
	}
	
	public Link pop(){
		Link y=x.get(--i);
		return y;
	}
	
	public boolean isEmpty(){
		return i==0;
	}
}
