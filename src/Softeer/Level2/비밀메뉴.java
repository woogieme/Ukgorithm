package Softeer.Level2;

import java.util.*;
import java.io.*;
public class 비밀메뉴 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr =new int[M];
        for(int i=0; i<M; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        int[] brr =new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            brr[i]= Integer.parseInt(st.nextToken());
        }

        if(N<M){
            System.out.println("normal");
        }
        else{

            //앞에존재할때
            int cnt=0;
            while(true){
                if((cnt+M)>N){
                    break;
                }
                int tmp = cnt;
                boolean isFlag=true;
                for(int j=0; j<M; j++){
                    if(brr[tmp]!=arr[j]){
                        isFlag=false;
                        break;
                    }
                    tmp++;
                }
                if(isFlag){
                    System.out.println("secret");
                    return;
                }
                cnt++;

            }

            // cnt=0;
            // while(true){
            //     if((cnt+M)>=N){
            //         break;
            //     }
            //     int tmp = cnt;
            //     boolean isFlag=true;
            //     for(int j=0; j<M; j++){
            //         if(brr[(brr.length-1)-tmp]!=arr[j]){
            //             isFlag=false;
            //             break;
            //         }
            //         tmp++;
            //     }
            //     if(isFlag){
            //         System.out.println("secret");
            //         return;
            //     }
            //     cnt++;

            // }

            System.out.println("normal");

            //뒤에존재할때
        }



    }
}

