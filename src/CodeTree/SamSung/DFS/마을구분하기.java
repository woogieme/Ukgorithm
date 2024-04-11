package CodeTree.SamSung.DFS;

import java.util.*;
import java.io.*;
public class 마을구분하기 {
    static int N;
    static int[][] map;
    static int[] dx ={0,1,0,-1};
    static int[] dy ={1,0,-1,0};
    static boolean[][] visited;
    static int count;
    public static ArrayList<Integer> num = new ArrayList<>();
    static boolean inRange(int i,int j){
        return i>=0 && i<N && j>=0 && j<N && map[i][j]==1;
    }
    static void DFS(int x,int y){
        visited[x][y]=true;
        count++;
        for(int d=0; d<4; d++){
            int nexti = x+ dx[d];
            int nextj = y+ dy[d];
            if(inRange(nexti,nextj)&& !visited[nexti][nextj]){
                DFS(nexti,nextj);
            }
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map=new int[N][N];
        visited =new  boolean[N][N];


        for(int i=0; i<N; i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        int result=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                count=0;
                if(map[i][j]==1 &&!visited[i][j]){
                    DFS(i,j);
                    num.add(count);
                    result++;
                }
            }
        }
        Collections.sort(num);
        System.out.println(result);
        for(int i=0; i<num.size(); i++){
            System.out.println(num.get(i));
        }



        // 여기에 코드를 작성해주세요.
    }
}