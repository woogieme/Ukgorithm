package CodeTree.SamSung.Simul.dxdyTech;

import  java.io.*;

public class 가운데시작하여빙빙돌기 {
    static int N;
    static int[][] map;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    static StringBuilder sb = new StringBuilder();
    static boolean inRange(int i, int j){
        return i<0 || i>=N || j<0 || j>=N;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        map[N-1][N-1]=N*N;

        int centerX = N-1;
        int centerY = N-1;
        int d=0;

        for(int i=N*N-1; i>=1; i--){

            if(inRange(centerX+dx[d],centerY+dy[d]) || map[centerX+dx[d]][centerY+dy[d]]!=0){
                d= (d+1)%4;
            }
            int nexti = centerX+dx[d];
            int nextj = centerY+dy[d];
            centerX =nexti;
            centerY =nextj;
            map[nexti][nextj]=i;

        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}