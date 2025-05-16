package BOJ.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549_숨바꼭질3 {

    static class Point {

        int idx; //현재 있는 위치
        int time; //얼마나 움직였는가

        Point(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }


    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] street = new int[100001];

        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(N, 0));
        int result = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.idx == M) {
                result = Math.min(result, p.time);
            }
            //-1 할때 시간초 증가
            if ((p.idx - 1) >= 0 && (p.idx - 1 <= 100000)) {
//                if (p.idx-1 == 39) {
//                    System.out.println("MINUS: p.idx=39: " + "p.time= "+p.time+" "+street[p.idx-1]);
//                }
                if (street[p.idx - 1] == 0) {
                    queue.add(new Point(p.idx - 1, p.time + 1));
                    street[p.idx - 1]=p.time;
                } else if (street[p.idx - 1] > p.time) {
                    street[p.idx - 1] = p.time + 1;
                    queue.add(new Point(p.idx - 1, p.time + 1));
                }
            }
            //+1 할때 시간초 증가
            if ((p.idx + 1) >= 0 && (p.idx + 1 <= 100000)) {
//                if (p.idx+1 == 39) {
//                    System.out.println("PLUS: p.idx=39: " + "p.time= "+p.time);
//                }
                if (street[p.idx + 1] == 0) {
                    queue.add(new Point(p.idx + 1, p.time + 1));
                    street[p.idx + 1]=p.time;
                } else if (street[p.idx + 1] > p.time) {
                    street[p.idx + 1] = p.time + 1;
                    queue.add(new Point(p.idx + 1, p.time + 1));
                }
            }

            //순간이동 => 0초
            if ((p.idx * 2) >= 0 && (p.idx * 2 <= 100000) && p.idx * 2 != 0) {
//                if (p.idx == 39) {
//                    System.out.println("MULPIFY: p.idx=39: " + "p.time= "+p.time+" ");
//                }
                queue.add(new Point(p.idx * 2, p.time));
            }
        }
        System.out.println(result);


    }
}
