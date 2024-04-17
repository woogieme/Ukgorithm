package BOJ.BFS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17141_연구소2 {
    static boolean[] selected;
    static int[][] map;
    static int[][] copy;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int i;
    static int j;
    static int ans;
    static int N;
    static int M;
    static boolean isFlag;
    static int var;
    static int num;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        copy = new int[N][N];
        var=0;
        num=0;
        selected = new boolean [N*N];
        for (int i = 0; i < N; i++) {
            st =new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2) {
                    num++;
                }
            }
        }
        isFlag=true;
        ans=Integer.MAX_VALUE;
        comb(0,0);
        if(combination(num,M)==var) {
            System.out.println(-1);
        }
        else {
            System.out.println(num);
        }
    }
    public static int combination(int num, int r) {
        if(num == r || r == 0)
            return 1;
        else
            return combination(num- 1, r - 1) + combination(num - 1, r);
    }
    private static void comb(int idx, int cnt) {
        if (cnt==M) {
            int count=0;
            copyMap(map);
            ArrayList<Point> tmp = new ArrayList<>();
            for (int i = 0; i < N*N; i++) {
                if(selected[i]) {
                    copy[i/N][i%N]=-1;
                    tmp.add(new Point(i/N,i%N));
                }
            }
            for (int i = 0; i < copy.length; i++) {
                for (int j = 0; j < copy[i].length; j++) {
                    if(copy[i][j]==2) {
                        copy[i][j]=0;
                    }
                }
            }
            BFS(tmp);
            System.out.println("_______________________");
            showAll();
            System.out.println();
            return;
        }
        if(idx==selected.length) {
            return;
        }
        i = idx/N;
        j = idx%N;
        if(map[i][j]==2) {
            selected[idx]=true;
            comb(idx+1,cnt+1);
            selected[idx]=false;
            comb(idx+1,cnt);
        }else if(map[i][j]==1 || map[i][j]==0) {
            comb(idx+1,cnt);
        }

    }



    private static void BFS(ArrayList<Point> arr) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < arr.size(); i++) {
            queue.add(new Point(arr.get(i).x,arr.get(i).y));
            visited[arr.get(i).x][arr.get(i).y]=true;
        }
        int result=1;
        while(!queue.isEmpty()) {
            int size =queue.size();
            for (int i = 0; i < size; i++) {
                Point now = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nexti = now.x+dx[d];
                    int nextj = now.y+dy[d];
                    if(nexti>=0 &&nexti < N &&nextj>=0 && nextj<N && copy[nexti][nextj]==0 && !visited[nexti][nextj]) {
                        copy[nexti][nextj]=result;
                        queue.add(new Point(nexti,nextj));
                        visited[nexti][nextj]=true;
                    }
                }
            }
            result++;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(copy[i][j]==0) {
                    var++;
                    isFlag=false;
                    break;
                }
                ans = Math.min(ans, copy[i][j]);
            }
            if(!isFlag) {
                break;
            }
        }
        isFlag=true;
        System.out.println(ans);
    }



    static class Point{
        int x;
        int y;
        public Point(int x, int y) {

            this.x = x;
            this.y = y;
        }

    }

    private static void copyMap(int[][] tmp) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copy[i][j]=tmp[i][j];
            }

        }
    }

    private static void showAll() {
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                System.out.print(copy[i][j]+" ");
            }
            System.out.println();
        }

    }
}
