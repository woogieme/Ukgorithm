package Softeer.Level2;

import java.util.*;
import java.io.*;
public class 성적평균 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        // HashMap<Integer,Integer> hMap = new HashMap<>();
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] sub = new int[N+1];
        sub[0]=0;
        sub[1]=arr[0];
        for(int i=1; i<=N; i++){
            sub[i] = sub[i-1]+arr[i];
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            double count = end-start +1;

            double score = sub[end]-sub[start-1];

            double answer = Math.round((score/count)*100)/100.0;
            System.out.println(String.format("%.2f",answer));



        }


    }
}

