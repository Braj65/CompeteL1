package trn.TMMurali;

public class Lec12_KSackDP {
	
	public static void main(String[] args){
		Lec12_KSackDP k = new Lec12_KSackDP();
		int[] weight = {0, 6, 5, 2, 1, 7 };
		int[] val = {0, 22, 18, 6, 1, 28 };
		k.maxValStatWt(weight, val, 11);
	}
	
	public void maxValStatWt(int[] weight, int[] val, int tarWt){
		int[][] posWt=new int[val.length][tarWt+1];
		for(int k=0;k<tarWt+1;k++){
			posWt[0][k]=val[0];
		}
		
		for(int i=1;i<val.length;i++){
			for(int j=0;j<tarWt+1;j++){
				if(j<weight[i]){
					posWt[i][j]=posWt[i-1][j];
				}else
					posWt[i][j]=max(val[i]+posWt[i-1][j-weight[i]], posWt[i-1][j]);
			}
		}
		System.out.println();
		
		//Printing the jobs from the optimal solution set
		for(int i=1;i<val.length;i++){
			for(int j=0;j<tarWt+1;j++){
				if(j<weight[i]){
					
				}
				else if(val[i]+posWt[i-1][j-weight[i]]>posWt[i-1][j]){
					System.out.println(i);
					break;
				}
			}
		}
		/*int j=val.length;
		System.out.println("Elements");
		while(j>0){
			if(val[j]+mem[p[j]]>=mem[j-1]){
				System.out.println(j);
				j=p[j];
			}
			else{
				j=j-1;
			}	
		}*/
	}
	
	public static int max(int a, int b) {
		return a > b ? a : b;
	}

}
