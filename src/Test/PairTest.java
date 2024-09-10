package Test;

import java.util.*;
import java.io.*;
public class PairTest {
    static int[][] dp;
    static int[][] map;
    static int N;
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

    static class Pair{
        int x;
        int y;
        int value;
        Pair(int x,int y,int value){
            this.x=x;
            this.y=y;
            this.value=value;
        }
    }

    static int goFindMax(int x,int y,int xyValue){

        int[] dx ={0,1,0,-1};
        int[] dy ={1,0,-1,0};

        ArrayDeque<Pair> pair = new ArrayDeque<>();
        pair.add(new Pair(x,y,xyValue));

        int zeroNum=0;
        int count=0;
        while(!pair.isEmpty()){
            int size = pair.size();
            count++;
            for(int si=0; si<size; si++){
                Pair pairTmp = pair.poll();
                int i = pairTmp.x;
                int j = pairTmp.y;
                zeroNum=Math.max(zeroNum,count);

                for(int d=0; d<4; d++){
                    int nexti = i+dx[d];
                    int nextj = j+dy[d];
                    if(inRange(nexti,nextj) && inMax(nexti,nextj,map[i][j]) &&dp[nexti][nextj]!=0){
                        zeroNum=Math.max(zeroNum,dp[nexti][nextj]+1);
                    }
                    else if(inRange(nexti,nextj) && inMax(nexti,nextj,map[i][j])){
                        pair.add(new Pair(nexti,nextj,count));
                    }
                }
            }
        }
        return count;

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
                int tmp = goFindMax(i,j,value);
                dp[i][j]=Math.max(dp[i][j],tmp);
                findMax=Math.max(findMax,tmp);
            }
        }
        System.out.println(findMax);

    }
}