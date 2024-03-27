package CodeTree.Simul.PushPull;

import java.util.*;
import java.io.*;

public class 컨베이어벨트 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int [] arr = new int[N*2];

        int cnt=0;
        for(int i= 0; i<2; i++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                arr[cnt]=Integer.parseInt(st.nextToken());
                //System.out.print(arr[cnt]+" ");
                cnt++;
            }
        }

        for(int i=0; i<T; i++){
            int tmp = arr[cnt-1];
            for(int j=cnt-2; j>=0; j--){
                arr[j+1]=arr[j];

            }
            arr[0]=tmp;
        }
        // for(int i= 0; i<N;i++){
        //     System.out.print(arr[i]+" ");
        // }
        for(int j=0; j<N*2; j++){
            if(j==(N*2)/2){
                System.out.println();
            }
            System.out.print(arr[j]+" ");
        }

    }

}