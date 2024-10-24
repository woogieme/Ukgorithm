package Softeer.Level2;

import java.util.*;
import java.io.*;
public class 지도자동구축 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[16];

        arr[0]=2;
        arr[1]=3;
        arr[2]=5;

        for(int i=3; i<=15; i++){
            arr[i]=(arr[i-1]*2)-1;
        }

        System.out.println(arr[N]*arr[N]);
    }
}

