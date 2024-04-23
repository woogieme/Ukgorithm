package BOJ.DP;

import java.util.Arrays;
import java.util.Scanner;

public class DP_Fibonacci {
    private static long callCnt1;

    private static long fibo1(int n) {
        callCnt1++;
        if(n<=1) return n;

        return fibo1(n-1)+fibo1(n-2);
    }

    //n항에 대한 값을 메모
    //n(index): 원소(값)

    private static long[] memo;

    private static long fibo2(int n) {
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        memo = new long[n+1];
        Arrays.fill(memo, -1);

        memo[0]= 0;
        memo[1]=1;
        System.out.println(fibo1(n));

    }
}
