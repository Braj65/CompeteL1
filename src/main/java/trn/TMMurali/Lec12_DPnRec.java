package trn.TMMurali;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lec12_DPnRec {
	static Integer[] end={5, 7, 6, 8, 3};
	public static void main(String[] args){
		Lec12_DPnRec dp=new Lec12_DPnRec();
		Integer[] start={2, 6, 4, 5, 1};
		Integer[] weight={6,4,5,11,5};
		Integer[] obj=new Integer[end.length];
		for(int i=0;i<obj.length;i++){
			obj[i]=i;
		}
		Arrays.sort(obj, new valCompare());
		Integer[] wtArr=new Integer[start.length];
		for(int j=0;j<wtArr.length;j++){
			wtArr[j]=weight[obj[j]];
		}
		dp.start(start, end, wtArr, obj);
	}
	
	public void start(Integer[] start, Integer[] end, Integer[] weight, Integer[] obj){
		int[] startCount=new int[end[obj[obj.length-1]]+1];
		int[] clntArr=new int[end[obj[obj.length-1]]+1];
		int[] p=new int[start.length+1];
		int x=1;
		for(int i=0;i<end.length;i++){
			clntArr[end[i]]=start[i];
		}
		for(int j=0;j<clntArr.length;j++){
			if(clntArr[j]!=0){
				startCount[j]=x;
				p[x]=startCount[leftestInterval(clntArr, 0, clntArr[j], 0)];
				++x;
			}	
		}
//		System.out.println(leftestInterval(clntArr, 0, 5, 0));
		int[] mem=new int[start.length+1];

		System.out.println(compute(start.length, weight, p, mem));
		findOptJobs(start.length, weight, p, mem);
		System.out.println();
	}
	
	public int compute(int j, Integer[] weight, int[] p, int[] mem){
		if(j==0)
			return 0;
		else if(j==1){
			mem[j]=weight[0].intValue();
			return mem[j];
		}
		else if(mem[j]!=0){
			return mem[j];
		}
		else{
			mem[j]=max(weight[j-1]+compute(p[j], weight, p, mem), compute(j-1, weight, p, mem));
			return mem[j];
		}
	}
	
	public void findOptJobs(int j, Integer[] weight, int[] p, int[] mem){
		if(j==0)
			System.out.println(j);
		else if(weight[j-1]+mem[p[j]]>mem[j-1]){
			System.out.println(j);
			findOptJobs(p[j], weight, p, mem);
		}else{
			findOptJobs(j-1, weight, p, mem);
		}
	}
	
	public int leftestInterval(int[] arr, int start, int end, int interest){
		if(start==end || start>end){
			if(arr[start]!=0){
				interest=start;
			}
			return interest;
		}
		int mid=(start+end)/2;
		if(arr[mid]!=0){
			interest=mid;
		}
		interest=leftestInterval(arr, mid+1, end, interest);
		if(interest==0)
			interest=leftestInterval(arr, start, mid-1, interest);
		return interest;
	}
	
	static class valCompare implements Comparator<Integer>{
		public int compare(Integer a, Integer b){
			return end[a].compareTo(end[b]);
		}
	}
	
	static int max(int a, int b) { return (a > b)? a : b; }
	
	

}
