package CodeTree.Simul.SoloMove;

import java.util.*;
import java.io.*;

public class 주사위던지기 {
    static int N;
    static int M;
    static int R;
    static int C;
    //L R U D
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] map;
    static int[] row = {4,6,3};
    static int[] col = {2,6,5,1};

    static void print(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result =0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken())-1;
        C = Integer.parseInt(st.nextToken())-1;

        map = new int[N][N];

        st = new StringTokenizer(br.readLine());

        result+=6;
        int posX = R;
        int posY = C;

        map[posX][posY]=result;

        while(st.hasMoreTokens()){

            String howV = st.nextToken();

            int nexti=0;
            int nextj=0;

            int tmp=0;


            if(howV.equals("L")){
                nexti = posX+dx[0];
                nextj = posY+dy[0];
                if(nexti<0 || nexti>=N || nextj<0 || nextj>=N){
                    continue;
                }

                int tmpRow = row[2];
                for(int i=row.length-2; i>=0; i--){
                    row[i+1]=row[i];
                }
                row[0]=col[3];
                col[3]=tmpRow;
                col[1]=row[1];
                tmp=col[1];
            }else if(howV.equals("R")){
                nexti = posX+dx[1];
                nextj = posY+dy[1];
                if(nexti<0 || nexti>=N || nextj<0 || nextj>=N){
                    continue;
                }
                int tmpRow = row[0];
                for(int i=0; i<row.length-1; i++){
                    row[i]=row[i+1];
                }
                row[2]=col[3];
                col[3]=tmpRow;
                col[1]=row[1];
                tmp=col[1];

            }else if(howV.equals("U")){
                nexti = posX+dx[2];
                nextj = posY+dy[2];
                if(nexti<0 || nexti>=N || nextj<0 || nextj>=N){
                    continue;
                }
                int tmpCol = col[0];
                for(int i=0; i<col.length-1; i++){
                    col[i]=col[i+1];
                }
                col[3]=tmpCol;
                row[1]=col[1];
                tmp=col[1];
            }else if(howV.equals("D")){
                nexti = posX+dx[3];
                nextj = posY+dy[3];
                if(nexti<0 || nexti>=N || nextj<0 || nextj>=N){
                    continue;
                }
                int tmpCol = col[3];
                for(int i=col.length-2; i>=0; i--){
                    col[i+1]=col[i];
                }
                col[0]=tmpCol;
                row[1]=col[1];
                tmp=col[1];
            }


            posX=nexti;
            posY=nextj;

            if(map[posX][posY]!=0){
                result-=map[posX][posY];
                map[posX][posY]=tmp;
                result+=tmp;
            }else{
                map[posX][posY]=tmp;
                result+=tmp;

            }
        }

        System.out.println(result);
    }
}