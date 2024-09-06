package CodeTree.PreProcessing;

import java.util.*;
import java.io.*;

public class 이상한폭탄 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] brr = new int[1000000];
        boolean[] checked = new boolean[1000000];

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }

        int result =Integer.MIN_VALUE;

        for(int i=0; i<N; i++){
            if(!checked[arr[i]]){
                brr[arr[i]]=i;
                checked[arr[i]]=true;
            }else{
                if(i-brr[arr[i]] <=K && result<arr[i]){
                    brr[arr[i]]=i;
                    checked[arr[i]]=true;
                    result=arr[i];
                }else if(i-brr[arr[i]]> K){
                    brr[arr[i]]=i;
                }
            }
        }
        if(result==Integer.MIN_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
        // 여기에 코드를 작성해주세요.
    }
}