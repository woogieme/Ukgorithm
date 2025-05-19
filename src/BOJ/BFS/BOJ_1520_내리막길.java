package BOJ.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1520_내리막길 {


    static int N;
    static int M;

    static int[][] map;
    static int[][] dp;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int result;

    static class Point {

        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dp[i][j] = -1;
            }
        }

        result = DFS(0, 0);
        System.out.println(result);
        //print();
    }

    private static void print() {
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <M ; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int DFS(int i, int j) {

        if (i == N - 1 && j == M - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j]=0;
        for (int d = 0; d < 4; d++) {
            int nexti = i + dx[d];
            int nextj = j + dy[d];

            if (!inRange(nexti, nextj)) continue;

            if (map[nexti][nextj] < map[i][j]) {
                dp[i][j] += DFS(nexti, nextj);
            }
        }
        return dp[i][j];
    }

    private static boolean inRange(int a, int b) {
        return a >= 0 && a < N && b >= 0 && b < M;
    }

}
