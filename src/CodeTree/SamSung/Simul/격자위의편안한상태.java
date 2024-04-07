package CodeTree.SamSung.Simul;

import java.io.*;
import java.util.*;

public class 격자위의편안한상태 {
    static int N;
    static int M;
    static int centerX;
    static int centerY;
    static int[] dx={1,0,-1,0};
    static int[] dy={0,1,0,-1};
    static int result;
    static int[][] map;
    static StringBuilder sb =new StringBuilder();

    static boolean comStatus(int cX, int cY){

        int result=0;

        for(int d=0; d<4; d++){
            int nexti = cX+dx[d];
            int nextj = cY+dy[d];
            if(nexti>=0 && nexti<N && nextj>=0 && nextj<N && map[nexti][nextj]==1){
                result++;
            }
        }

        if(result==3){
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            centerX = Integer.parseInt(st.nextToken())-1;
            centerY = Integer.parseInt(st.nextToken())-1;
            map[centerX][centerY]=1;
            if(comStatus(centerX,centerY)){
                sb.append(1).append("\n");
            }else{
                sb.append(0).append("\n");
            }

        }
        // for(int i=0; i<N; i++){
        //     for(int j=0; j<N; j++){
        //         System.out.print(map[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        System.out.println(sb.toString());
    }
}
