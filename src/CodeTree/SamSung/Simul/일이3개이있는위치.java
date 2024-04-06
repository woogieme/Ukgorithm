package CodeTree.SamSung.Simul;

import java.io.*;
import java.util.*;

public class 일이3개이있는위치 {
    static int N;
    static int[][] map;
    static int[] dx ={1,0,-1,0};
    static int[] dy={0,1,0,-1};
    static int count=0;
    static boolean inRange(int i,int j){
        return (i>=0 && i<N && j>=0 &&j<N);
    }
    public static void main(String[] args) throws IOException{

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int tmp=0;
                for(int d=0; d<4; d++){
                    int nexti = i +dx[d];
                    int nextj = j +dy[d];
                    if(inRange(nexti,nextj) && map[nexti][nextj]==1){
                        tmp++;
                    }
                }
                if(tmp>=3){
                    count++;
                }
            }
        }
        System.out.println(count);
        // 여기에 코드를 작성해주세요.
    }
}