package CodeTree.DP;

import java.util.*;
import java.io.*;

public class 정수사각형의최대 {

    public static void main(String[] args) throws IOException{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        int[][] dp = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int tmp =  Integer.parseInt(st.nextToken());
                map[i][j] =tmp;
            }
        }
        dp[0][0]=map[0][0];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i==0 && j>0){
                    if(map[i][j]<dp[i][j-1]){
                        dp[i][j]=map[i][j];
                    }else{
                        dp[i][j]=dp[i][j-1];
                    }
                }else if(i>0 && j==0){
                    if(map[i][j]<dp[i-1][j]){
                        dp[i][j]=map[i][j];
                    }else{
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
        }

        for(int i=1; i<N; i++){
            for(int j=1; j<N; j++){
                dp[i][j] =Math.min(Math.max(dp[i-1][j],dp[i][j-1]),map[i][j]);
            }
        }
        System.out.println(dp[N-1][N-1]);
        // 여기에 코드를 작성해주세요.
    }
}

