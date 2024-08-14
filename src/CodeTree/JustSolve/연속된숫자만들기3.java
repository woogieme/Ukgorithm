package CodeTree.JustSolve;

import java.util.*;
import java.io.*;
public class 연속된숫자만들기3 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());
        // 여기에 코드를 작성해주세요.

        int[] arr =new int[3];
        for(int i=0; i<3; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count=0;

        if(Math.abs(arr[0]-arr[1])==1 &&  Math.abs(arr[1]-arr[2])==1){
            count=0;
        }
        else if(Math.abs(arr[0]-arr[1]) <Math.abs(arr[1]-arr[2]) ){
            count=Math.abs(arr[1]-arr[2])-1;
        }else if(Math.abs(arr[1]-arr[2])<Math.abs(arr[0]-arr[1])){
            count=Math.abs(arr[0]-arr[1])-1;
        }else{
            count=Math.abs(arr[0]-arr[1])-1;
        }


        // while(true){
        //     Arrays.sort(arr);
        //     if(Math.abs(arr[0]-arr[1])==1 &&  Math.abs(arr[1]-arr[2])==1){
        //         break;
        //     }
        //     if(Math.abs(arr[0]-arr[1])==2){
        //         count++;
        //     }else if(Math.abs(arr[1]-arr[2])==2){
        //         count++;
        //     }
        // }
        System.out.println(count);
    }
}

//CADB
//ACBD
//ABCD
