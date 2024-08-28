package CodeTree.DFS;

import java.util.*;
import java.io.*;

public class 안전지대 {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] checked;
    static int[] dx ={0,1,0,-1};
    static int[] dy ={1,0,-1,0};
    static int result;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        checked =new boolean[N][M];
        result=0;
        for(int i=0; i<N; i++){
            st =new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int K=1;
        int safeZone=1;
        while(true){
            if(K==101){
                break;
            }
            int count=0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j]>K && !checked[i][j]){
                        count++;
                        DFS(i,j,K);
                    }
                }
            }
            if(result <count){
                result =count;
                safeZone=K;

            }
            result = Math.max(count,result);
            for(int i=0; i<N; i++){
                for (int j=0; j<M; j++){
                    checked[i][j]=false;
                }
            }
            K++;
        }
        System.out.println(safeZone+" "+result);
        // 여기에 코드를 작성해주세요.
    }

    static void DFS(int i,int j,int k){

        checked[i][j]=true;

        for(int d=0; d<4; d++){
            int nexti=i+dx[d];
            int nextj=j+dy[d];

            if(inRange(nexti,nextj) && map[nexti][nextj]>k && !checked[nexti][nextj]){
                DFS(nexti,nextj,k);
            }
        }

    }
    static boolean inRange(int x, int y){
        return x>=0 && x<N && y>=0 && y<M;
    }
}
