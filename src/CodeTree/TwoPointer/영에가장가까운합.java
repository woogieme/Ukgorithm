package CodeTree.TwoPointer;

import java.util.*;
import java.io.*;

public class 영에가장가까운합 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[N+1];
        for(int i=1; i<=N; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        int j=N;

        int ans = Integer.MAX_VALUE;
        Arrays.sort(a,1,N+1);
        for(int i=1; i<=N; i++){

            if(i<j){
                ans =Math.min(ans,Math.abs(a[i]+a[j]));
            }

            while(i<j-1 && a[i]+a[j]>0){
                j--;
                ans=Math.min(ans,Math.abs(a[i]+a[j]));
            }
        }
        System.out.println(ans);
        // 여기에 코드를 작성해주세요.
    }
}