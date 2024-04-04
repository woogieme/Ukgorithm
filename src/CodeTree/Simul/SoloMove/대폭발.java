package CodeTree.Simul.SoloMove;

import java.util.*;
import java.io.*;

public class 대폭발 {
    static int N;
    static int M;
    static int R;
    static int C;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Point> queue;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int result;

    static void explore(int bombRange){

        while(true){
            Point tmpQueue = queue.poll();

            for(int d=0; d<4; d++){
                int nexti = tmpQueue.x+(dx[d]*bombRange);
                int nextj = tmpQueue.y+(dy[d]*bombRange);

                if(nexti<0 || nexti>=N || nextj<0 || nextj>=N ){
                    continue;
                }
                map[nexti][nextj]=1;
            }

            if(queue.isEmpty()){
                break;
            }
        }

    }

    static void countResult(){

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==1){
                    result++;
                }
            }
        }

    }

    static void countBomb(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==1){
                    queue.add(new Point(i,j));
                }
            }
        }

    }

    static void print(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) throws IOException{

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        queue = new ArrayDeque();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken())-1;
        C = Integer.parseInt(st.nextToken())-1;

        //맵 초기화
        map = new int[N][N];

        //count -> 폭탄 범위 및 초
        int count=1;

        //폭탄이 몇개있는지?
        result=0;

        //최초 폭탄위치
        queue.add(new Point(R,C));
        map[R][C]=1;
        while(true){

            //폭탄범위 구하기
            int bombRange = (int) Math.pow(2,count-1);
            //System.out.println(bombRange);
            //폭탄 놓기
            explore(bombRange);

            //폭탄몇개있는지 검사
            countBomb();

//            print();
//            System.out.println("================");
            //초 증가
            count++;
            if(count==M+1){
                break;
            }
        }
        countResult();
        System.out.print(result);
    }

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}