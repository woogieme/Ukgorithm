package CodeTree.JustSolve;

import java.util.*;
import java.io.*;
public class 개발자가위바위보 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr =new int[4][4];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            arr[x][y]+=1;
        }

        int result=0;

        // 0 -> 1
        // 0 -> 2

        // 1 -> 0
        // 1 -> 2

        // 2 -> 0
        // 2 -> 1

        //0 주먹 1 가위 2 보

        // 0 -> 1 , 1-> 2, 2 -> 0
        //

        // 0 -> 2 , 2-> 1 , 1 -> 0,

        // 1 -> 0 , 2 -> 1
        // 1 -> 2 , 0 -> 1

        // 2 -> 0 , 1 -> 2
        // 2 -> 1 , 0 -> 2

        result = Math.max(arr[0][1]+arr[1][2]+arr[2][0],arr[0][2]+arr[2][1]+arr[1][0]);
        // for(int i=0; i<3; i++){


        //     // for(int j=0; j<2; j++){
        //         System.out.println((i%3)+" "+((i+1)%3)+" "+((i+2)%3)+" "+(i%3));
        //         System.out.println((i%3)+" "+((i+2)%3)+" "+((i+1)%3)+" "+(i%3));
        //         result = Math.max(arr[i%3][(i+1)%3]+arr[(i+1)%3][(i+2)%3]+arr[(i+2)%3][i%3],result);
        //         result = Math.max(arr[i%3][(i+2)%3]+arr[(i+1)%3][i%3],result);
        //     // }

        // }
        System.out.println(result);
    }
}