package trn.robertSedgewick.chap2UNION;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LazyQuickFind2_3 {
	public static int[] eag;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
		Integer noOftests=Integer.parseInt(br.readLine());
		Integer noOfPoints=Integer.parseInt(br.readLine());
		eag=new int[noOfPoints];
		for(int i=0;i<noOfPoints;i++){
			eag[i]=i;
		}
		while(noOftests-->0){
			Integer a=Integer.parseInt(br.readLine());
			Integer b=Integer.parseInt(br.readLine());
			union(a ,b);			
		}
	}
	
	public static int root(int i){
		while(eag[i]!=i){
			i=eag[i];
		}
		return i;
	}
	
	public static boolean connected(int a, int b){
		if(root(a)==root(b))
			return true;
		else
			return false;
	}
	
	public static void union(int p, int q){
		if(connected(p, q)){
			
		}
		else{
			int a=root(p);
			int b=root(q);
			eag[a]=b;
		}
		
	}

}
