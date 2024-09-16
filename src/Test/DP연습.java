package Test;

import java.util.*;
import java.io.*;
public class DP연습 {
    static int[][] dp;
    static int[][] map;
    static int N;
    static int result;
    static int valTmp;

    static void initializedDP(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                dp[i][j]=0;
            }
        }
    }
    static boolean inRange(int i,int j){
        if(i<0 || j<0 || i>=N || j>=N){
            return false;
        }
        return true;
    }

    static boolean inMax(int i,int j,int tmp){
        if(map[i][j]>tmp){
            return true;
        }
        return false;
    }

    static int findMax(int i,int j,int value){

        if(dp[i][j]!=0){
            return dp[i][j]+1;
        }

        int[] dx ={0,1,0,-1};
        int[] dy ={1,0,-1,0};

        for(int d=0; d<4; d++){
            int nexti = i+dx[d];
            int nextj = j+dy[d];

            if(inRange(nexti,nextj) && inMax(nexti,nextj,map[i][j])){
                int tmp = value+1;
                valTmp = findMax(nexti,nextj,tmp);
            }
            if(valTmp==0){
                result=Math.max(result,value);
            }else{
                result=Math.max(result,valTmp);
            }

        }
        return value;

    }
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new int[N][N];

        initializedDP();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int findMax=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int value=1;
                valTmp=0;
                result=0;
                int tmp = findMax(i,j,value);
                dp[i][j]=result;
                findMax=Math.max(findMax,result);
            }
        }
        System.out.println(findMax);

        // 여기에 코드를 작성해주세요.
    }
}