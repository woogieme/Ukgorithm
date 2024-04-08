package CodeTree.SamSung.Simul.dxdyTech;

import java.util.*;
import java.io.*;

public class 빙빙돌숫자사각형채우기 {
    static int N;
    static int M;
    static int[][] map;
    static int[] dx ={0,1,0,-1};
    static int[] dy ={1,0,-1,0};
    static StringBuilder sb =new StringBuilder();

    static boolean inRange(int nexti,int nextj){
        return nexti>=0 && nexti<N && nextj>=0 && nextj<M;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        map[0][0]=1;
        int iStart=0;
        int jStart=0;
        int d=0;
        for(int i=2; i<=N*M; i++){
            //범위안에 들지않거나 다른값은 0이 아니면
            if(!inRange(iStart+dx[d],jStart+dy[d]) || map[iStart+dx[d]][jStart+dy[d]]!=0){
                d=(d+1)%4;
            }
            iStart +=dx[d];
            jStart +=dy[d];
            map[iStart][jStart]=i;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        // 여기에 코드를 작성해주세요.
    }
}