package BOJ.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14442_벽부수고이동하기2 {
    static int N;
    static int M;

    static int K;

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
        int checked;

        Position(int x, int y, int checked) {
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
        K = Integer.parseInt(st.nextToken());


        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(tmp[j]));
            }
        }

        result = Integer.MAX_VALUE;
        BFSA(0, 0);
        System.out.println( result==Integer.MAX_VALUE ? -1 : result);
    }

    private static void BFSA(int i, int j) {
        boolean[][][] visited = new boolean[N][M][K+1];
        ArrayDeque<Position> queue = new ArrayDeque<>();
        queue.add(new Position(i, j, K));
        visited[i][j][K] = true;
        countA = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            countA++;
            for (int s = 0; s < size; s++) {

                Position p = queue.poll();
                if (p.x == N - 1 && p.y == M - 1) {
                    result = Math.min(countA, result);
                }
                for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];

                    if (!inRange(nx, ny)) continue;

                    if (map[nx][ny] == 0) { //다음이 벽이 없을때
                            //벽을 부술수있는가? 벽을 부술수있는
                        if (!visited[nx][ny][p.checked]) {
                            visited[nx][ny][p.checked] = true;
                            queue.add(new Position(nx, ny, p.checked ));

                        }

                    } else if (map[nx][ny] == 1) { // 벽일 때
                        if (p.checked>0 && !visited[nx][ny][p.checked - 1]) {
                            visited[nx][ny][p.checked-1]=true;
                            queue.add(new Position(nx,ny,p.checked-1));
                        }
                    }
                }

            }
        }

    }

    private static boolean inRange(int x, int y) {

        if (x >= 0 && x < N && y >= 0 && y < M) {
            return true;
        }
        return false;
    }
}
