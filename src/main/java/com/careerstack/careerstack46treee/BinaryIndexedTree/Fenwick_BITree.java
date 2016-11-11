package com.careerstack.careerstack46treee.BinaryIndexedTree;

public class Fenwick_BITree {
	
	public static void main(String[] args) {
		Fenwick_BITree ft=new Fenwick_BITree();
		int[] inArr={1,2,3,4,5,6,7};
		int[] binTree=ft.createTree(inArr);
		System.out.println(ft.getSum(binTree, 3));//range queries from 0 to 3	
	}
	
	public int[] createTree(int[] arr){
		int[] binTree=new int[arr.length+1];
		for(int i=1;i<binTree.length;i++){
			updateTree(binTree, i, arr[i-1]);
		}
		
		return binTree;
	}
	
	public void updateTree(int[] binTree, int i, int val){
		while(i<binTree.length){
			binTree[i]+=val;
			i=getNext(i);
		}
	}
	
	public int getNext(int index){
		return index+(index & -index);
	}//this equation finds next node to be updated(not going to be 
	//parent node but next sibling and next branch's parent).
	//it finds the next node by addding one to the right most set bit.
//It keeps on finding next node till it reaches any next parent node of 2^x level i.e immediate
//child of root node. It never reaches its own 2^x parent node.
//Adding one to right most one is nothing but adding place value of right-most ONE to the number
//index&(-index) gives back a number with place value of rght most set bit. For ex-
//1010100(84) then index&(-index) will give 100 i.e number extracted from original number
//including and after right most set bit. So next will be (84+100)1011000(86)
//->(86+1000)1100000(96)->(96+100000)10000000(128). Remember, to be added to same number
	
	public int getSum(int[] binTree, int index){
		index=index+1;
		int sum=0;
		while(index>0){
			sum+=binTree[index];
			index=getParent(index);//the index value will keep on decreasing as it
		}//keeps updating with its parent index value. Which will be lesser than input
		return sum;//index due to substraction.
	}
	
	public int getParent(int index){
		return index-(index & -index);//this equation finds parent of the current node by
		// flipping the righ most set bit. It will keep on finding parent
		//till it reaches its own parent 2^x node. It finds the parent node
//by substracting from the original number the number with and after the right most set
//bit. index&(-index) gives back a number with place value of rght most set bit.
//For ex-
//1010100(84) then index&(-index) will give 100 i.e number extracted from original number
//including and after right most set bit. So next will be (84-100)1010000(80)
//->(80-10000)1000000(64). Remember, to be substracted from same number
	}
	

}
