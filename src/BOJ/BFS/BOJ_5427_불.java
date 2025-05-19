package BOJ.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427_불 {

    static int[] dx ={0,1,0,-1};
    static int[] dy ={1,0,-1,0};

    static char[][] map;

    static int N;
    static int C;

    static int result;

    static int T;

    static Queue<Point> fire;

    static boolean[][] fireArray;
    static class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            C = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            int startI = -1;
            int startJ = -1;
            result = Integer.MAX_VALUE;

            map = new char[N][C];
            fireArray = new boolean[N][C];
            fire = new ArrayDeque<>();


            for (int i = 0; i < N; i++) {
                char[] tmp = br.readLine().toCharArray();
                for (int j = 0; j < C; j++) {
                    map[i][j] = tmp[j];
                    if (map[i][j]=='@'){
                        startI=i;
                        startJ=j;
                    }else if(map[i][j]=='*'){
                        fire.add(new Point(i,j));
                    }
                }
            }
            BFS(startI,startJ);

            System.out.println(result==Integer.MAX_VALUE? "IMPOSSIBLE" : result);


        }

    }

    //불을 먼저 내야하는가?
    private static void BFS(int startI, int startJ) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] checked = new boolean[N][C];

        queue.add(new Point(startI,startJ));
        checked[startI][startJ]=true;
        int count=0;
        while(!queue.isEmpty()){

            int size =queue.size();
            fire();
            count++;
            for (int s = 0; s < size; s++) {
                Point p =  queue.poll();
                if(p.x==0 || p.y==0 || p.x==N-1 || p.y==C-1){
                    result = Math.min(count,result);
                }
                for (int d = 0; d < 4; d++) {
                    int nexti = p.x+dx[d];
                    int nextj = p.y+dy[d];

                    if(!inRange(nexti,nextj)) continue;

                    if(map[nexti][nextj]=='.' && !checked[nexti][nextj]){
                        checked[nexti][nextj]=true;
                        queue.add(new Point(nexti,nextj));
                    }

                }
            }
        }


    }

    private static void fire() {

        if(!fire.isEmpty()){
            int size = fire.size();
            for (int s = 0; s < size; s++) {
                Point f = fire.poll();

                for (int d = 0; d < 4; d++) {
                    int nexti = f.x+dx[d];
                    int nextj = f.y+dy[d];

                    if(!inRange(nexti,nextj)) continue;

                    if(map[nexti][nextj]!='#'){
                        map[nexti][nextj]='*';
                        fire.add(new Point(nexti,nextj));
                    }
                }
            }
        }

    }

    private static boolean inRange(int x,int y) {
        return x>=0 && x<N && y>=0 && y<C;
    }


}
