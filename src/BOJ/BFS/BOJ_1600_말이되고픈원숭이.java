package BOJ.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1600_말이되고픈원숭이 {
    static int K, W, H;
    static int[][] map;
    static boolean[][][] visit; //어떤 i,j에 스킬을 몇번쓰고 왔는지

    static int[] di = {0,0,1,-1};
    static int[] dj = {1,-1,0,0};

    static int[] sdi = {-2,-1,1,2,2,1,-1,-2};
    static int[] sdj = {1,2,2,1,-1,-2,-2,-1};
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        K=sc.nextInt();
        W=sc.nextInt();
        H=sc.nextInt();

        map = new int[H][W];

        visit = new boolean [H][W][K+1] ; //스킬안쓰는 0인덱스부터 스킬 최대사용 K인덱스까지 t/f 기록

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                map[i][j]=sc.nextInt();
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Point> queue =new LinkedList<>();
        queue.add(new Point(0,0,0));
        visit[0][0][0] = true;

        int time = 0 ;
        while(!queue.isEmpty()) {
            int size= queue.size();

            for (int s = 0; s < size; s++) {
                Point now = queue.poll();
                if(now.i==H-1 && now.j==W-1) { //혹시 너 도착했니?
                    return time;
                }
                for (int d = 0; d < 4; d++) {
                    int nexti= now.i+di[d];
                    int nextj= now.j+dj[d];

                    if(nexti>=0 && nexti<H && nextj>=0 && nextj<W && map[nexti][nextj]==0 && !visit[nexti][nextj][now.skill]) {
                        queue.add(new Point(nexti,nextj,now.skill)); //now에서 걸어가는 원숭이들이라 now랑 스킬사용횟수 같은 애들
                        visit[nexti][nextj][now.skill]=true;
                    }
                }

                if(now.skill<K) { //자 스킬사용횟수 남아있는지 확인해보고
                    for (int d = 0; d < 8; d++) {
                        int nexti= now.i+sdi[d];
                        int nextj= now.j+sdj[d];

                        if(nexti>=0 && nexti<H && nextj>=0 && nextj<W && map[nexti][nextj]==0 && !visit[nexti][nextj][now.skill+1]) {
                            queue.add(new Point(nexti,nextj,now.skill+1)); //now에서 걸어가는 원숭이들이라 now랑 스킬사용횟수 같은 애들
                            visit[nexti][nextj][now.skill+1]=true;
                        }
                    }

                }
            }
            time++;
        }
        return -1;

    }

    static class Point{
        int i,j,skill;

        public Point(int i, int j, int skill) {
            this.i = i;
            this.j = j;
            this.skill = skill;
        }

        @Override
        public String toString() {
            return "Point [i=" + i + ", j=" + j + ", skill=" + skill + "]";
        }
    }

}
