package com.trgr.adobe.geeksforgeeks;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Smallest_10_Elements_In_Stream {
	static Integer[] a=new Integer[8];
	static int i=0;
	static Smallest_10_Elements_In_Stream x=new Smallest_10_Elements_In_Stream();
	
//	for heap sol
	static int[] heap=new int[8];
	int size=0;
	public static void main(String[] args){
		int b=0;
		Scanner in=new Scanner(System.in);
		for(int i=0;i<15;i++){
			b=in.nextInt();
			x.simpleSol(b);
			x.solUsingMaxHeap(b);
		}
		
		for(int d:a){
			System.out.print(d+" ");
		}
		i=0;
		System.out.println();
		for(int d:heap){
			System.out.print(d+" ");
		}
	}

	public void simpleSol(int y){
		if(i<8){
			a[i]=y;
		}
		else if(i==8){
			Arrays.sort(a, Collections.reverseOrder());
			if(y<a[0]){
				a[0]=y;
				Arrays.sort(a, Collections.reverseOrder());
			}
		}
		else{
			if(y<a[0]){
				a[0]=y;
				Arrays.sort(a, Collections.reverseOrder());
			}
		}
	}
	
	public void solUsingMaxHeap(int x){
		if(i<8){
			insert(x);
			i++;
		}
		else{
			if(x<heap[0]){
				heap[0]=x;
				maxHeap();
			}			
		}
	}
	
	public static int parent(int pos){
		return pos/2;
	}
	
	public void insert(int val){
		heap[size++]=val;
		int current=size-1;
		
		while(heap[current]>heap[parent(current)]){
			swapper(current, parent(current));
			current=parent(current);
		}
	}
	
	public void maxHeap()
    {
        for (int pos = (size / 2); pos >= 0 ; pos--)
        {
            maxHeapify(pos);
        }
    }
	
	public void swapper(int x, int y){
		int temp=heap[x];
		heap[x]=heap[y];
		heap[y]=temp;
	}
	
	public void maxHeapify(int pos){
		if(!isLeaf(pos)){
			if(heap[pos]<heap[leftChild(pos)] || heap[pos]<heap[rightChild(pos)]){
				if (heap[leftChild(pos)] > heap[rightChild(pos)])
                {
                    swapper(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                }else
                {
                    swapper(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
			}
		}
	}
	
	public int leftChild(int pos){
		return (2*pos+1)<size?2*pos+1:pos;
	}
	
	public int rightChild(int pos){
		return (2*pos+2)<size?2*pos+2:pos;
	}
	
	public boolean isLeaf(int pos){
		if(pos>=size/2 && pos<=size){
			return true;
		}
		
		return false;
	}
}
