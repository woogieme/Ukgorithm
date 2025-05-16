package BOJ.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_토마토 {
    static int N;
    static int M;
    static int K;

    static int result;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dy = {1, 0, -1, 0, 0, 0};

    static int[][][] map;

    static int count;

    static Queue<Tomato> queue;

    static public class Tomato {

        int x;
        int y;
        int z;

        Tomato(int z, int x, int y) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


            result = Integer.MAX_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[K][N][M];
            queue = new ArrayDeque<>();
            for (int s = 0; s < K; s++) {
                for (int i = 0; i < N; i++) {
                    st =new StringTokenizer(br.readLine());
                    for (int j = 0; j < M; j++) {
                        map[s][i][j] =Integer.parseInt(st.nextToken());
                        if(map[s][i][j]==1){
                            queue.add(new Tomato(s,i,j));
                        }
                    }
                }
            }

        BFS();
        System.out.println(result==Integer.MAX_VALUE? -1:result);
        //print();
    }

    private static void BFS() {

        boolean[][][] checked = new boolean[K][N][M];


        while (!queue.isEmpty()) {
            int size = queue.size();
            if(checkDay()){
                result=count;
                break;
            }
            count++;
            for (int s = 0; s < size; s++) {

                Tomato t = queue.poll();
                checked[t.z][t.x][t.y]=true;

                for (int d = 0; d < 6; d++) {

                    int z = t.z + dz[d];
                    int x = t.x + dx[d];
                    int y = t.y + dy[d];


                    if (!inRange(z, x, y)) continue;

                    if (!checked[z][x][y] && map[z][x][y] == 0) {
                        queue.add(new Tomato(z, x, y));
                        map[z][x][y]=1;
                        checked[z][x][y]=true;
                    }
                }
            }


        }

    }

    private static boolean checkDay() {
        for (int s = 0; s < K; s++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[s][i][j]==0){
                        return false;
                    }
                }
            }
        }
        return true;
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

