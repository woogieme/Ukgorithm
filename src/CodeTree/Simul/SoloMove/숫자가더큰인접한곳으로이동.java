package CodeTree.Simul.SoloMove;

import java.util.*;
import java.io.*;

public class 숫자가더큰인접한곳으로이동 {
    static int N;
    static int r;
    static int c;
    static int[] dx ={-1,1,0,0};
    static int[] dy ={0,0,-1,1};
    static int[][] map;
    static int d=4;
    static int result=0;
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N =Integer.parseInt(st.nextToken());
        r =Integer.parseInt(st.nextToken())-1;
        c =Integer.parseInt(st.nextToken())-1;

        map=new int[N][N];

        for(int i=0; i<N; i++){
            st =new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int posx = r;
        int posy = c;

        result = map[r][c];

        System.out.print(result+" ");
        while(true){
            boolean isFlag=false;
            for(int i=0; i<d; i++){
                int nexti = posx+dx[i];
                int nextj = posy+dy[i];

                if(nexti>=0 && nexti<N &&nextj>=0 && nextj<N && result < map[nexti][nextj]){
                    result = map[nexti][nextj];
                    posx=nexti;
                    posy=nextj;
                    isFlag=true;
                    break;
                }
            }
            if(!isFlag){
                break;
            }
            System.out.print(result+" ");

        }

    }
}