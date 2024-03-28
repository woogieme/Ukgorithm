package CodeTree.Simul.Bomb;

import java.util.*;
import java.io.*;
public class 십자모양폭발 {

    static int N;
    static int[][] map;
    static int[][] copy;
    static int bx;
    static int by;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        copy = new int[N][N];

        for(int i = 0; i<N;i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        bx = Integer.parseInt(st.nextToken())-1;
        by = Integer.parseInt(st.nextToken())-1;

        int dot = map[bx][by];
        map[bx][by]=0;
        //폭탄 터트리기
        for(int d =0; d<4; d++){
            int nexti = bx+dx[d];
            int nextj = by+dy[d];
            for(int i=0; i<dot-1; i++){
                if(nexti>=0 && nexti <N && nextj >=0 && nextj<N){
                    map[nexti][nextj]=0;
                }
                nexti+=dx[d];
                nextj+=dy[d];
            }
        }
        //폭탄 내리기

        for(int i=0; i<N; i++){
            int tmp=N-1;
            for(int j= N-1; j>=0; j--){
                if(map[j][i]!=0){
                    copy[tmp][i]=map[j][i];
                    tmp--;
                }
            }
        }



        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(copy[i][j]+" ");
            }
            System.out.println();
        }


    }
}