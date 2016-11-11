package trn.TMMurali.MatrixMultiplication;

public class MatrixMultiplicationRec {
	public static void main(String[] args) {
		MatrixMultiplicationRec x=new MatrixMultiplicationRec();
		int[][] A={{2, 4},{5, 2},{6, 8}};
		int[][] B={{3,5,7},{9,11,13}};
		x.twoMatrixMul(A, B);
		int[][] C={{4,3,2,6},{7,8,5,3},{9,7,5,3}};
		int[] size={3,2,3,4};
		x.NMatrixMulCost(size);
		
	}
	
	public static void twoMatrixMul(int[][] A, int[][] B){
		int r1=A.length;
		int c2=B[0].length;
		int r2=A[0].length;
		int[][] C=new int[r1][c2];
		for(int i=0;i<r1;i++){
			for(int j=0;j<c2;j++){
				for(int k=0;k<r2;k++){
					C[i][j]=C[i][j]+A[i][k]*B[k][j];
				}
			}
		}		
		System.out.println();
	}
	
	public static void NMatrixMulCost(int[] size){
		int temp=Integer.MAX_VALUE;
		int x=0;
		for(int i=1;i<size.length;i++){
			for(int j=1;j<size.length;j++){
				if(j>=i){
					for(int k=i;k<j;k++){
						x=mulCost(i, j, k, size);
						temp=Math.min(x,temp);
					}
				}
			}
		}
	}
	
	public static int mulCost(int i, int j, int k, int[] size){
		if(i==j){
			return 0;
		}
		else{
			return mulCost(i, k, i, size)+mulCost(k+1, j, k+1, size)+(size[i-1]*size[k]*size[j]);
		}
	}

}
