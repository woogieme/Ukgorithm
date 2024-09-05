package CodeTree.JustSolve;

import java.util.*;
import java.io.*;
public class 마라톤중간에택시타기 {

    public static class Pair{
        int x;
        int y;

        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Pair[] arr = new Pair[N];

        int[] L = new int[N];
        int[] R = new int[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i] = new Pair(x,y);
        }

        L[0]=0;
        R[N-1]=0;
        for(int i=1; i<N; i++){
            int num = Math.abs(arr[i].x-arr[i-1].x) +Math.abs(arr[i].y-arr[i-1].y);
            L[i] = L[i-1]+Math.abs(num);
        }

        for(int i=N-2; i>=0; i--){
            int num = Math.abs(arr[i].x-arr[i+1].x) +Math.abs(arr[i].y-arr[i+1].y);
            R[i] = R[i+1]+Math.abs(num);
        }

        int result = Integer.MAX_VALUE;
        for(int i=1; i<N-1; i++){
            int tmp = Math.abs(arr[i-1].x-arr[i+1].x) +Math.abs(arr[i-1].y-arr[i+1].y);
            int value = L[i-1]+R[i+1]+tmp;
            if(result>value){
                result=value;
            }
        }
        System.out.println(result);
        // for(int i=0;i<N;i++){
        //     System.out.print(L[i]+" "+R[i]);
        //     System.out.println();
        // }

        // for(int i=N-1; i>=0; i--){

        // }
        // 여기에 코드를 작성해주세요.
    }
}
