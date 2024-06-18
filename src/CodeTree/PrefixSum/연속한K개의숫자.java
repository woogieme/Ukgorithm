package CodeTree.PrefixSum;

import java.io.*;
import java.util.*;

public class 연속한K개의숫자 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] prefix= new int[N];
        for(int i=0; i<B; i++){
            int tmp = Integer.parseInt(br.readLine())-1;
            arr[tmp]=1;
        }

        for(int i=0; i<N; i++){
            if(arr[i]==1){
                arr[i]=0;
            }else{
                arr[i]=1;
            }
        }
        int tmp=0;
        for(int i=0; i<N; i++){
            if(arr[i]==1){
                prefix[i]=arr[i]+tmp;
                tmp=prefix[i];
            }
        }

        int front=0;
        int rear=K-1;
        int result = Integer.MAX_VALUE;
        while(true){
            if(rear==N-1){
                break;
            }
            if(prefix[front]==0 ||prefix[rear]==0){
                front++;
                rear++;
                continue;
            }
            int value = prefix[rear]-prefix[front]+arr[front];

            if(result>(K-value)){
                result=K-value;
                //System.out.println(front+" "+rear+" "+K+" "+value+" "+(K-value));
            }
            front++;
            rear++;
        }
        if(result==Integer.MAX_VALUE){
            System.out.println(0);
        }
        else{
            System.out.println(result);
        }

    }
}