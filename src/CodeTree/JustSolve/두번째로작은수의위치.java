package CodeTree.JustSolve;

import java.util.*;
import java.io.*;

public class 두번째로작은수의위치 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());


        int[] arr = new int[N];
        int[] brr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            brr[i] = arr[i];
        }

        Arrays.sort(brr);

        int count=0;
        int point=-1;
        for(int i=0; i<N-1; i++){
            if(brr[i]!=brr[i+1]){
                if(count==0){
                    point=brr[i+1];
                    count++;
                    continue;
                }
            }
            if(count==1 && (brr[i+1]==point)){
                point =-1;
                break;
            }
        }

        if(point==-1){
            System.out.println(point);
        }else{
            for(int i=0; i<N; i++){
                if(arr[i]==point){
                    System.out.println(i+1);
                    break;
                }
            }
        }



    }
}