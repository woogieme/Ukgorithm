package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.MAX_VALUE;

public class SW_4012_요리사 {
    static int N;
    static int[][] arr;
    static int T;
    static  boolean[] crr;
    static int[] A_food;
    static int[] B_food;
    static int[] A_food_sum =new int[2];
    static int[] B_food_sum =new int[2];
    static int minus_AB;
    static int value=MAX_VALUE;
    static int A_Last;
    static int B_Last;
    static int A_count;
    static int B_count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T=Integer.parseInt(st.nextToken());
        for (int tc =1; tc <=T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            crr = new boolean[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            A_food = new int[N / 2];
            B_food = new int[N / 2];
            value= MAX_VALUE;

            comb(0, 0);

            System.out.println("#"+tc+" "+value);
        }

    }

    private static void comb(int idx, int cnt) {
        if(cnt==N/2){
            A_count=0;
            B_count=0;
            for (int i = 0; i < N; i++) {
                if(crr[i]){
                    A_food[A_count]=i;
                    A_count+=1;
                }
                else{
                    B_food[B_count]=i;
                    B_count+=1;
                }
            }
            //System.out.println(Arrays.toString(A_food)+" : "+Arrays.toString(B_food));
            minus_AB=0;
            comb2(0,0);
            minus_AB=Math.abs(A_Last-B_Last);
            A_Last=0;
            B_Last=0;
            if(value>=minus_AB){
                value=minus_AB;
            }
            return;
        }
        if(idx==N){
            return;
        }
        crr[idx]=true;
        comb(idx+1,cnt+1);
        System.out.println("BEFORE : "+Arrays.toString(crr));
        crr[idx]=false;
        comb(idx+1,cnt);
        System.out.println("BEFORE : "+Arrays.toString(crr));
    }

    private static void comb2(int idx, int cnt) {
        if(idx==2){
            A_Last+=arr[A_food_sum[0]][A_food_sum[1]]+arr[A_food_sum[1]][A_food_sum[0]];
            B_Last+=arr[B_food_sum[0]][B_food_sum[1]]+arr[B_food_sum[1]][B_food_sum[0]];
            return;
        }
        for (int i = cnt; i < N/2; i++) {
            A_food_sum[idx]=A_food[i];
            B_food_sum[idx]=B_food[i];
            comb2(idx+1,i+1);
        }
    }
}