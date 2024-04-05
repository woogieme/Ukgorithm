package CodeTree.BackTracking.ChooseNofK;

import java.util.*;
import java.io.*;

public class K개중하나N번선택하기 {
    static int K;
    static int N;
    static int[] arr;
    static boolean[] brr;
    static StringBuilder sb = new StringBuilder();
    static void perm(int cnt){

        if(cnt ==N) { //던져진 주사위가 목표수가 되었다면 더이상 던질 주사위 없음
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = 1; i <= K; i++) {
            arr[cnt] = i;
            //다음주사위던지러 가기
            perm(cnt+1);
        }

    }

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        perm(0);
        System.out.print(sb.toString());

    }
}