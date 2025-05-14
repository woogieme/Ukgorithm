package Programmers.Level2;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class 전력망_둘로_나누기 {

    static int[][] map;
    static boolean[][] checked;
    static int N;

    static int[][] electric;
    static int result=Integer.MAX_VALUE;


    static public int solution(int n, int[][] wires) {
        int answer = -1;

        N = n;
        map = new int[wires.length][wires[0].length];
        checked = new boolean[N + 1][N + 1];

        electric = new int[N + 1][N + 1];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = wires[i][j];
            }
        }


        //print();
        for (int i = 0; i < map.length; i++) { //8번을 돌아야함
            rollback();
            electric[map[i][0]][map[i][1]] = 0;
            electric[map[i][1]][map[i][0]] = 0;
            BFS(map[i][0]);
        }


        return result;
    }

    private static void BFS(int connect) {

        int count = 0; // 초기에 무조건 1개여야함 0개는 존재하지않음

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(connect);
        HashSet<Integer> hSet = new HashSet<>();
        hSet.add(connect);
        while (!queue.isEmpty()) {

            int number = queue.poll();
            hSet.add(number);
            for (int i = 1; i <= N; i++) {
                if (electric[number][i] == 1) {
                    electric[number][i]=0;

                    queue.add(i);
                }
            }
        }
        int tmpNumber = Math.abs(N-hSet.size());
        //System.out.println(N+" "+tmpNumber+" "+hSet.size());
        result = Math.min(result,Math.abs(Math.abs(hSet.size())-Math.abs(tmpNumber)));
        //System.out.println(result);


    }

    private static void print() {
        for (int i = 1; i < electric.length; i++) {
            for (int j = 1; j < electric[i].length; j++) {
                System.out.print(electric[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rollback() {

        for (int k = 0; k < map.length; k++) {
            electric[map[k][0]][map[k][1]] = 1;
            electric[map[k][1]][map[k][0]] = 1;
        }
    }

    private static void intialize() {

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = map[i][j];
            }
        }
    }

    public static void main(String[] args) {

        전력망_둘로_나누기 solution = new 전력망_둘로_나누기();

        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};


        int result = solution.solution(n, wires);

        System.out.println("result = " + result);


    }
}
