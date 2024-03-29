package CodeTree.Simul.BruteForce;

import java.util.*;
import java.io.*;

public class 금채굴하기 {

    static int N;
    static int M;
    static int[][] map;
    static int[][] cmap;
    static boolean[][] flagmap;
    static int result;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void collectGold(int fi, int fj){

        //세어진 격자객수
        int cntBox=1;
        int kValue=1;
        int value=0;
        int gold=0;
        int tmpResult=0;
        copy();
        cmap[fi][fj]=3;
        flagmap[fi][fj]=true;
        if(map[fi][fj]==1){
            tmpResult=1;
        }
        if(result<tmpResult){
            result=tmpResult;
        }
        //System.out.println(tmpResult);


        //2부터 시작
        while(true){
            int k= kValue*kValue +(kValue+1) * (kValue+1);
            //n*n을 넘으면 종료
            if(cntBox>=N*N){
                break;
            }
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(cmap[i][j]==3 && flagmap[i][j]==true){
                        for(int d=0; d<4; d++){
                            int nexti = i+dx[d];
                            int nextj = j+dy[d];
                            if(nexti>-1 && nextj>-1 &&nexti<N && nextj<N && flagmap[nexti][nextj]==false){
                                cmap[nexti][nextj]=3;
                            }
                        }
                    }
                }
            }
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(cmap[i][j]==3 && flagmap[i][j]==false){
                        flagmap[i][j]=true;
                        cntBox++;
                    }
                }
            }
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(cmap[i][j]==3 && flagmap[i][j]==true && map[i][j]==1){
                        gold++;
                        value+=M;
                    }
                }
                //print();
                //System.out.println(gold);
            }
            //System.out.println(value);

            //k는 금채굴 비용
            //value는 금값
            //손해를 보지않는다면?
            if(k<=value){
                //여태까지 캤던 금이 원래 캔 금보다 많다면?
                if(gold>=tmpResult ){
                    tmpResult=gold;
                    //System.out.println(k+" "+value+" "+result+" "+gold);
                    if(result<=tmpResult){
                        result=tmpResult;
                    }

                }
            }
            kValue++;
            value=0;
            gold=0;
            //print();
            //print2();
            //System.out.println(cntBox);

        }


    }

    public static void copy(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                cmap[i][j] = map[i][j];
            }
        }
    }

    public static void print(){
        System.out.println("=======================");
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(cmap[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void print2(){
        System.out.println("=======================");
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(flagmap[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        cmap = new int[N][N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                //if(i==3 &&j==3){
                flagmap = new boolean[N][N];
                collectGold(i,j);
                // }
            }
        }
        System.out.println(result);


    }
}