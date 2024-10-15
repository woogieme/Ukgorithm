package CodeTree.BackTracking.ChooseNofK;

import java.util.*;
import java.io.*;

public class 일차원윷놀기 {
    static int N;
    static int M;
    static int K;
    static int[] arr;
    static int[] target;
    static int[] result;
    static HashMap<Integer,Integer> hMap;
    static int maxValue;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        maxValue=Integer.MIN_VALUE;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[N];
        target =new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        hMap = new HashMap<>();
        for(int i=0; i<K; i++){
            target[i] = i;
            hMap.put(i,0);
        }

        //턴의수 n
        //윷놀이 판 m
        //말의 수 k

        //순열 ?
        perm(0);
        //중복순열



        //턴의수 2,4,2,4


        // 여기에 코드를 작성해주세요.
        System.out.println(maxValue);
    }

    static void perm(int cnt){
        if(cnt==N){

            hMap = new HashMap<>();
            for(int i=0; i<K; i++){
                hMap.put(i,0);
            }

            for(int i=0; i<N; i++){
                if(hMap.containsKey(result[i])){
                    hMap.put(result[i],hMap.get(result[i])+arr[i]);
                }
            }
            Set<Integer> k = hMap.keySet();
            int B=0;
            for(Integer t: k){
                if(hMap.get(t)>=M-1){
                    B++;
                }
            }
            maxValue=Math.max(maxValue,B);

            return;
        }

        for(int i=0; i<K; i++){
            result[cnt] = target[i];
            perm(cnt+1);
        }
    }
}
