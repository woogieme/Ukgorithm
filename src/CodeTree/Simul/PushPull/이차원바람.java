package CodeTree.Simul.PushPull;

import java.util.*;
import java.io.*;

public class 이차원바람 {

    static final int MAX_N=100;
    static final int MAX_M=100;
    static final int MAX_Q=100;

    static int N;
    static int M;
    static int Q;

    static int jStart;
    static int jEnd;
    static int iStart;
    static int iEnd;

    static int[] dx= {1,0,-1,0};
    static int[] dy= {0,1,0,-1};

    static int[][] map= new int[MAX_N][MAX_M];
    static int[][] copy= new int[MAX_N][MAX_M];
    static boolean [][] visit = new boolean[MAX_N][MAX_M];


    static boolean check(int i, int j){
        if(i>=iStart && i<=iEnd && j>=jStart && j<=jEnd){
            return true;
        }
        return false;
    }

    static boolean checkRange(int i, int j){
        if(i>-1 && i<N && j>-1 && j<M){
            return true;
        }
        return false;
    }

    static void print(){
        System.out.println("=======================");
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("=======================");
    }
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                copy[i][j]=map[i][j];
            }
        }

        while(true){
            visit = new boolean[MAX_N][MAX_M];
            if(Q==0){
                break;
            }
            st = new StringTokenizer(br.readLine());

            iStart = Integer.parseInt(st.nextToken())-1;
            jStart = Integer.parseInt(st.nextToken())-1;
            iEnd = Integer.parseInt(st.nextToken())-1;
            jEnd = Integer.parseInt(st.nextToken())-1;

            int nowi=iStart;
            int nowj=jStart;
            int d=0;
            int value = map[nowi][nowj];


            while(true){

                int nexti = nowi+dx[d];
                int nextj = nowj+dy[d];

                if(nexti==iStart && nextj==jStart){
                    map[nowi][nowj]=value;
                    break;
                }

                if(check(nexti,nextj) && !visit[nexti][nextj]){
                    map[nowi][nowj] = map[nexti][nextj];
                    nowi = nexti;
                    nowj = nextj;
                    visit[nexti][nextj]=true;
                }else{
                    d=(d+1)%4;
                }
            }
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    int sValue=0;
                    int tmp = map[i][j];
                    int count = 1;
                    if(check(i,j)){
                        for(int dp=0; dp<4; dp++){
                            int nexti = i+dx[dp];
                            int nextj = j+dy[dp];
                            if(checkRange(nexti,nextj)){
                                tmp+=map[nexti][nextj];
                                count++;
                            }
                        }
                        sValue=tmp/count;
                        copy[i][j]=sValue;

                    }
                    else{
                        copy[i][j]=tmp;
                    }
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    map[i][j]=copy[i][j];
                }
            }
            Q--;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

    }
}