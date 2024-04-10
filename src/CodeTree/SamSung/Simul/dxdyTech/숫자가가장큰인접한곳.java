package CodeTree.SamSung.Simul.dxdyTech;

import java.io.*;
import java.util.*;

public class 숫자가가장큰인접한곳 {
    static int N;
    static int M;
    static int T;
    static int[][] map;
    static int[][] goosleMap;
    static int[] dx ={-1,1,0,0};
    static int[] dy ={0,0,-1,1};

    static Number[] numbers;

    static int numberCnt;

    static public class Number{
        int x;
        int y;
        public Number(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static void moveMap(int x,int y){

        int result = -1;
        int centerX=0;
        int centerY=0;

        for(int d=0; d<4; d++){
            int nexti = x+dx[d];
            int nextj = y+dy[d];
            if(nexti>=0 && nexti<N && nextj>=0 && nextj<N && map[nexti][nextj]>result){
                result=map[nexti][nextj];
                centerX=nexti;
                centerY=nextj;
            }
        }
        //System.out.println(centerX+" "+centerY);
        goosleMap[x][y]-=1;
        goosleMap[centerX][centerY]+=1;

    }

    static void bombMap(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(goosleMap[i][j]>=2){
                    goosleMap[i][j]=0;
                }else if(goosleMap[i][j]==1){
                    numberCnt++;
                }
            }
        }
    }

    static void print(){
        System.out.println("====================================");
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(goosleMap[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //맵의 크기
        N=Integer.parseInt(st.nextToken());


        //구슬 갯수
        M=Integer.parseInt(st.nextToken());
        //시간
        T=Integer.parseInt(st.nextToken());

        map = new int[N][N];

        goosleMap = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        numbers = new Number[M];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            goosleMap[x][y]=1;
            numbers[i] = new Number(x,y);
        }

        //print();
        while(true){
            numberCnt=0;
            if(T==0){
                break;
            }
            int tmp = numbers.length;

            for(int i=0; i<tmp; i++){
                moveMap(numbers[i].x,numbers[i].y);
            }

            //print();
            bombMap();
            numbers = new Number[numberCnt];
            int cnt=0;
            for(int x=0; x<N; x++){
                for(int y=0; y<N; y++){
                    if(goosleMap[x][y]==1){
                        numbers[cnt] = new Number(x,y);
                        cnt++;
                    }

                }
            }

            T--;
        }

        int result=0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(goosleMap[i][j]==1 ){
                    result++;
                }
            }
        }

        System.out.println(result);


    }
}