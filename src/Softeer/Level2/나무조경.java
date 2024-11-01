package Softeer.Level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무조경 {

    private static BufferedReader br;


    private static int N, ans;
    private static int[][] map;
    private static boolean[][] isVisited;
    private static final int[] dirX = {0, 1};
    private static final int[] dirY = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        input();

        int maxDepth = 4;
        if (N == 2) {
            maxDepth = 2;
        }

        DFS(0, 0, maxDepth);
        System.out.println(ans);
    }

    private static void DFS(int depth, int sum, int maxDepth) {
        if (depth == maxDepth) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isVisited[i][j]) continue;

                for (int k = 0; k < 2; k++) {
                    int nextX = dirX[k] + i;
                    int nextY = dirY[k] + j;

                    if (!isPossible(nextX, nextY)) continue;

                    isVisited[i][j] = true;
                    isVisited[nextX][nextY] = true;
                    DFS(depth + 1, sum + map[i][j] + map[nextX][nextY], maxDepth);
                    isVisited[i][j] = false;
                    isVisited[nextX][nextY] = false;
                }
            }
        }
    }

    private static boolean isPossible(int nextX, int nextY) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !isVisited[nextX][nextY];
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        ans = -1;

        map = new int[N][N];
        isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
