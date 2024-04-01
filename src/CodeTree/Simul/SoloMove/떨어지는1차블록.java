package CodeTree.Simul.SoloMove;

import java.io.*;
import java.util.*;

public class 떨어지는1차블록 {
    static int N;
    static int M;
    static int K;
    static int[][] map;
    static int[][] copy;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken())-1;

        map = new int[N][N];
        copy = new int[N][N];
        int result= -1;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int point=0;
        for(int i=0; i<N; i++){
            boolean isFlag=false;
            for(int j=K; j<M+K; j++){
                if(map[i][j]!=0){
                    isFlag=true;
                }
            }
            if(!isFlag && result < i){
                result=i;
            }
            else if(isFlag){
                break;
            }
        }
        for(int i=K; i<M+K; i++){

            map[result][i]=1;
        }

        for(int i=0; i<N; i++){

            for(int j=0; j<N; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}