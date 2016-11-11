package trn.TMMurali.MatrixMultiplication;

import java.util.ArrayList;

public class MatrixMultiplicationDP {
	public static void main(String[] args) {
		MatrixMultiplicationDP x=new MatrixMultiplicationDP();
		Integer[][] A={{2, 4},{5, 2},{6, 8}};
		Integer[][] B={{3,5,7,12,2},{9,11,13,6,4}};
		x.twoMatrixMul(A, B);
		Integer[][] C={{4,3,2},{7,8,5},{9,7,5},{6,3,3},{2,4,9}};
		Integer[][] D={{7,8,5,1},{9,7,5,3},{4,3,2,6}};
		ArrayList<Integer[][]> X=new ArrayList<Integer[][]>();
		X.add(A);X.add(B);X.add(C);X.add(D);
		int[] size={3,2,5,3,4};
		int[][] cost=new int[4][4];
		int[][] split=new int[4][4];
		split=x.NMatrixMulCost(size, cost, split);
		Integer[][] res=x.NMatrixMul(X, split, 0, 3);
		System.out.println();
	}
	
	public static Integer[][] twoMatrixMul(Integer[][] A, Integer[][] B){
		int r1=A.length;
		int c2=B[0].length;
		int r2=A[0].length;
		int[][] C=new int[r1][c2];
		Integer[][] D=new Integer[C.length][C[0].length];
		for(int i=0;i<r1;i++){
			for(int j=0;j<c2;j++){
				for(int k=0;k<r2;k++){
					C[i][j]=C[i][j]+A[i][k]*B[k][j];
					D[i][j]=C[i][j];
				}
			}
		}
		System.out.println();
		return D;		
	}
	
	public static int[][] NMatrixMulCost(int[] size, int[][] res, int[][] split){		
		int n=res.length;
//		int j=0;
		int q=0;
//		int n=res.length-1;
		/*for(int l=1;l<=n;l++){
				for(int i=0;i<(n-l+1);i++){
					j=i+l;
					System.out.println(i+","+j+"---");
					res[i][j]=Integer.MAX_VALUE;
					for(int k=i;k<j;k++){
						System.out.println(i+","+k+","+j);
						q=res[i][k]+res[k+1][j]+size[i-1]*size[k]*size[j];
						if(q<res[i][j]){
							res[i][j]=q;
						}
					}
				}
		}*/
		int l=0;
		for(int j=1;j<n;j++){
			l=j;
			for(int i=0;i<=(n-j-1);i++){				
				System.out.println(i+","+l+"---");
				res[i][l]=Integer.MAX_VALUE;
				for(int k=i;k<l;k++){
//					System.out.println(i+","+k+","+l);
					q=res[i][k]+res[k+1][l]+size[i]*size[k+1]*size[l+1];
					if(q<res[i][l]){
						res[i][l]=q;
						split[i][l]=k;
					}
				}
				l++;
			}
		}
		
		return split;
	}
	
	public static Integer[][] NMatrixMul(ArrayList<Integer[][]> X, int[][] split, int i, int j){
		if(i<j){
			Integer[][] x=NMatrixMul(X, split, i, split[i][j]);
			Integer[][] y=NMatrixMul(X, split, split[i][j]+1, j);
			return twoMatrixMul(x, y);
		}else{
			return X.get(i);
		}
	}

}
