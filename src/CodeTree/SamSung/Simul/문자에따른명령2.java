package CodeTree.SamSung.Simul;

import java.util.*;
import java.io.*;

public class 문자에따른명령2 {
    static String N;
    static int totalCnt;
    static int centerX=0;
    static int centerY=0;

    //위, 오른쪽,아래,왼쪽

    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = br.readLine();

        totalCnt = N.length();
        int dir=0;
        for(char c : N.toCharArray()){
            if(c=='L'){
                dir = (dir-1+4)%4;
            }else if(c=='R'){
                dir = (dir+1)%4;
            }else if(c=='F'){
                centerX+=dx[dir];
                centerY+=dy[dir];
            }
        }
        System.out.println(centerY+" "+centerX);
    }
}