package BOJ.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2206_벽부수고이동하기 {
    static int N;
    static int M;

    static int[][] map;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static ArrayList<Position> pos;
    static int countA;
    static int countB;
    static int result;

    static class Position {
        int x;
        int y;
        boolean checked;

        Position(int x, int y,boolean checked) {
            this.x = x;
            this.y = y;
            this.checked = checked;
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(tmp[j]));
            }
        }

        result = Integer.MAX_VALUE;
        BFSA(0, 0);
        int ansA=result;

        result = Integer.MAX_VALUE;
        BFSB(N-1,M-1);
        int ansB=result;
        System.out.println(ansA+" "+ansB);
        if(ansA==Integer.MAX_VALUE && ansB==Integer.MAX_VALUE){
            System.out.println(-1);
        }else if( ansA < ansB){
            System.out.println(ansA);
        }else if(ansB < ansA){
            System.out.println(ansB);
        }else{
            System.out.println(ansA);
        }

    }

    private static void BFSA(int i, int j) {
        boolean[][] visited = new boolean[N][M];
        ArrayDeque<Position> queue = new ArrayDeque<>();
        queue.add(new Position(i, j,false));
        visited[i][j] = true;
        countA=0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            countA++;
            for (int s = 0; s < size; s++) {

                Position p = queue.poll();
               // System.out.println(p.x+" "+p.y+" "+p.checked);
                if (p.x == N - 1 && p.y == M - 1) {
                    result = Math.min(countA, result);
                }
                for (int d = 0; d < 4; d++) {
                    int nexti = p.x + dx[d];
                    int nextj = p.y + dy[d];

                    if (inRange(nexti, nextj) && !visited[nexti][nextj]) {
                        if(map[nexti][nextj]==0){
                            queue.add(new Position(nexti,nextj,p.checked));
                            visited[nexti][nextj] = true;
                        }
                        else if(map[nexti][nextj]==1 && !p.checked){
                            queue.add(new Position(nexti, nextj,true));
                            visited[nexti][nextj] = true;
                        }
                    }
                }

            }
        }

    }

    private static void BFSB(int i, int j) {
        boolean[][] visited = new boolean[N][M];
        ArrayDeque<Position> queue = new ArrayDeque<>();
        queue.add(new Position(i, j,false));
        visited[i][j] = true;

        countB=0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            countB++;
            for (int s = 0; s < size; s++) {

                Position p = queue.poll();

                if (p.x == 0 && p.y == 0) {
                    result = Math.min(countB, result);
                }
                for (int d = 0; d < 4; d++) {
                    int nexti = p.x + dx[d];
                    int nextj = p.y + dy[d];

                    if (inRange(nexti, nextj) && !visited[nexti][nextj]) {
                        if(map[nexti][nextj]==1 && !p.checked){
                            queue.add(new Position(nexti, nextj,true));
                            visited[nexti][nextj] = true;
                        }else if(map[nexti][nextj]==0){
                            queue.add(new Position(nexti,nextj,p.checked));
                            visited[nexti][nextj] = true;
                        }
                    }
                }

            }
        }

    }

    private static boolean inRange(int x, int y) {

        if (x >= 0 && x < N && y >= 0 && y < M ) {
            return true;
        }
        return false;
    }
}
