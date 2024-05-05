package BOJ.Cruskal;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17472_다리만들기2 {

    //N와 M은 가로 크기, 세로크기
    static int R;
    static int C;

    //지도 정보
    static int[][] map;

    //지도의 방문여부
    static boolean[][] visit;

    //상하좌우 판별여부
    static int[] dx= {0,1,0,-1};
    static int[] dy= {-1,0,1,0};

    //지도의 N번째 섬
    static int mt_front;

    //지도의 N번째 섬과 이어지는 다른 섬
    static int mt_back;

    //지도 N개의 섬 번호 부여
    static int landCnt;

    //노드 갯수, 간선 갯수
//	static int V,E;

    //노드갯수의 배열
    static int[] parents;

    //X섬 , Y섬, 가중치의 정보
    static ArrayList<Mountain> mt_Info =new ArrayList<>();

    //첫번째 섬의 임시 정보를 담아놓아서 똑같은 섬을 탐색하면안되기때문에 임시 변수를 만들어줌
    static int i_tmp;
    static int j_tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //가로, 세로 크기 입력
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());

        //지도 입력 정보 넣기
        map = new int[R][C];

        //간선갯수 초기화
//		E=0;

        //방문 초기화
        visit = new boolean[R][C];

        //N개의 섬 번호 부여 초기화
        landCnt=0;

        //노 개수 초기화
//		V=0;

        //맵 정보입력
        for (int i = 0; i < R; i++) {
            st =new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        //BFS를 통하여 섬 번호 부여
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j]==1 && !visit[i][j]) {
                    landCnt++; //다른섬의 다른번호
                    BFS(i,j,visit);
                }
            }
        }

        //isBridge를통하여 섬과 연결되어있는지아닌지 확인후, 연결되어있다면 연결처리
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                //0은 아직 방문하지않은 바다를의미
                if(map[i][j]!=0) {
                    //i번째 섬 번호를 찾았다면, mt_front에 정보 집어넣기
                    mt_front=map[i][j];
                    i_tmp=i;
                    j_tmp=j;
                    //i,j좌표 주변에 바다인지 체크하기
                    for (int d = 0; d < dx.length; d++) {
                        int nexti=i+dx[d];
                        int nextj=j+dy[d];

                        //사방탐색을 통해 바다라면 다른섬과 연결되어있는지 확인하는 로직
                        if(nexti>=0 && nexti<R &&nextj>=0 && nextj<C && map[nexti][nextj]==0 ) {
                            //바다있는 부분부터 검색시작
                            isBridge(d,nexti,nextj);
                        }
                    }
                }
            }
        }

        //크루스칼을 하기위해서 가중치 정렬
        Collections.sort(mt_Info);

        //크루스칼 시작
        makeSet();
        int result=0,  icount=0;
        for (int i = 0; i < mt_Info.size(); i++) {
            if(union(mt_Info.get(i).x,mt_Info.get(i).y)) {
                result+=mt_Info.get(i).weight;
                //icount가 노드의갯수라면 끝냄
                if(++icount==landCnt-1) {
                    break;
                }
            }
        }

        //간선의갯수가 노드갯수-1이 아니라면 하나로 연결되어있지 않는것을 의미
        if(icount!=landCnt-1) {
            System.out.println(-1);
        }
        else {
            System.out.println(result);
        }
    }

    //--------------------------------------------크루스칼 처리------------------------------------//
    static void makeSet() {
        //V는 노드의 갯수
        parents = new int[landCnt+1];
        for (int i = 0; i <parents.length; i++) {
            parents[i]=i;
        }
    }
    static int findSet(int a) {
        if(a==parents[a]) return a;
        return parents[a]=findSet(parents[a]);
    }

    static boolean union(int a,int b) {
        int aRoot=findSet(a);
        int bRoot=findSet(b);
        if(aRoot == bRoot) return false;
        parents[bRoot]=aRoot;
        //노드간의 연결되어있다는 의미이니 간선갯수 증가
//        E++;
        return true;
    }
    //--------------------------------------------다른 섬과 연결되어있는지체크 ------------------------------------//
    private static void isBridge(int d, int i, int j) {
        //바다에서 시작하는 로직이니 cnt는 1을 고정시켜준다.
        //바다에서 시작하지않으면 이 로직에 포함되지않는 부분이니까
        int land_bridge=1;
        while(true) {
            //직진을 할수있게끔 dx의 d값을 가져와 계속 직진한다.
            int nexti=i+dx[d];
            int nextj=j+dy[d];
            //범위를 벗어나거나 검색할려는 섬이 현재있는섬과 값이 똑같다면 예외처리
            //첫번째 섬의 임시 정보를 담아놓아서 똑같은 섬을 탐색하면안되기때문에 임시 변수를 만들어줌
            if(nexti<0 ||nexti>=R ||nextj<0 || nextj>=C || (map[nexti][nextj]!=0 && map[nexti][nextj]==map[i_tmp][j_tmp])) {
                break;
            }
            //다음값이 바다고 범위 안에들어가있다면
            if(nexti>=0 && nexti<R &&nextj>=0 && nextj<C && map[nexti][nextj]==0) {
                //cnt 증가 => 다리를 놓는과정
                land_bridge++;
                //i,j는 다음값으로 이동할수있게끔 만들어줌
                i=nexti;
                j=nextj;
                continue;
            }
            //다른 섬이라면???
            if(map[nexti][nextj]!=0) {
                //다른섬인것 체크
                mt_back=map[nexti][nextj];
                //1보다크다면  [ 섬과 연결이 되있는것을 중요시함 ]
                if(land_bridge>1) {
                    //두섬을 연결시켜준다는 의미와 함께 cnt[가중치]를 저장함
                    mt_Info.add(new Mountain(mt_front,mt_back,land_bridge));
                }
                break;
            }
        }
    }
    //--------------------------------------------BFS 체크 -------------------------------//
    private static void BFS(int i,int j,boolean[][] visited) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(i,j));
        //섬 번호를 부여한다.
        map[i][j]=landCnt;
        //이섬은 방문이 되어있음 안해도됨
        visited[i][j]=true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nexti=now.x+dx[d];
                int nextj=now.y+dy[d];
                if(nexti>=0 && nexti<R &&nextj>=0 && nextj<C && map[nexti][nextj]==1 && !visited[nexti][nextj]) {
                    queue.add(new Point(nexti,nextj));
                    //인접해있는 섬 번호를 똑같이 부여함
                    map[nexti][nextj]=landCnt;
                    //이것또한 방문처리
                    visited[nexti][nextj]=true;
                }
            }

        }


    }
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Mountain implements Comparable<Mountain> {
        int x;
        int y;
        int weight;
        public Mountain(int x, int y, int weight) {
            super();
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
        @Override
        public int compareTo(Mountain o) {
            return this.weight - o.weight;
        }


    }
}
