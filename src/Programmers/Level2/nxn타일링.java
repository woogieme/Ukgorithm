package Programmers.Level2;

import java.util.*;
class nxn타일링 {
    public int solution(int n) {
        long answer = 0;
        //2x1 직사각형

        //nx2 타일을 어떻게 채울것인가?

        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        //2x2 2가지방법
        //3x2 3가지방법
        //4x2 5가지방법
        //5x2
        if(n>=3){
            for(int i=3; i<=n; i++){
                dp[i]=dp[i-1]+dp[i-2];
                dp[i]%=1000000007;
            }
        }

        return dp[n];
    }
}