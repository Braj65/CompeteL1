package trn.robertSedgewick.chap2UNION;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class EagerAlgoforConnectivityProb2_2 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
		Integer noOftests=Integer.parseInt(br.readLine());
		Integer noOfPoints=Integer.parseInt(br.readLine());
		int[] eag=new int[noOfPoints];
		for(int i=0;i<noOfPoints;i++){
			eag[i]=i;
		}
		while(noOftests-->0){
			Integer a=Integer.parseInt(br.readLine());
			Integer b=Integer.parseInt(br.readLine());
			if(!connected(eag, a, b)){
				int x=eag[a];
				int y=eag[b];
				for(int j=0;j<noOfPoints;j++){
					if(eag[j]==x){
						eag[j]=y;
					}
				}
			}
			
		}
		 
	}
	
	public static boolean connected(int[] eag, int a, int b){
		if(eag[a]==b || eag[b]==a){
			return true;
		}
		else
			return false;
	}

}
