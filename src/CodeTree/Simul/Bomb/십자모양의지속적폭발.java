package CodeTree.Simul.Bomb;

import java.util.*;
import java.io.*;

public class 십자모양의지속적폭발 {
    static final int MAX_X=200;
    static final int MAX_Y=200;
    static int centerX;
    static int centerY;
    static int N;
    static int M;
    static int dot;
    static int[][] map = new int [MAX_X][MAX_Y];
    static int[][] copy = new int [MAX_X][MAX_Y];

    static boolean explosive(int posX,int posY,int bombRange){
        return (posX==centerX || posY==centerY) &&
                (Math.abs(posX-centerX)+Math.abs(posY-centerY) < bombRange);

    }

    static void bomb(int bombRange,int posX,int posY){

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                copy[i][j]=0;
            }
        }
        centerX=posX;
        centerY=posY;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(explosive(i,j,bombRange)){
                    map[i][j]=0;
                }
            }
        }

        for(int j=0; j<N; j++){
            int endOfRange=N-1;
            for(int i=N-1; i>=0; i--){
                if(map[i][j]!=0){
                    copy[endOfRange][j]=map[i][j];
                    endOfRange--;
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j]=copy[i][j];
            }
        }
        // for(int i=0; i<N; i++){
        //     for(int j=0; j<N; j++){
        //         System.out.print(map[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println("=============");
    }

    static void check(int pos){
        for(int i=0; i<N; i++){
            if(map[i][pos]!=0){
                bomb(map[i][pos],i,pos);
                break;
            }
        }
    }
    public static void main(String[] args) throws IOException{

        // 여기에 코드를 작성해주세요.

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<M; i++){
            //System.out.println("왜이게 실행"+i);
            dot = Integer.parseInt(br.readLine())-1;
            check(dot);
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }


}