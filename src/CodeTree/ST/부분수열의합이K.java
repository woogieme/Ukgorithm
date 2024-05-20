package CodeTree.ST;

import java.util.*;
import java.io.*;

public class 부분수열의합이K {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        int[] prefix = new int[N+1];


        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            prefix[i] = prefix[i-1]+arr[i];
        }

        int count=0;
        for(int i=1; i<=N; i++){
            for(int j=i; j<=N; j++){
                if(prefix[j]-prefix[i-1]==M){
                    count++;
                }
            }
        }
        System.out.println(count);
        // 여기에 코드를 작성해주세요.
    }
}
