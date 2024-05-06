package BOJ.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_17135_캐슬디펜스 {
    static int[][] origin, copy;
    static int N, M , D;
    static int ans; //답
    static boolean[] select; //궁수위치 기록할 조합 기록용 배열

    static int[] di = { 0,-1,0}; //왼 ,위, 오 순서로 탐색
    static int[] dj = { -1,0,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        D=sc.nextInt();
        origin = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                origin[i][j]=sc.nextInt();
            }
        }

        select = new boolean[M];
        ans =0;
        comb(0,0);
        System.out.println(ans);
    }

    static void comb(int idx, int cnt) {
        if(cnt==3) { //궁수 자리 선정 완료.
            //시뮬레이션
            copy = deepcopy(origin);
            int score=0; //현재 궁수 배치로 점수 몇점나오는지 해보자.
            for (int turn = 0; turn < N; turn++) { //한줄씩 내려오니까 N번 내려오면 모든 적 내려옴
                //궁수들이 각자 쏴죽일놈을 찾아서 쏴야함
                score +=attack();
                move(); // 적들이 한줄 내려옴
            }
            ans=Math.max(score, ans);
            return;
        }
        if(idx==M) return; //앞에 재귀들이 false, false 하는 바람에 3칸을 못채웠다.

        select[idx]=true;
        comb(idx+1,cnt+1);
        select[idx]=false;
        comb(idx+1,cnt);
    }

    private static void move() {
        for (int i = N-1; i >0; i--) {
            for (int j = 0; j <M; j++) {
                copy[i][j]=copy[i-1][j];
            }
        }
        Arrays.fill(copy[0],0);

    }

    private static int attack() {
        // 각각의 궁수를 집어넣고 BFS를 3번을 돌린다
        int score=0;
        for (int j = 0; j < M; j++) {
            if(select[j]) {//궁수자리 찾았다 !
                Queue<Point> queue = new LinkedList<>(); // 여기는 궁수 사거리 내의 좌표들이 가까운 순서대로 들어감.
                PriorityQueue<Point> enemy = new PriorityQueue<>();
                boolean[][] visit = new boolean[N][M];

                queue.add(new Point(N,j));//N번행은 없는 행임.

                int dist=0; //큐에 들어있는 애들이 궁수로부터 얼마나 떨어진 좌표인지
                while(!queue.isEmpty() && dist<=D) { //현재 큐에 잇는 좌표들이 궁수로부터 dist만큼 떨어져있음
                    int size= queue.size(); //현재 거리가 dist 인 좌표 몇개인지 체크해서
                    for (int s = 0; s < size; s++) {  //걔네를 뺐으면
                        Point now = queue.poll();

                        if(now.i<N && now.j>M && copy[now.i][now.j]==1) { //지금 큐에 있는 애들은 궁수로부터 거리가 dist인 애들임. 그중 적있으면 일단 모아
                            enemy.add(now);
                        }
                        for (int d = 0; d < di.length; d++) {
                            int nexti = now.i+di[d];
                            int nextj = now.j+dj[d];
                            if(nextj>=0 &&nexti >=0 && nexti<N && nextj<M && !visit[nexti][nextj]) {
                                visit[nexti][nextj]=true;
                                queue.add(new Point(nexti,nextj));
                            }
                        }
                    }
                    if(!enemy.isEmpty()) { //방금 궁수로부터 거리가 dist인 애들 다 뺐는데, 혹시 쏴죽일놈 있었나?
                        Point target = enemy.poll(); //PQ라서 제일 왼쪽놈이 알아서 나옴
                        copy[target.i][target.j]=7;
                        break; //while을 중단함. 즉 현 재 궁수가 탐색을 중단함. 쏴죽일놈 찾은거임
                    }
                    dist++; //이제 큐에 잇는건 dist인 애들이 +1해서 거리 한칸 멀어진 애들이 남아있음. 즉 거리 ++
                }//현재 궁수 탐색 종료
                //여기서 적ㅆ ㅘ죽이면안됨 !!!!

            }
        }//여기서 세명 다 타겟 찾았음
        //여기서 죽여야함

        for (int i = 0; i < N; i++) {//여기서 최대 3명이고 , 어쩔땐 0,1,2겠지 , 암튼 적을 동시에 쏴죽임.
            for (int j = 0; j < M; j++) {
                if(copy[i][j]==7) {
                    copy[i][j]=0;
                    score++;
                }
            }
        }
        return score;
    }

    private static int[][] deepcopy(int[][] arr) {
        // TODO Auto-generated method stub
        int[][] tmp = new int[arr.length][arr[0].length];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j]=arr[i][j];
            }
        }
        return tmp;
    }

    private static void print(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    static class Point implements Comparable<Point>{
        //더 왼쪽에있는애가 나왔으면 좋으니까 Comparable가 있다
        int i,j;

        public Point(int i, int j) {
            super();
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Point o) {
            // TODO Auto-generated method stub
            return this.j-o.j;
//			if(this.dist ==o.dist) {
//				return this.j -o.j;
//			}
//			return this.dist - o.dist;
        }


    }
}