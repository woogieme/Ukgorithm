package CodeTree.JustSolve;

import java.util.*;
import java.io.*;

public class LR그리고B {
    static int N;
    static int[] dx ={0,1,0,-1};
    static int[] dy ={1,0,-1,0};
    static int result=0;
    static char[][] chr;
    static int count=-1;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        chr = new char[10][10];

        N = 10;
        int x=0;
        int y=0;
        for(int i=0; i<N; i++){
            chr[i]= br.readLine().toCharArray();
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(chr[i][j]=='L'){
                    x=i;
                    y=j;
                }
            }
        }
        bfs(x,y);
        System.out.println(result);
        // 여기에 코드를 작성해주세요.

    }
    static class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static boolean inRange(int x,int y){
        return x>=0 && y>=0 && x<N && y<N;
    }
    static void bfs(int x,int y){
        Queue<Pair> pair = new ArrayDeque<>();
        pair.add(new Pair(x,y));
        boolean[][] checked = new boolean[N][N];
        checked[x][y]=true;
        boolean isFlag=false;
        while(!pair.isEmpty()){
            int size = pair.size();
            count++;
            for(int i=0; i<size; i++){
                Pair p = pair.poll();
                if(chr[p.x][p.y]=='B'){
                    isFlag=true;
                    result=count-1;
                    break;
                }
                for(int d=0; d<4; d++){
                    int nexti = p.x+dx[d];
                    int nextj = p.y+dy[d];

                    if(inRange(nexti,nextj) && chr[nexti][nextj]!='R' && !checked[nexti][nextj]){
                        pair.add(new Pair(nexti,nextj));
                        checked[nexti][nextj]=true;
                    }
                }
            }
            if(isFlag){
                break;
            }
        }
    }
}