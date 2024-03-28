package CodeTree.Simul.Bomb;

import java.util.*;
import java.io.*;

public class 일차원젠가 {
    static int N;
    static int M;
    static int[] arr;
    static int[] brr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        brr = new int[N];

        for(int i= N-1; i>=0; i--){
            arr[i]= Integer.parseInt(br.readLine());
        }
        int endOfArray=N;
        for(int j=0; j<2; j++){

            StringTokenizer st =new StringTokenizer(br.readLine());
            int iTop= Integer.parseInt(st.nextToken());
            int iBot= Integer.parseInt(st.nextToken());
            int endOfTempArray=0;

            iTop=endOfArray-iTop;
            iBot=endOfArray-iBot;
            //System.out.println(iTop+" "+iBot);
            for(int i=0; i<endOfArray; i++){
                if(iTop<i || iBot>i){
                    brr[endOfTempArray] = arr[i];
                    endOfTempArray++;
                }
            }

            for(int i=0; i<endOfTempArray; i++){
                arr[i]=brr[i];

            }

            endOfArray = endOfTempArray;


        }
        System.out.println(endOfArray);
        if(endOfArray!=0){
            for(int i=endOfArray-1; i>=0;i--){
                System.out.println(arr[i]);
            }
        }

    }
}
