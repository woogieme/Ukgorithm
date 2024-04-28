package BOJ.Recur;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1992_쿼드트리 {
    static int N;
    static int[][] map;
    static int count;
    static ArrayList<Integer> ans = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map=new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] ch1 = sc.next().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j]=ch1[j]-'0';
            }
        }
        count=0;
        func(0,0,N,N);
    }

    private static void func(int si, int sj, int ei, int ej) {
        if(ei-si==1 ) {
            ans.add(map[si][sj]);
            return;
        }


        int mi = (si+ei)/2;
        int mj = (sj+ej)/2;

        func(si,sj,mi,mj); //현재 나의 1번영역
        func(si,mj,mi,ej); //현재 나의 2번영역
        func(mi,sj,ei,mj); //현재 나의 3번영역
        func(mi,mj,ei,ej); //현재 나의 4번영역

    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <N; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}