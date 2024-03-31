package BOJ.DFS;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 섬의개수_BOJ_4963 {
    static int[] di= {-1,-1,0,1,1,1,0,-1};
    static int[] dj= {0,1,1,1,0,-1,-1,-1};
    static int ans;
    static int H;
    static int W;
    static int[][] map;
    static boolean[][] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            W = sc.nextInt();
            H = sc.nextInt();
            ans=0;
            if(W==0 && H==0) break; //입력애ㅣ 무제한 들어오아 0 0 들어오면 끝

            map = new int[H][W];

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    map[i][j]=sc.nextInt();
                }
            }//end input


            visit = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if(map[i][j]==1 && ! visit[i][j]) {
                        dfs(i,j,visit);
                        ans++;
                    }
                }
            }
            System.out.println(ans);

        }
    }
    private static void dfs(int si,int sj, boolean[][] visited) {
        visited[si][sj]=true;
        Point now=new Point(si,sj);
        for (int d = 0; d < 8; d++) {
            int nexti  = now.i+di[d];
            int nextj  = now.j+dj[d];
            if(nexti>=0 & nexti<H && nextj>=0 && nextj<W && map[nexti][nextj]==1 && !visit[nexti][nextj]) {
                dfs(nexti,nextj,visited);

            }
        }


    }
    static class Point{
        int i,j;

        public Point(int i, int j) {
            super();
            this.i = i;
            this.j = j;
        }
    }
}
