package com.careerstack.careerstack46treee.breadthtree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;


public class BreadthFirstWebSol {
	
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
		/*for(Link k:trees.var){
			System.out.println(k.data);
		}*/
		BreadthFirstWebSol bread=new BreadthFirstWebSol();
		bread.printLevelOrder(trees);
	}
	
	public void printLevelOrder(Node root){
		
		if(root==null)
			return;
		
		int level=1;
		Link popElem=null;
		Deque<Link> queue=new ArrayDeque<Link>();
		queue.push(root.k);
		
		while(!queue.isEmpty()){
			Deque<Link> next=new ArrayDeque<Link>();
			System.out.println("---- Level"+level+" ----");
			while(!queue.isEmpty() && ((popElem=queue.pop())!=null)){
				System.out.println(popElem.data);
				
				if(popElem.aLeft!=null)
					next.push(popElem.aLeft);
				if(popElem.right!=null)
					next.push(popElem.right);
			}
			
			System.out.println();
			queue=next;
			level++;
		}
		
	}

}
