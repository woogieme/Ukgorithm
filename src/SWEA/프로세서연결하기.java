package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 프로세서연결하기 {
    static int N;
    static int M;
    static int[] arr;
    static int[][] map;
    static int[][] saveMap;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int ans;
    public static void main(String[] args) throws IOException {
        N=0;
        ans=Integer.MAX_VALUE;
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        map = new int [M][M];
        saveMap = new int [M][M];
        StringTokenizer st =null;
        for (int i = 0; i < M; i++) {
            st =new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j]= Integer.parseInt(st.nextToken());
                if(map[i][j]==1) {
                    N++;
                }
            }
        }
        arr=new int[N];
        dupPerm(0);
        System.out.println(ans);
    }
    private static void dupPerm(int idx) {
        if(idx==N) {
            int k=0;
            //System.out.println(Arrays.toString(arr));
            copyMap(map);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(saveMap[i][j]==1 ) {
                        if(j==0 || i==0  || i==N-1 || j==N-1) {
                            k++;
                            continue;
                        }
                        go(i,j,arr[k]%4);
                        k++;

                    }
                }
            }
            for (int i = 0; i < saveMap.length; i++) {
                for (int j = 0; j < saveMap[i].length; j++) {
                    if(saveMap[i][j]==3) {
                        BFS(i,j);
                    }
                }
            }
            print();
            int cnt=0;
            for (int i = 0; i < saveMap.length; i++) {
                for (int j = 0; j < saveMap[i].length; j++) {
                    if(saveMap[i][j]==2) {
                        cnt++;
                    }
                }
            }
            ans = Math.min(ans, cnt);
            System.out.println("답은 이것입니다~~~~~~~~~~~~~~"+ ans);
            return;
        }

        for (int i = 0; i < N; i++) {

            arr[idx]=i;
            dupPerm(idx+1);

        }


    }
    private static void print() {
        System.out.println(" 시작  ");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(saveMap[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("===========================");
    }
    private static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[M][M];
        queue.add(new Point(x,y));
        visited[x][y]=true;
        while(!queue.isEmpty()) {
            Point now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nexti = now.x+dx[d];
                int nextj = now.y+dy[d];
                if(nexti >=0 && nexti<M && nextj>=0 && nextj<M && !visited[nexti][nextj] && saveMap[nexti][nextj]==2) {
                    saveMap[nexti][nextj]=3;
                    visited[nexti][nextj]=false;
                    queue.add(new Point(nexti,nextj));
                }

            }

        }

    }
    static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

    }
    private static void go(int i, int j, int idx) {
        int nexti = i+dx[idx];
        int nextj = j+dy[idx];
        if(nexti<0 || nexti ==M || nextj<0 || nextj ==M) {
            return;
        }
        if(saveMap[nexti][nextj]==2) {
            saveMap[nexti][nextj]=3;
            go(nexti,nextj,idx);
        }
        else {
            saveMap[nexti][nextj]=2;
            go(nexti,nextj,idx);
        }



    }
    private static void copyMap(int[][] tmp) {
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {
                saveMap[i][j]=tmp[i][j];
            }
        }
    }
}