package BOJ.dxdyTech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 미세먼지안녕 {
    static int N;
    static int M;
    static int S;
    static int[][] map;
    static int[][] saveMap;
    static List<Point> arr;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        S=Integer.parseInt(st.nextToken());

        map=new int[N][M];

        arr=new LinkedList<>();
        ans =0;
        for (int i = 0; i < N; i++) {
            st =new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==-1) {
                    arr.add(new Point(i,j));
                }

            }
        }

        for (int tc = 0; tc < S; tc++) {
            saveMap=new  int[N][M];
            int[] dxA = new int[] {-1,0,1,0};
            int[] dyA = new int[] {0,1,0,-1};
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int sum=0;
                    if(map[i][j]>=5) {
                        int value= map[i][j]/5;
                        for (int d = 0; d < 4; d++) {
                            int nexti = i+dxA[d];
                            int nextj = j+dyA[d];
                            if(nexti>=0 && nexti<N && nextj>=0 && nextj<M && map[nexti][nextj]!=-1) {
                                sum+=value;
                                saveMap[nexti][nextj]+=value;
                            }
                        }
                        map[i][j]-=sum;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j]+=saveMap[i][j];
                }
            }
            int tmp=arr.get(0).x;
            int dir=0;
            int i = arr.get(0).x;
            int j = arr.get(0).y;

            int[] dx = new int[] {-1,0,1,0};
            int[] dy = new int[] {0,1,0,-1};

            while(true) {
                int nexti = i+dx[dir];
                int nextj = j+dy[dir];
                if(nexti<0 || nexti>tmp || nextj<0 || nextj>=M) {
                    dir++;
                    dir%=4;
                    continue;
                }
                if(map[i][j]==-1) {
                    i=nexti;
                    j=nextj;
                    continue;
                }
                if(map[nexti][nextj]==-1) {
                    map[i][j]=0;
                    break;
                }
                map[i][j]=map[nexti][nextj];
                i=nexti;
                j=nextj;
            }

            tmp=arr.get(1).x;
            dir=0;
            i = arr.get(1).x;
            j = arr.get(1).y;
            dx = new int[] {1,0,-1,0};
            dy = new int[] {0,1,0,-1};
            while(true) {
                int nexti = i+dx[dir];
                int nextj = j+dy[dir];
                if(nexti<tmp || nexti>=N || nextj<0 || nextj>=M) {
                    dir++;
                    dir%=4;
                    continue;
                }
                if(map[i][j]==-1) {
                    i=nexti;
                    j=nextj;
                    continue;
                }
                if(map[nexti][nextj]==-1) {
                    map[i][j]=0;
                    break;
                }
                map[i][j]=map[nexti][nextj];
                i=nexti;
                j=nextj;
            }
        }
        sum_arr(map);
        System.out.println(ans);


    }
    private static void print(int[][] tmp) {
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {
                System.out.print(tmp[i][j]+" ");
            }
            System.out.println();
        }

    }

    private static void sum_arr(int[][] tmp) {
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {
                if(tmp[i][j]!=-1)
                {
                    ans+=tmp[i][j];
                }
            }
        }

    }


    static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}