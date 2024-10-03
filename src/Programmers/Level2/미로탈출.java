package Programmers.Level2;

import java.util.*;
class 미로탈출 {
    static char[][] chr;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static int answer;
    static int N;
    static int M;
    static int[][] L;
    static int move;
    static int fL;
    static int dL;
    static int a;
    static int b;
    public void print(){

        for(int i=0; i<chr.length; i++){
            for(int j=0; j<chr[i].length; j++){
                if(chr[i][j]=='S'){
                    a=i;
                    b=j;
                    break;
                }
            }
        }
    }

    public class Pair{
        int x;
        int y;

        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int solution(String[] maps) {
        answer = 0;
        move = 0;
        fL=0;
        dL=0;
        chr = new char[maps.length][maps[0].length()];
        N = chr.length;
        M = chr[0].length;
        for(int i=0; i<maps.length; i++){
            chr[i] = maps[i].toCharArray();
        }
        print();
        if(!findL(a,b)){
            return -1;
        }
        if(!findE(fL,dL)){
            return -1;
        }
        return move-2;
    }
    public boolean inRange(int x,int y){
        if(x>=0 && x<N && y>=0 && y<M){
            return true;
        }
        return false;
    }
    public boolean findL(int x,int y){
        Queue<Pair> pair = new ArrayDeque<>();
        boolean[][] checked = new boolean[N][M];
        pair.add(new Pair(x,y));
        checked[x][y]=true;

        while(!pair.isEmpty()){
            int size = pair.size();
            move++;
            for(int i=0; i<size; i++){
                Pair p = pair.poll();
                if(chr[p.x][p.y]=='L'){
                    fL=p.x;
                    dL=p.y;
                    return true;
                }
                for(int d=0; d<4; d++){
                    int nexti=p.x+dx[d];
                    int nextj=p.y+dy[d];
                    if(inRange(nexti,nextj) && !checked[nexti][nextj] && chr[nexti][nextj]!='X'){
                        pair.add(new Pair(nexti,nextj));
                        checked[nexti][nextj]=true;
                    }
                }
            }
        }
        return false;
    }


    public boolean findE(int x,int y){
        Queue<Pair> pair = new ArrayDeque<>();
        boolean[][] checked = new boolean[N][M];
        pair.add(new Pair(x,y));
        checked[x][y]=true;

        while(!pair.isEmpty()){
            int size = pair.size();
            move++;
            for(int i=0; i<size; i++){
                Pair p = pair.poll();
                if(chr[p.x][p.y]=='E'){
                    return true;
                }
                for(int d=0; d<4; d++){
                    int nexti=p.x+dx[d];
                    int nextj=p.y+dy[d];
                    if(inRange(nexti,nextj) && !checked[nexti][nextj] && chr[nexti][nextj]!='X'){
                        pair.add(new Pair(nexti,nextj));
                        checked[nexti][nextj]=true;
                    }
                }
            }
        }
        return false;
    }

}
