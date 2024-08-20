package CodeTree.TwoPointer;

import java.util.*;
import java.io.*;

public class 바구니안의사탕 {
    static final int MAX_VALUE = 10000000;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[1000001];

        for(int i=0; i<N; i++){
            st =new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[y]=x;

        }

        long result =0;

        for(int i=0; i<=1+K+K; i++){
            if(i>=1000001){
                break;
            }
            result+=arr[i];
        }

        int i = 0;
        int j = 1+K+K;
        long value =result;
        while(true){

            if(j+1>=1000001 || i+1>=1000001){
                break;
            }
            value-=arr[i++];
            value+=arr[++j];

            result = Math.max(result,value);

        }
        System.out.println(result);

        // 여기에 코드를 작성해주세요.
    }
}