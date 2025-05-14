package Programmers.Level2;

import java.util.HashMap;
import java.util.Map;

class 땅따먹기 {
    static int[][] land;
    static int solution(int[][] land) {
        int answer = 0;

        for (int i = 1; i < land.length; i++) {
            print();
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (k == j) continue;
                    max = Math.max(max, land[i - 1][k]);
                }
                land[i][j] += max;
            }

        }


        for (int i = 0; i < 4; i++) {
            answer= Math.max(answer,land[land.length-1][i]);
        }

        return answer;
    }

    private static void print() {
        System.out.println("======================");
        for (int i = 0; i <land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                System.out.print(land[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }


    public static void main(String[] args) {
        땅따먹기 solution = new 땅따먹기();
        land = new int[][]{{4, 3, 2, 1}, {2, 2, 2, 1}, {6, 6, 6, 4}, {8, 7, 6, 5}};


        int result = 땅따먹기.solution(land);
        System.out.println(result);
    }
}