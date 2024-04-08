package CodeTree.SamSung.Simul.dxdyTech;

import java.util.*;
import java.io.*;

public class 방향에맞춰이동 {

    static int N;
    static int centerX;
    static int centerY;
    //N E S W
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static void move(String dir,int dist){

        if(dir.equals("N")){
            for(int i=0; i<dist; i++){
                centerX += dx[0];
                centerY +=dy[0];
            }

        }else if(dir.equals("E")){
            for(int i=0; i<dist; i++){
                centerX += dx[1];
                centerY +=dy[1];
            }
        }else if(dir.equals("S")){
            for(int i=0; i<dist; i++){
                centerX += dx[2];
                centerY +=dy[2];
            }
        }else if(dir.equals("W")){
            for(int i=0; i<dist; i++){
                centerX += dx[3];
                centerY +=dy[3];
            }
        }

    }


    public static void main(String[] args) throws IOException{

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        centerX=0;
        centerY=0;
        for(int i=0; i<N; i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            String dir = st.nextToken();
            int dist = Integer.parseInt(st.nextToken());
            move(dir,dist);
        }
        System.out.println(centerY+" "+centerX);

        // 여기에 코드를 작성해주세요.
    }
}