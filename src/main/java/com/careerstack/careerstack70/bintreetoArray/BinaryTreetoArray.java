package com.trgr.careerstack70.bintreetoArray;

import java.util.ArrayList;
import java.util.List;


public class BinaryTreetoArray {
	
	public static void main(String[] args){
		Node n1=new Node(6);
		n1.insert(10);
		n1.insert(9);
		n1.insert(3);
		n1.insert(14);
		n1.insert(12);
		n1.insert(22);
		n1.insert(56);
		n1.insert(12);
		n1.insert(8);
		getDepth(n1);
	}
	
	
	public static void getDepth(Node n1){
		List<Link> queue=new ArrayList<Link>();
		List<Link> next=new ArrayList<Link>();
		List<Integer> values=new ArrayList<Integer>();
		queue.add(n1.k);
		Integer level=1;
		
		while(queue.size()>0){
			System.out.println("-------------Level-"+level+"---------------");
			for(Link y:queue){				
				System.out.println(y.data);
			}			
				
			for(Link x:queue){
				if(x.aLeft!=null){
					next.add(x.aLeft);
				}
				if(x.right!=null){
					next.add(x.right);
				}
			}
			queue.clear();
			queue.addAll(next);
			next.clear();
			++level;
		}		
	}

}
