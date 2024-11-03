package Programmers.Level2;

import java.util.*;

class 게임맵최단거리 {

    static int N;
    static int M;
    static int[][] map;
    static int[] dx ={0,1,0,-1};
    static int[] dy ={1,0,-1,0};

    static int[][] checked;
    static public class Pair{

        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int solution(int[][] maps) {
        int answer = 0;

        N = maps.length;
        M = maps[0].length;
        map =new int[N][M];
        checked =new int[N][M];
        for(int i=0; i<N; i++){

            for(int j=0; j<M; j++){
                map[i][j] =maps[i][j];
            }
        }

        for(int i=0; i<N; i++){

            for(int j=0; j<M; j++){
                checked[i][j] =Integer.MAX_VALUE;
            }
        }


        BFS(0,0);
        if(checked[N-1][M-1]==Integer.MAX_VALUE){
            return -1;
        }
        return checked[N-1][M-1];

    }
    static void BFS(int x,  int y){
        Queue<Pair> pair = new ArrayDeque<>();
        pair.add(new Pair(x,y));
        checked[x][y]=1;

        while(!pair.isEmpty()){
            Pair p = pair.poll();
            for(int d=0; d<4; d++){
                int nexti = p.x+dx[d];
                int nextj = p.y+dy[d];

                if(inRange(nexti,nextj) && map[nexti][nextj]==1 && checked[nexti][nextj]>checked[p.x][p.y]+1){
                    checked[nexti][nextj]=checked[p.x][p.y]+1;
                    pair.add(new Pair(nexti,nextj));
                }
            }
        }
    }
    static boolean inRange(int x,int y){
        return x>=0 && x<N && y>=0 && y<N;
    }
}