package BOJ.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;



public class BOJ_17472_다리만들기 {

    //N와 M은 가로 크기, 세로크기
    static int R;
    static int C;

    //지도 정보
    static int[][] map;

    //지도의 방문여부
    static boolean[][] visit;

    //상하좌우 판별여부
    static int[] di= {0,1,0,-1};
    static int[] dj= {1,0,-1,0};

    //지도의 N번째 섬
    static int[] disjoint;
    static PriorityQueue<Edge> pq;
    static int ans;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        R=sc.nextInt();
        C=sc.nextInt();

        map = new int[R][C];
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int landCnt=0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j]==1 && !visit[i][j]) {
                    landCnt++;
                    dfs(i,j,landCnt);
                }
            }
        }
        makeEdge();// 섬들이 상화좌우로 쭉뻗어서 다른 섬 만나면 간선이다 (다리후보)
        int mstSize=0;
        disjoint=new int[landCnt+1];
        for (int i = 0; i <=landCnt; i++) {
            disjoint[i]=i;
        }
        while(!pq.isEmpty() && mstSize <landCnt-1) {
            Edge edge = pq.poll();
            if(union(edge.n1,edge.n2)) {
                mstSize++;
                ans+=edge.weight;
            }
        }

        System.out.println(mstSize==landCnt-1? ans:-1);
    }

    private static void makeEdge() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j]>0) {
                    for (int d = 0; d < 4; d++) {
                        int nowi= i;
                        int nowj= j;
                        int dis=0; //뻗는 다리의 길이
                        int len=0;
                        while(true) {
                            int nexti = nowi+di[d];
                            int nextj = nowi+di[d];
                            if(nexti<0 ||  nexti>=R||  nextj<0 || nextj>=C || map[i][j]==map[nexti][nextj]) break;
                            //바다이면 일단 카운트해
                            if(map[nexti][nextj]==0) {
                                len++;
                                nowi=nexti;
                                nowj=nextj;
                            }
                            //바다도아니고 뛰쳐나가지도 않았다.
                            if(map[nexti][nextj]>0 && map[i][j]!=map[nexti][nextj]) {
                                if(len>=2) {
                                    pq.add(new Edge(map[i][j],map[nexti][nextj],len));
                                }
                                break;
                            }

                        }
                    }
                }
            }
        }

    }

    static int find(int num) {
        if(disjoint[num]==num) return num;
        return disjoint[num]=find(disjoint[num]);
    }

    static boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1==p2) return false;
        disjoint[p1]=p2;
        return true;

    }

    private static void dfs(int i, int j, int landCnt) {
        visit[i][j]=true;
        map[i][j]=landCnt;

        for (int d = 0; d < di.length; d++) {
            int nexti = i+di[d];
            int nextj = i+dj[d];

            if(nexti>=0 && nexti<R && nextj>=0 && nextj<R && map[nexti][nextj]==1 && !visit[nexti][nextj]) {
                dfs(nexti,nextj,landCnt);
            }
        }//모든 덩어리를 찾아서 번호를 붙여넣기


    }

    static class Edge implements Comparable<Edge>{
        int n1,n2,weight;

        @Override
        public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            return 0;
        }

        public Edge(int n1, int n2, int weight) {
            super();
            this.n1 = n1;
            this.n2 = n2;
            this.weight = weight;
        }
    }
}
