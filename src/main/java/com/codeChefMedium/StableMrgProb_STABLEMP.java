
package com.codeChefMedium;
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
 
public class StableMrgProb_STABLEMP {
 
    static Integer[] ansClone=null;
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int t=Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++){
            st=new StringTokenizer(br.readLine());
            int pairs=Integer.parseInt(st.nextToken());
            int[][] females=new int[pairs+1][pairs+1];
            for(int j=1;j<pairs+1;j++){
                st=new StringTokenizer(br.readLine());
                st.nextToken();
                for(int y=1;y<pairs+1;y++){
                    females[j][Integer.parseInt(st.nextToken())]=y;
                }
            }
            int[][] males=new int[pairs+1][pairs+1];
            int[] ans=new int[pairs+1];
            for(int x=1;x<pairs+1;x++){
                int cntOld=1;
                int cntNew=1;
                st=new StringTokenizer(br.readLine());
                st.nextToken();
                for(int y=1;y<pairs+1;y++){
                    males[x][y]=Integer.parseInt(st.nextToken());
                }
                int fem=males[x][cntOld];
                int prefMale=ans[fem];
                int maleCache=x;
                while(prefMale!=0){
                    if(females[fem][prefMale]>females[fem][x]){
                        cntOld=2;
                        ans[fem]=x;
                        x=prefMale;
                        fem=males[prefMale][cntOld];
                        prefMale=ans[fem];
                    }else{
//                        fem=Integer.parseInt(st.nextToken());
                        fem=males[x][++cntOld];
                        prefMale=ans[fem];
                    }
                }
                ans[fem]=x;
                x=maleCache;
            }
            ansClone=new Integer[ans.length];
           
            Integer[] obj=new Integer[ans.length];
            for(int p=0;p<obj.length;p++){
                  obj[p]=p;
                  ansClone[p]=ans[p];
            }
            Arrays.sort(obj, new valCompare());
           
            for(int o=1;o<obj.length;o++){
                  System.out.println(o+" "+obj[o]);
            }
           
        }
    }
   
    static class valCompare implements Comparator<Integer>{
      @Override
      public int compare(Integer a, Integer b){
            return ansClone[a].compareTo(ansClone[b]);
      }
    }
}
