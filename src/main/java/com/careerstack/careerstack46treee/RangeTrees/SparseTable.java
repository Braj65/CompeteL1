package com.careerstack.careerstack46treee.RangeTrees;

public class SparseTable {
	
	public static void main(String[] args) {
		SparseTable s=new SparseTable();
		int[] inArr={4, 6, 1, 5, 7, 3};
		int[][] sparse=s.construct(inArr, inArr.length);
		System.out.println();
		int res=s.rangeMinQuery(inArr, sparse, 0, 3);
		System.out.println(res);;
	}
	
	public int[][] construct(int[] inArr, int n){
		//Create a 2d array process[i,j]->rows 0 to n-1, columns 0 to logN. will contain
		//index of smallest element.
		//Here i stands for the index of the element in the array. j will stand for no. of
		//elements/block of elements starting and inclusing from i. J doesn't stands 
		//for index in array.
		int[][] sparse=new int[n][(int)Math.ceil(Math.log(n))+1];
		//For i=0,j=0. min(0,2^0)= will be 0th index. startting from 0 to 2^0 element 
		//block including 0th index so only 0th index.
		//For i=1, j=0. min(1,2^0)=will be 1st index.
		//So for 1st columnwe can fill up 0, 1, 2, 3, 4, 5...n-1
		for(int i=0;i<n;i++){
			sparse[i][0]=i;
		}
		//1<<j is 2^j. we are filling column wise. And no. of columns is 2^j.
		//We are taking one column at a time in outer for loop.Unlike conventional row in
		//outer loop
		for(int j=1;(1<<j)<=n;j++){
			//for the elements in the input array where the block/length of array values to be
			//compared will go out of bounds, we are giving the (i+(1<<j)-1)<n boundary.
			//example if the input array has 5 elements. process[4,1] will be -1. Because 4th 
			//is the last element and a block of 2^1 element starting and 
			//including 4th elelemt will go out of bounds.
			for(int i=0;(i+(1<<j)-1)<n;i++){
				//sparse table contains index from input array. Here we are comparing two
				//input elements,based on index obtained from previous column of sparse
				//table, to find the least and feed it into current row-column of the sparse
				//Always two elements will be compared
				if(inArr[sparse[i][j-1]]<inArr[sparse[i+(1<<(j-1))][j-1]]){
					//i,j-1 always gives the element of the previous column and same
					//row as the one we are going to fill
					sparse[i][j]=sparse[i][j-1];
				}else{
					//i=1,j=2.So it will look in j-1 column. in j-1 column We will be
					//comparing 1,1 and 2,1. 1,2 means starting from 1 position(inclusive)
					//of in arr to 2^2 block of elements. In previous column j=1 it is
					//broken to 1,1 and 2,1. i,j-1 gives the 1,1 and i+(1<<j-1) gives 2,1
					//we take the second element for compare only where the first block 
					//i,j-1 ends.
//					System.out.println(i+(1<<(j-1)));
					sparse[i][j]=sparse[i+(1<<(j-1))][j-1];
				}
			}
		}
		return sparse;
	}
	
	public int rangeMinQuery(int[] inArr, int[][] sparse, int low, int high){
		int len=high-low+1;
		int k=(int)Math.log(len);
		//starting from low we will be looking at the next 2^k block of elements. Why k why not
		//directly len block?because in the sparse table the j column is for the log of any
		//length. And the table contains minimum between i(inclu.) to 2^j block of elements
		//So first we have to find log of len then find the index of minimum element
		//in sparse table for that respective logged length.
		int break1=inArr[sparse[low][k]];
		//so here we are first finding the minimum from low to 2^k(represented by k or j column)
		//but we have to find till high. If len>2^k then we have to find the minimum between
		//the left off numbers and compare with minimum of break1 number to find minimum.
		//to find minimum of the left off numbers we will start from low+leftoff till
		//2^k. That will cover automatically till high.
		int break2=inArr[sparse[low+(len-(1<<k))][k]];
		return Math.min(break1, break2);
		
		
	}

}
