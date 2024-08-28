package CodeTree.DFS;

import java.io.*;
import java.util.*;
public class 마을구분하기 {
    static int N;
    static int[][] map;
    static boolean[][] checked;
    static int[] dx= {0,1,0,-1};
    static int[] dy= {-1,0,1,0};
    static int result;
    static int people;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map =new int[N][N];
        checked= new boolean[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count=0;
        ArrayList<Integer> arr =new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                people=0;
                if(map[i][j]==1 && !checked[i][j]){
                    DFS(i,j);
                    count++;
                    arr.add(people);
                }
            }
        }
        Collections.sort(arr);
        System.out.println(count);

        for(int i=0; i<arr.size(); i++){
            System.out.println(arr.get(i));
        }

        // 여기에 코드를 작성해주세요.
    }

    static void DFS(int i,int j){
        checked[i][j]=true;
        people++;
        for(int d=0; d<4; d++){
            int nexti = i+dx[d];
            int nextj = j+dy[d];
            if(inRange(nexti,nextj) && map[nexti][nextj]==1 && !checked[nexti][nextj]){
                DFS(nexti,nextj);
            }
        }
    }

    static boolean inRange(int x,int y){
        return x>=0 && x<N && y>=0 && y<N;
    }
}