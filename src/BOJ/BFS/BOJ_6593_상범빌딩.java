package BOJ.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6593_상범빌딩 {
    static int N;
    static int M;
    static int K;

    static int result;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dy = {1, 0, -1, 0, 0, 0};

    static char[][][] map;

    static int count;

    static int endIdx;
    static int endJDx;
    static int endfDx;

    static public class Building {

        int x;
        int y;
        int z;

        Building(int z, int x, int y) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {

            result = Integer.MAX_VALUE;

            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            K = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new char[K][N][M];
            if (K == 0 && N == 0 && M == 0) {
                break;
            }

            int startIdx = 0;
            int startJdx = 0;
            int startfDx = 0;

            for (int s = 0; s < K; s++) {
                for (int i = 0; i < N; i++) {
                    String a = br.readLine();
                    for (int j = 0; j < M; j++) {
                        map[s][i][j] = a.charAt(j);
                        if (map[s][i][j] == 'S') {
                            startIdx = i;
                            startJdx = j;
                            startfDx = s;
                        } else if (map[s][i][j] == 'E') {
                            endIdx = i;
                            endJDx = j;
                            endfDx = s;
                        }
                    }
                }
                br.readLine();
            }

            BFS(startfDx, startIdx, startJdx);

            if (result == Integer.MAX_VALUE) {
                System.out.println("Trapped!");
            } else {

                System.out.println("Escaped in " + --result + " minute(s).");
            }


        }
    }

    private static void BFS(int f, int i, int j) {
        Queue<Building> queue = new ArrayDeque<>();

        boolean[][][] checked = new boolean[K][N][M];

        checked[f][i][j] = true;

        queue.add(new Building(f, i, j));

        while (!queue.isEmpty()) {

            int size = queue.size();
            count++;
            for (int s = 0; s < size; s++) {

                Building q = queue.poll();

                if (q.x == endIdx && q.z == endfDx && q.y == endJDx) {
                    result = Math.min(result, count);
                }
                for (int d = 0; d < 6; d++) {

                    int z = q.z + dz[d];
                    int x = q.x + dx[d];
                    int y = q.y + dy[d];


                    if (!inRange(z, x, y)) continue;

                    if (!checked[z][x][y] && map[z][x][y] != '#') {
                        checked[z][x][y] = true;
                        queue.add(new Building(z, x, y));
                    }
                }
            }


        }

    }

    private static boolean inRange(int z, int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M && z >= 0 && z < K;
    }

    private static void print() {

        for (int s = 0; s < K; s++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(map[s][i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}

