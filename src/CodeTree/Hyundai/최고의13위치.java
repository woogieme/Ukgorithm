package CodeTree.Hyundai;

import java.util.*;
import java.io.*;
public class 최고의13위치 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int [N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result=0;
        for(int i=0; i<N; i++){

            for(int j=0; j<N-2; j++){
                int answer=0;
                for(int k=j; k<j+3; k++){
                    if(arr[i][k]==1){
                        answer++;
                    }
                }
                result=Math.max(answer,result);
            }

        }
        System.out.println(result);
    }
}