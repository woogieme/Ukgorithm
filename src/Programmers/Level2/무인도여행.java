package Programmers.Level2;

import java.util.*;

class 무인도여행 {
    static int N;
    static int M;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static char[][] map;
    static boolean[][] checked;
    static ArrayList<Integer> arr;
    public int[] solution(String[] maps) {

        arr =new ArrayList<>();
        map = new char[maps.length][maps[0].length()];
        N = maps.length;
        M = maps[0].length();
        checked =new boolean[N][M];

        for(int i=0; i<map.length; i++){
            map[i] = maps[i].toCharArray();
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]!='X' && !checked[i][j]){
                    BFS(i,j);
                }
            }
        }
        if(arr.size()==0){
            return new int[]{-1};
        }
        int[] answer = new int[arr.size()];
        for(int i=0; i<arr.size(); i++){
            answer[i] = arr.get(i);
        }
        Arrays.sort(answer);


        return answer;
    }
    public class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public void BFS(int x,int y){
        Queue<Pair> pair = new ArrayDeque<>();
        checked[x][y]=true;
        pair.add(new Pair(x,y));
        int answer=0;
        while(!pair.isEmpty()){
            Pair p = pair.poll();
            answer+=map[p.x][p.y]-'0';
            for(int d=0; d<4; d++){
                int nexti = p.x+dx[d];
                int nextj = p.y+dy[d];

                if(inRange(nexti,nextj) && !checked[nexti][nextj] && map[nexti][nextj]!='X'){
                    pair.add(new Pair(nexti,nextj));
                    checked[nexti][nextj]=true;
                }
            }
        }
        arr.add(answer);

    }
    public boolean inRange(int x,int y){
        return x>=0 && x<N && y>=0 && y<M;
    }
}