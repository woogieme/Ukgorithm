package CodeTree.SamSung.DFS;

import java.util.*;
import java.io.*;
public class 두방향탈출가능여부판별하기 {
    static int N;
    static int M;
    static int[] dx={1,0};
    static int[] dy={0,1};
    static int[][] map;
    static boolean[][] visited;
    static boolean isFlag;

    static boolean inRange(int i, int j){
        return (i>=0 && i<N && j>=0 && j<M && map[i][j]==1);
    }
    static void DFS(int ix, int ij){
        if(ix==N-1 && ij==M-1){
            isFlag=true;
            return;
        }


        for(int d=0; d<2; d++){
            int nexti = ix+dx[d];
            int nextj = ij+dy[d];
            if(inRange(nexti,nextj) && !visited[nexti][nextj]){
                visited[ix][ij]=true;
                DFS(nexti,nextj);
            }
        }
    }
    public static void main(String[] args) throws IOException{

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map =new int[N][M];
        visited =new boolean[N][M];
        isFlag=false;
        for(int i=0; i<N;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0,0);
        if(isFlag){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
        // 여기에 코드를 작성해주세요.
    }
}