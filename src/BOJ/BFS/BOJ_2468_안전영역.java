package BOJ.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역 {
    static int N;
    static int[][] map;
    static boolean[][] safeZone;
    static boolean[][] flooding;
    static int nMin;
    static int nMax;
    static int ans;
    static int[] dx= {0,1,0,-1};
    static int[] dy= {1,0,-1,0};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nMin=Integer.MAX_VALUE;
        nMax=Integer.MIN_VALUE;
        map = new int [N][N];
        ans=0;
        //최대값 구하기 초기화
        for (int i = 0; i < N; i++) {
            StringTokenizer st =new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
                nMin=Math.min(nMin, map[i][j]);
                nMax=Math.max(nMax, map[i][j]);
            }
        }
        //1.일단 침수시키기 flooding은 visited처리를 모두 해주자 [침수시키는 조건은 제일 낮은곳부터 침수시키기]
        //2.안전영역 확인 [침수시킨곳은 세지않는다] 그렇다면 flooding이 visited되어야하고, safeZone도 visited된곳은 방문하면안된다.
        //2-1. 안전영역 확인하면서 일단 안전영역이
        //3.nMin가 nMax+1 면 끝내기
        //예외문제 모두가 똑같은 깊이라면 ?
        //애초에 nMin==nManx라면 똑같은 깊이라는뜻이다 이럴때 예외처리를 해주자
        if(nMin==nMax) {
            System.out.println(ans+1);
        }

        //nMin!=nMax일때, 비교할 구문이있을때
        else {
            while(true) {
                safeZone=new boolean[N][N]; //다시 침수와 안전영역 초기화 시켜주어야한다.
                flooding = new boolean[N][N];

                //다 침수시켰으면 돌아가자
                if(nMin==nMax+1) {
                    break;
                }
                int cnt=0;
                //1.일단 침수시키기 flooding은 visited처리를 모두 해주자 [침수시키는 조건은 제일 낮은곳부터 침수시키기]
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if(map[i][j]<=nMin && !flooding[i][j]) {
                            BFS(i,j);

                        }
                    }
                }
                //2.안전영역 확인 [침수시킨곳은 세지않는다] 그렇다면 flooding이 visited되어야하고, safeZone도 visited된곳은 방문하면안된다.
                //2-1. 안전영역 확인하면서 일단 안전영역이
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if(map[i][j]>nMin && !safeZone[i][j]) {
                            safe(i,j);
                            cnt++;
                        }
                    }
                }
                ans=Math.max(ans,cnt);
                nMin++;
            }//end for while
            System.out.println(ans);

        }//end for main

    }//end for class
    private static void print(boolean[][] tmp) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tmp[i][j]+" ");
            }
            System.out.println();
        }

    }
    private static void safe(int si, int sj) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point (si,sj));
        safeZone[si][sj]=true;
        while(!queue.isEmpty()) {
            Point now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nexti= now.x+dx[d];
                int nextj= now.y+dy[d];
                if(nexti>=0 && nexti<N && nextj>=0 && nextj<N && map[nexti][nextj]>nMin &&!safeZone[nexti][nextj]) {
                    queue.add(new Point(nexti,nextj));
                    safeZone[nexti][nextj]=true;
                }
            }
        }

    }
    private static void BFS(int si, int sj) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point (si,sj));
        flooding[si][sj]=true;
        while(!queue.isEmpty()) {
            Point now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nexti= now.x+dx[d];
                int nextj= now.y+dy[d];
                if(nexti>=0 && nexti<N && nextj>=0 && nextj<N && map[nexti][nextj]<=nMin &&!flooding[nexti][nextj]) {
                    queue.add(new Point(nexti,nextj));
                    flooding[nexti][nextj]=true;
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
}