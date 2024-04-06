package CodeTree.SamSung.Simul;

import java.util.*;
import java.io.*;

public class 작은구슬의이동 {
    static int N;
    static int T;
    static int centerX;
    static int centerY;
    static int Dir;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,-1,0,1};

    static int move(String dirTmp){
        if(dirTmp.equals("D")){
            return 0;
        }else if(dirTmp.equals("L")){
            return 1;
        }else if(dirTmp.equals("U")){
            return 2;
        }
        return 3;
    }

    static boolean inRange(int tmp){
        int nexti = centerX+dx[tmp];
        int nextj = centerY+dy[tmp];
        return nexti<0 || nexti>=N || nextj<0 ||nextj>=N;

    }
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        centerX = Integer.parseInt(st.nextToken())-1;
        centerY = Integer.parseInt(st.nextToken())-1;
        Dir = move(st.nextToken());

        for(int i=0; i<T; i++){
            if(inRange(Dir)){
                Dir = (Dir+2)%4;
                continue;
            }
            centerX+=dx[Dir];
            centerY+=dy[Dir];
        }
        System.out.println((centerX+1)+" "+(centerY+1));
    }
}