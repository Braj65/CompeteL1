package com.careerstack.careerstack46treee.LCA;

public class LowestCommonAncestor {
	
	public static void main(String[] args) {
		int[] inArr={9,11,5,6,2,3,8,13,7};
		System.out.println(match(2, 8, inArr, 0, inArr.length-1));
		System.out.println(match(2, 5, inArr, 0, inArr.length-1));
		System.out.println(match(9, 5, inArr, 0, inArr.length-1));
		System.out.println(match(8, 7, inArr, 0, inArr.length-1));
		System.out.println(match(9, 3, inArr, 0, inArr.length-1));
	}
	
	public static int match(int a, int b, int[] arr, int start, int end){
		int root=(start+end)/2;
		if(start>=end){
			if(a==arr[root] || b==arr[root]){
				return root;
			}else{
				return -1;
			}
		}
		if(a==arr[root] || b==arr[root]){
			return root;
		}		
		else{
			int x=match(a, b, arr, start, root-1);
			int y=match(a, b, arr, root+1, end);
			if(x!=-1 && y!=-1){
				return root;
			}
			if(x==-1 && y==-1){
				return -1;
			}
			return x!=-1?x:y;
			
		}
	}
	
	

}
