package CodeTree.PrefixSum;

import java.util.*;
import java.io.*;

public class 범위내에있는점의수2 {
    public static final int MAX_N = 1000000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] arr = new int[MAX_N+1];
        int[] prefixSum = new int[MAX_N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[num]=1;
        }
        prefixSum[0]=0;
        for(int i=1; i<=MAX_N; i++){
            prefixSum[i] = prefixSum[i-1]+arr[i];
        }

        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int tmp=x;
            if(x==0){
                tmp=1;
            }
            int num = prefixSum[y]-prefixSum[tmp-1];
            System.out.println(num);
        }

    }
}
