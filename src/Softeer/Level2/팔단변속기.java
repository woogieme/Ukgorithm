package Softeer.Level2;

import java.util.*;
import java.io.*;
public class 팔단변속기 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr=new int[8];

        for(int i=0; i<8; i++){
            arr[i] =Integer.parseInt(st.nextToken());
        }

        //if ascending?
        int cnt=1;
        boolean isASC=false;

        for(int i=0; i<8; i++){
            if(arr[i]==cnt){
                cnt++;
                continue;
            }
            isASC=true;
            break;

        }

        if(!isASC){
            System.out.println("ascending");
            return;
        }
        //if descending?

        isASC=false;
        cnt=8;
        for(int i=0; i<8; i++){
            if(arr[i]==cnt){
                cnt--;
                continue;
            }
            isASC=true;
            break;
        }

        if(!isASC){
            System.out.println("descending");
        }else{
            System.out.println("mixed");
        }
        //is mixed
    }
}

