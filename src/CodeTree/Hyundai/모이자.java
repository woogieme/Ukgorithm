package CodeTree.Hyundai;

import java.util.*;
import java.io.*;
public class 모이자 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr =new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }


        int answer = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            int sum=0;
            for(int j=0; j<N; j++){
                sum+=(Math.abs(i-j)*arr[j]);
            }
            answer= Math.min(sum,answer);
        }
        System.out.println(answer);

    }
}