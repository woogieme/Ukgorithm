package CodeTree.SamSung.BFS;

import java.util.*;
import java.io.*;

public class 네방향탈출가능여부판별 {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static public class Snake{
        int x;
        int y;
        public Snake(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    static boolean inRange(int x,int y){
        return x>=0 && x<N && y>=0 && y<M && map[x][y]==1;
    }

    static void BFS(int x,int y){
        Queue<Snake> queue = new ArrayDeque<>();
        queue.add(new Snake(x,y));
        visited[x][y]=true;
        boolean isFlag=false;
        while(!queue.isEmpty()){
            Snake q = queue.poll();
            int ix = q.x;
            int jx = q.y;
            //System.out.println(ix+" "+jx);
            if(ix==N-1 && jx==M-1){
                isFlag=true;
                break;
            }
            for(int d=0; d<4; d++){
                int nexti = ix+dx[d];
                int nextj = jx+dy[d];
                if(inRange(nexti,nextj) && !visited[nexti][nextj]){
                    queue.add(new Snake(nexti,nextj));
                    visited[nexti][nextj]=true;
                }
            }
        }
        if(isFlag){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS(0,0);

    }
}