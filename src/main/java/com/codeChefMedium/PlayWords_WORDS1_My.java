package com.codeChefMedium;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class PlayWords_WORDS1_My {
	static Integer[] alphaStartCount = null;
	/*Integer[] alphaEndCount = null;
	Integer[] orderCount=null;
	int[] alphaOccCount=null;
	int[] occTrack=null;*/
	public static void main(String[] args) throws Exception {
		/*PlayWords_WORDS1 obj=new PlayWords_WORDS1();
		obj.ops();*/
//		Integer[] alphaStartCount = null;
		Integer[] alphaEndCount = null;
		Integer[] orderCount=null;
		Integer[] lockTracker=null;
		int[] alphaOccCount=null;
		int[] occTrack=null;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		int start = 0;
		int end = 0;
		while (t-- > 0) {
			int strCount = Integer.parseInt(br.readLine());
			alphaStartCount = new Integer[strCount];
			alphaEndCount = new Integer[strCount];
			orderCount=new Integer[strCount];
			alphaOccCount=new int[26];
			occTrack=new int[26];
			for(int j=0;j<strCount;j++)
				orderCount[j]=j;
			for (int i=0; i<strCount; i++) {
				char[] x = br.readLine().toCharArray();
				start = (int) x[0] - 97;
				alphaStartCount[i]=start;
				end=(int) x[x.length-1] - 97;
				alphaEndCount[i]=end;
			}
			Arrays.sort(orderCount, new valCompare());
			lockTracker=new Integer[orderCount.length];
			/*for(int y=0;y<orderCount.length;y++){
				revrsOrderCnt[orderCount[y]]=y;
			}*/
			
			Arrays.sort(alphaStartCount);
			int match=0;
			int mismatch=0;
			int flag=0;
			for(int w=0;w<alphaEndCount.length;w++){
				++occTrack[alphaEndCount[w]];
				alphaOccCount[alphaEndCount[w]]=occTrack[alphaEndCount[w]];
				Integer pos=divide(alphaStartCount, 0, alphaStartCount.length-1, alphaEndCount[w], alphaOccCount);
				if(pos==null){
					++mismatch;
				}
				else if(w!=orderCount[pos]){
					++match;
					lockTracker[w]=orderCount[pos];
					if(lockTracker[lockTracker[w]]!=null){
						if(w==lockTracker[lockTracker[w]])
							++flag;
					}
					/*if(alphaEndCount[orderCount[pos]]==alphaStartCount[revrsOrderCnt[w]] && strCount>2){
						++flag;
					}			*/			
				}
				else{
					++flag;
				}
			}
			if(flag>=1)
				System.out.println("The door cannot be opened.");
			else if(mismatch>=1 && match<=0)
				System.out.println("The door cannot be opened.");
			else
				System.out.println("Ordering is possible.");
			/*else if(match>=1 && mismatch==1)
				System.out.println("Ordering is possible.");
			else if(match==alphaEndCount.length && mismatch==0)
				System.out.println("Ordering is possible.");*/
		}	
	
	}
	
	/*public void ops() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		int start = 0;
		int end = 0;
		while (t-- > 0) {
			int strCount = Integer.parseInt(br.readLine());
			alphaStartCount = new Integer[strCount];
			alphaEndCount = new Integer[strCount];
			orderCount=new Integer[strCount];
			alphaOccCount=new int[26];
			occTrack=new int[26];
			for(int j=0;j<strCount;j++)
				orderCount[j]=j;
			for (int i=0; i<strCount; i++) {
				char[] x = br.readLine().toCharArray();
				start = (int) x[0] - 97;
				alphaStartCount[i]=start;
				end=(int) x[x.length-1] - 97;
				alphaEndCount[i]=end;
			}
			Arrays.sort(orderCount, new valCompare());			
			Arrays.sort(alphaStartCount);
			int match=0;
			int mismatch=0;
			int flag=0;
			for(int w=0;w<alphaEndCount.length;w++){
				++occTrack[alphaEndCount[w]];
				alphaOccCount[alphaEndCount[w]]=occTrack[alphaEndCount[w]];
				Integer pos=divide(alphaStartCount, 0, alphaStartCount.length-1, alphaEndCount[w], alphaOccCount);
				if(pos==null){
					++mismatch;
				}
				else if(w!=orderCount[pos]){
					++match;
				}
				else{
					++flag;
				}
			}
			if(flag>=1)
				System.out.println("The door cannot be opened.");
			else if(mismatch>=1 && match<=0)
				System.out.println("The door cannot be opened.");
			else
				System.out.println("Ordering is possible.");
			else if(match>=1 && mismatch==1)
				System.out.println("Ordering is possible.");
			else if(match==alphaEndCount.length && mismatch==0)
				System.out.println("Ordering is possible.");
		}	
	}
	*/
	public static Integer divide(Integer[] inArr, int start, int end, Integer findVal, int[] alfaCntArr){
		if(start>end)
			return null;
		Integer mid=(start+end)/2;
		if(findVal>inArr[mid]){
			return divide(inArr, mid+1, end, findVal, alfaCntArr);
		}
		else if(findVal<inArr[mid]){
			return divide(inArr, start, mid-1, findVal, alfaCntArr);
		}
		else{
			--alfaCntArr[findVal];
			if(alfaCntArr[findVal]==0){
				return mid;
			}else{
				Integer pos=divide(inArr, mid+1, end, findVal, alfaCntArr);
				if(pos!=null){
					return pos;
				}else{
					pos=divide(inArr, start, mid-1, findVal, alfaCntArr);
					return pos;
				}
			}
		}
	}
	
	static class valCompare implements Comparator<Integer>{
		public int compare(Integer a, Integer b){
			return alphaStartCount[a].compareTo(alphaStartCount[b]);
		}
	}

}

/*15
2
di
cf
2
ok
ok
3
so
ls
ox
4
ss
ss
ss
ss
3
so
so
so
3
az
az
az
4
bc
de
ab
cd
8
ab
ga
bc
cg
fc
cd
ef
de
4
aa
aa
aa
bb
4
aa
ab
aa
ab
5
aa
aa
aa
aa
aa
2
aa
az
1
bb
1
an
4
ab
ba
cd
dc*/
